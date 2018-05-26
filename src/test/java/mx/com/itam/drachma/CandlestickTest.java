/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.itam.drachma;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andreamarin
 */
public class CandlestickTest {
    private final Logger LOG = Logger.getLogger(CandlestickTest.class);
    private final Candlestick CS = new Candlestick();
    
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class");
    }
    
    @Before
    public void before(){
        System.out.println("Before Test Case");
    }
    
    /**
     * Test of setOpenTime method, of class Candlestick.
     */
    @org.junit.Test
    public void testSetOpenTime() {
        LOG.info("Ejecutando prueba de setFecha");
        
        String timestamp = "1525132800000";
        CS.setFecha(timestamp);
        String fecha = CS.getFecha();
        LOG.info(fecha);
        assertTrue(fecha.equals("30/04/2018"));
        
        timestamp = "1522540800000";
        CS.setFecha(timestamp);
        fecha = CS.getFecha();
        LOG.info(fecha);
        assertTrue(fecha.equals("31/03/2018"));
        
        timestamp = "1527363587287";
        CS.setFecha(timestamp);
        fecha = CS.getFecha();
        LOG.info(fecha);
        assertTrue(fecha.equals("26/05/2018"));
        
        timestamp = "613526400000";
        CS.setFecha(timestamp);
        fecha = CS.getFecha();
        LOG.info(fecha);
        assertTrue(fecha.equals("10/06/1989"));
        
        timestamp = "1226707200000";
        CS.setFecha(timestamp);
        fecha = CS.getFecha();
        LOG.info(fecha);
        assertTrue(fecha.equals("14/11/2008"));
        
        timestamp = "911606400000";
        CS.setFecha(timestamp);
        fecha = CS.getFecha();
        LOG.info(fecha);
        assertTrue(fecha.equals("20/11/1998"));
        
        timestamp = "972518400000";
        CS.setFecha(timestamp);
        fecha = CS.getFecha();
        LOG.info(fecha);
        assertTrue(fecha.equals("25/10/2000"));
    }
    
    @After
    public void after() {
        System.out.println("After Test Case");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }
    
}
