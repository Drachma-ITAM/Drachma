/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.itam.drachma;

/**
 *
 * @author andreamarin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        String[] simbolo  = {"BTCUSDT"};
        Klineplot bp = new Klineplot();
        
        
        bp.getData(simbolo,2);
        String s2 = bp.formatData();
        
    }
    
}
