package mx.com.itam.drachma;

import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.openunirest.http.Unirest;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@ServerEndpoint("/data")
public class NewDataEndPoint {
    private static final Set<Session> handler = new HashSet<>();
    private static final Gson gson = new GsonBuilder().create();
    
    @OnOpen
    public void open(Session session){
        //System.out.println("Alguien se conecto: " + session.getId());
        //Se agregan algunos valores a la session
        session.getUserProperties().put("alerta", new Alerta());
        
        //Request para informacion sobre las ultimas 24 horas
        String request = "https://api.binance.com/api/v1/ticker/24hr?symbol=BTCUSDT";
        String ans = Unirest.get(request).asJson().getBody().toString();
        
        //Guardamos el JSON en data, para luego accesar los datos relevantes
        Properties data = gson.fromJson(ans, Properties.class);
        
        //Guardamos los datos relevantes (precio de apertura, promedio y ultimo precio)
        session.getUserProperties().put("apertura", Double.parseDouble(data.getProperty("openPrice")));
        session.getUserProperties().put("promedio", Double.parseDouble(data.getProperty("weightedAvgPrice")));
        session.getUserProperties().put("lastPrice", Double.parseDouble(data.getProperty("lastPrice")));
        
        handler.add(session);
    }
    
    
    /**
     * Maneja los mensajes con el servidor
     * 
     * @param session
     * @param msg - Mensaje en formato JSON
     */
    @OnMessage
    public void onMessage(Session session, String msg) {
        //System.out.println("Recibi mensaje:\n" + msg);
        Properties info = gson.fromJson(msg, Properties.class);
        Alerta a = (Alerta) session.getUserProperties().get("alerta");
        
        switch( info.getProperty("type") ){
            case "update":
                
                //Conseguir nuevo precio, regresar json con precio + recomendacion
                String request = "https://api.binance.com/api/v1/ticker/price?symbol=" + a.getSimbolo();
                String ans = Unirest.get(request).asJson().getBody().toString();
                
                Properties data = gson.fromJson(ans, Properties.class);
                double price = Double.parseDouble(data.getProperty("price"));
                double cambio = 1 - ((double)session.getUserProperties().get("lastPrice"))/price;
                a.calculaAccion(((double)session.getUserProperties().get("apertura")), ((double)session.getUserProperties().get("promedio")), price, cambio);
                
                session.getUserProperties().put("lastPrice", price);
                try {
                    String response = "{ type : update, price : " + price + ", recomendacion: "+gson.toJson(a)+"}";
                    session.getBasicRemote().sendText(response);
                } catch (IOException ex) {
                    Logger.getLogger(NewDataEndPoint.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            case "change":
                //Cambiar informacion, posibles otros parametros a cambiar: simbolo, sensitividad
                if(info.containsKey("simbolo")){
                    a.setSimbolo(info.getProperty("simbolo"));
                }
                if(info.containsKey("sensitividad")){
                    a.setSensitividad(Double.parseDouble(info.getProperty("sensitividad")));
                }
                
                try {
                    String resp = "{ type : change, newAlert: "+gson.toJson(a)+"}";
                    session.getBasicRemote().sendText(resp);
                } catch (IOException ex) {
                    Logger.getLogger(NewDataEndPoint.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
        }
        
    }

    @OnError
    public void error(Session session, Throwable t) {
        
    }

    @OnClose
    public void closedConnection(Session session) {
        handler.remove(session);
    }
}
