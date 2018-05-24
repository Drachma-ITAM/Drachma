package mx.com.itam.drachma;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.openunirest.http.Unirest;
import java.util.Properties;

public class Alerta{
    private String simbolo, accion;
    private double sensitividad;
    
    /**
    * Constructor vacio para la alerta.
    */
    public Alerta(){
        this.simbolo = "BTCUSDT";
        this.sensitividad = 0.01;
    }
    
    /**
    * Constructor con simbolo para la alerta.
    * 
    * @param simbolo - simbolo
    */
    public Alerta(String simbolo){
        this.simbolo = simbolo;
        this.sensitividad = 0.01;
    }
    
    /**
    * Constructor con simbolo y sensitividad para la alerta.
    * 
    * @param simbolo - simbolo a monitorear
    * @param sensitividad - sensitividad al cambio
    */
    public Alerta(String simbolo, double sensitividad){
        this.simbolo = simbolo;
        this.sensitividad = sensitividad;
    }
    
    /**
    * Setter para el atributo simbolo.
    *
    * @param simbolo - Nuevo simbolo
    */
    public void setSimbolo(String simbolo){
        this.simbolo = simbolo;
    }
    
    /**
    * Getter para el atributo simbolo.
    *
    * @return simbolo - Simbolo de la alerta
    */
    public String getSimbolo(){
        return simbolo;
    }
    
    /**
    * Setter para el atributo sensitividad.
    *
    * @param sensitividad - Nueva sensitividad
    */
    public void setSensitividad(double sensitividad){
        this.sensitividad = sensitividad;
    }
    
    /**
    * Getter para el atributo sensitividad.
    *
    * @return sentsitividad - Sensitividad de la alerta
    */
    public double getSensitividad(){
        return sensitividad;
    }
    
    /**
    * Recomienda que accion tomar con respecto a alguna criptomoneda,
    * tomando en cuenta su precio de apertura, promedio reciente, precio
    * actual.
    *
    * @param apertura - Precio de apertura.
    * @param promedio - Precio promedio reciente.
    * @param actual - Precio actual.
    * @param cambio - Cambio reciente del precio en porcentaje.
    *
    * @return accion - Accion recomendada.
    */
    public String calculaAccion(Double apertura, Double promedio, Double actual, Double cambio){
        String accion = "Esperar";
        
        //Consideraciones para determinar la accion. Solo se toma accion si abs(cambio)>abs(sensitividad)
        if(promedio >= apertura){
            //Si el promedio esta por arriba del precio de apertura, vemos la posicion del precio
            if(actual > promedio){
                //Si el precio es mayor al promedio, se compra si esta subiendo el precio y se vende si esta bajando
                if(cambio > sensitividad){
                    accion = "Comprar";
                }
                else if(cambio < -sensitividad){
                    accion = "Vender";
                }
            }else{
                //Si el precio es menor al promedio, se compra si esta subiendo el precio y se espera si esta bajando
                if(cambio > sensitividad){
                    accion = "Comprar";
                }
            }
        }else{
            //Si el promedio esta por debajo del precio de apertura, vemos la posicion del precio
            if(actual >= promedio){
                //Si el precio es mayor al promedio, se espera si esta subiendo el precio y se vende si esta bajando
                if(cambio < -sensitividad){
                    accion = "Vender";
                }
            }else{
                //Si el precio es menor al promedio, se compra si esta subiendo el precio y se vende si esta bajando
                if(cambio < -sensitividad){
                    accion = "Vender";
                }else if(cambio > sensitividad){
                    accion = "Comprar";
                }
            }
        }
        
        return accion;
    }
    
    /**
    * Genera una recomendacion, haciendo un request al API REST de binance para
    * obtener datos del momento y las funciones calculaAccion y calculaConfianza
    * para determinar la recomendacion. Regresa el objeto en formato JSON.
    * 
    * @return recomendacion - Recomendacion en formato JSON.
    */
    public String recomendacion(){
        //Construye un gson para utilizar en el metodo
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        
        //Request para informacion sobre las ultimas 24 horas
        String request = "https://api.binance.com/api/v1/ticker/24hr?symbol=" + this.simbolo;
        String ans = Unirest.get(request).asJson().getBody().toString();
        
        //Guardamos el JSON en data, para luego accesar los datos relevantes
        Properties data = gson.fromJson(ans, Properties.class);
        
        //Tomamos los datos relevantes
        Double apertura = Double.parseDouble(data.getProperty("openPrice"));
        Double promedio = Double.parseDouble(data.getProperty("weightedAvgPrice"));
        
        
        //Request para informacion sobre los ultimos 500 trades
        request = "https://api.binance.com/api/v1/trades?symbol=" + this.simbolo;
        
        //Request para informacion sobre las ultimas 24 horas
        ans = Unirest.get(request).asJson().getBody().toString();
        
        //Guardamos el JSON en data2, para luego accesar los datos relevantes
        Properties[] data2 = gson.fromJson(ans, Properties[].class);
        
        //Precio actual es el ultimo elemento del arreglo de JSONs, cambio se calcula como 1 - inicial/final
        Double actual = Double.parseDouble(data2[499].getProperty("price"));
        Double cambio = 1 - Double.parseDouble(data2[0].getProperty("price"))/actual;
        
        //Guardar la accion en el atributo accion
        this.accion = calculaAccion(apertura, promedio, actual, cambio);
        
        //Rergresa el objeto en formato JSON
        return gson.toJson(this);
    }
    
    
}