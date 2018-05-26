package mx.com.itam.drachma;

import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author Drachma
 */
public class Boxplot {
    private String url;
    private final Logger LOG;
    private Map<String,String[]> inputMap;
    private Map<String,Candlestick[]> datos;
    
    /**
     * Constructor vacío de la clase Boxplot
     */
    public Boxplot(){ // throws IOException{
        
        // se inicializa el logger
        LOG = Logger.getLogger(Boxplot.class.getName());
        
        this.url="https://api.binance.com";
        
        inputMap = new HashMap<>();
        datos = new HashMap<>();
    }
    
    /**
     * Obtiene los datos de los símbolos requeridos desde la API
     * @param simbolos - símbolos de las criptomonedas
     * @param lim - número de días por los que se quieren sacar los datos
     */
    public void getData(String[] simbolos,int lim){
        URL obj;
        HttpsURLConnection con;
        int responseCode;
        String url_aux;
        
        for (String simb : simbolos) {
            // obtiene los valores por un mes
            url_aux = url+"/api/v1/klines?symbol="+simb+"&interval=1d&limit="+lim;
            
            try {
                
                obj = new URL(url_aux);
            
                con = (HttpsURLConnection) obj.openConnection();
                
                con.setRequestMethod("GET");
                
                if(con.getResponseCode() == 200){ // verifica que el request haya sido exitoso
                    LOG.info("Conexión exitosa");
                    
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String inputLine;
                    
                    StringBuilder content = new StringBuilder();
                    
                    // obtiene el resultado
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                   
                    String info = content.toString().substring(1, content.toString().length());
                    
                    String[] aux = info.split("[\\[\\]]"); // divide la cadena 
                    aux = (String[]) ArrayUtils.removeElement(aux,","); // elimina las comas
                    aux = (String[]) ArrayUtils.removeElement(aux,""); // elimina los elementos en blanco
                    
                    inputMap.put(simb, aux);
                }else
                    LOG.error("Error con el request");
                        
            } catch (MalformedURLException ex) {
                LOG.error("Error en el URL"+ex); // error si el URL está mal
            } catch (IOException e){
                LOG.error("No se pudo establecer la conexión"+e);  // manda error si no puede establecer la conexión
            }  
        }
        
    }
    
    /**
     * Formatea los datos para poder hacer las gráficas. 
     * Crea objetos json con los datos necesarios
     * @return regresa los datos de las criptomonedas en formato json
     */
    public String formatData(){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Set<String> nombres = inputMap.keySet();
        
        // Recorre el set con las llaves del mapa
        nombres.forEach((String nombre) -> {
            String[] aux = inputMap.get(nombre);
            Candlestick[] datos_aux = new Candlestick[aux.length];
            int i = 0;
            
            for (String data : aux) {
                String[] s = data.split(",");
                
                double open = Double.parseDouble(s[1].replace("\"", ""));
                double high = Double.parseDouble(s[2].replace("\"", ""));
                double low = Double.parseDouble(s[3].replace("\"", ""));
                double close = Double.parseDouble(s[4].replace("\"", ""));
                
                Candlestick cs = new Candlestick(open,high,low,close);
                
                //checa si el precio de cierre fue mayor al precio de apertura
                if(cs.getOpen() < cs.getClose())
                    cs.setUp(true); 
                else
                    cs.setUp(false);
                
                cs.setOpenTime(s[0]); // guarda la fecha
                
                // guarda el objeto en el arreglo
                datos_aux[i] = cs;
                
                i++;
            }
            
            datos.put(nombre, datos_aux);
        });
        
        return new Gson().toJson(datos);
    }
    
    
}
