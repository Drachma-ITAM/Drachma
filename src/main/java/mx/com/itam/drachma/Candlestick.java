/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.itam.drachma;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author drachma
 */
public class Candlestick {
    private String fecha;
    private double open, high, low, close;
    private boolean up;
    
    /**
     * Constructor vacío para la clase Candlestick
     */
    public Candlestick(){
        
    }
    
    /**
     * Constructor para la clase Candlestick
     * @param open - precio a la apertura
     * @param high - precio más alto
     * @param low - precio más bajo
     * @param close - precio al cierre
     */
    public Candlestick(double open, double high, double low, double close){
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getClose() {
        return close;
    }

    public boolean getUp() {
        return up;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    /**
     * Guarda el valor de "up".
     * true: si el precio de apertura es menor que el de cierre
     * false: si el precio de cierre es menor que el de apertura
     * @param up 
     */
    public void setUp(boolean up) {
        this.up = up;
    }
    
    /**
     * Convierte la fecha de milisegundos a dd/MM/yy
     * @param millisecondsTime - fecha en milisegundos
     */
    public void setFecha(String millisecondsTime){
        //convierte el timestamp a formato long
        long timeStamp = Long.parseLong(millisecondsTime);
        
        // formato de la fecha
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp); // guarda la fecha en milisengundos
        
        this.fecha = formatter.format(calendar.getTime());   
    }
    
}
