import com.google.gson.Gson;

public class Alerta(){
    private String simbolo, accion;
    private Double confianza;
    
    /**
    * Constructor basico para la alerta.
    * 
    * @param simbolo - simbolo
    */
    public Alerta(String simbolo){
        this.simbolo = simbolo;
        recomendacion = new HashMap<String, Object>();
    }
    
    /**
    * Setter para el atributo simbolo.
    *
    * @param simbolo - Nuevo simbolo
    */
    public void setsimbolo(String simbolo){
        this.simbolo = simbolo;
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
        
        //Consideraciones para determinar la accion
        if(promedio >= apertura){
            //Si el promedio esta por arriba del precio de apertura, vemos la posicion del precio
            if(actual > promedio){
                //Si el precio es mayor al promedio, se compra si esta subiendo el precio y se vende si esta bajando
                if(cambio > 0){
                    accion = "Comprar";
                }
                else{
                    accion = "Vender";
                }
            }else{
                //Si el precio es menor al promedio, se compra si esta subiendo el precio y se espera si esta bajando
                if(cambio > 0){
                    accion = "Comprar";
                }
            }
        }else{
            //Si el promedio esta por debajo del precio de apertura, vemos la posicion del precio
            if(actual >= promedio){
                //Si el precio es mayor al promedio, se espera si esta subiendo el precio y se vende si esta bajando
                if(cambio < 0){
                    accion = "Vender";
                }
            }else{
                //Si el precio es menor al promedio, se compra si esta subiendo el precio y se vende si esta bajando
                if(cambio < 0){
                    accion = "Vender";
                }else{
                    accion = "Comprar";
                }
            }
        }
        
        return accion;
    }
    
    /**
    * Confianza de la recomendacion dada, tomando en cuenta la magnitud 
    * del cambio. Algunos valores notables:
    *     abs(cambio) = 0.001 -> confianza ~9%
    *     abs(cambio) = 0.005 -> confianza ~40%
    *     abs(cambio) = 0.01  -> confianza ~63%
    *     abs(cambio) = 0.05  -> confianza ~95%
    *
    * @param cambio - Cambio reciente del precio en porcentaje.
    *
    * @return accion - Accion recomendada.
    */
    public Double calculaConfianza(Double cambio){
        
        Double confianza = 1 - 1.0/Math.exp(100*Math.abs(cambio));
        
        return confianza;
    }
    
    /**
    * Genera una recomendacion, haciendo un request al API REST de binance para
    * obtener datos del momento y las funciones calculaAccion y calculaConfianza
    * para determinar la recomendacion. Regresa el objeto en formato JSON.
    * 
    * @return recomendacion - Recomendacion en formato JSON.
    */
    public String recomendacion(){
        
        //Request para informacion sobre las ultimas 24 horas
        String request = "https://api.binance.com/api/v1/ticker/24hr?symbol=" + this.simbolo;
        
        Double apertura = 0;
        Double promedio = 0;
        
        
        //Request para informacion sobre los ultimos 500 trades
        String request = "https://api.binance.com/api/v1/trades?symbol=" + this.simbolo;
        
        Double actual = 0;
        Double cambio = 0;
        
        //Guardar la accion en el atributo accion
        this.accion = calculaAccion(apertura, promedio, actual, cambio);
        //Guardar la confianza en el atributo confianza
        this.confianza = calculaConfianza(cambio);
        
        //Construye un JSON a partir de si mismo
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        
        return gson.toJson(this);
    }
}