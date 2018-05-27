package mx.com.itam.drachma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.log4j.Logger;

public class AlertaTest {
    private final static Logger LOG = Logger.getLogger(AlertaTest.class);
    private final Alerta al = new Alerta("BTCUSDT", 0.01);
    
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @Before
    public void before() {
        System.out.println("Before Test Case");
    }

    @Test
    public void calculaAccionTest() {
        Double apertura, promedio, actual, cambio;
        String mensaje;
        LOG.info("Ejecutando la prueba de calculaAccion");
        
        apertura = 0.0;
        promedio = 0.0;
        actual = 0.0;
        cambio = 0.0;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        LOG.info(mensaje);
        assertTrue(al.calculaAccion(apertura, promedio, actual, cambio).equals("Esperar"));
        
        apertura = 0.0;
        promedio = 5.0;
        actual = 3.0;
        cambio = 0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        LOG.info(mensaje);
        assertTrue( al.calculaAccion(apertura, promedio, actual, cambio).equals("Comprar"));
        
        apertura = 0.0;
        promedio = 5.0;
        actual = 3.0;
        cambio = -0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        LOG.info(mensaje);
        assertTrue(al.calculaAccion(apertura, promedio, actual, cambio).equals("Esperar"));
        
        apertura = 0.0;
        promedio = 5.0;
        actual = 8.0;
        cambio = 0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        LOG.info(mensaje);
        assertTrue(al.calculaAccion(apertura, promedio, actual, cambio).equals("Comprar"));
        
        apertura = 0.0;
        promedio = 5.0;
        actual = 8.0;
        cambio = -0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        LOG.info(mensaje);
        assertTrue(al.calculaAccion(apertura, promedio, actual, cambio).equals("Vender"));
        
        apertura = 0.0;
        promedio = -5.0;
        actual = -1.0;
        cambio = 0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        LOG.info(mensaje);
        assertTrue(al.calculaAccion(apertura, promedio, actual, cambio).equals("Esperar"));
        
        apertura = 0.0;
        promedio = -5.0;
        actual = -1.0;
        cambio = -0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        LOG.info(mensaje);
        assertTrue(al.calculaAccion(apertura, promedio, actual, cambio).equals("Vender"));
        
        apertura = 0.0;
        promedio = -5.0;
        actual = -8.0;
        cambio = -0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        LOG.info(mensaje);
        assertTrue(al.calculaAccion(apertura, promedio, actual, cambio).equals("Vender"));
        
        apertura = 0.0;
        promedio = -5.0;
        actual = -8.0;
        cambio = 0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        LOG.info(mensaje);
        assertTrue(al.calculaAccion(apertura, promedio, actual, cambio).equals("Comprar"));
        
        apertura = 0.0;
        promedio = 0.0;
        actual = 0.0;
        cambio = 1.0;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        LOG.info(mensaje);
        assertTrue(al.calculaAccion(apertura, promedio, actual, cambio).equals("Comprar"));
        
        apertura = 0.0;
        promedio = -5.0;
        actual = -8.0;
        cambio = 0.001;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        LOG.info(mensaje);
        assertTrue(al.calculaAccion(apertura, promedio, actual, cambio).equals("Esperar"));
        
        apertura = 10.0;
        promedio = 5.0;
        actual = -8.0;
        cambio = 0.001;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        LOG.info(mensaje);
        assertTrue(al.calculaAccion(apertura, promedio, actual, cambio).equals("Esperar"));
        
        apertura = 0.0;
        promedio = 5.0;
        actual = 8.0;
        cambio = 0.001;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        LOG.info(mensaje);
        assertTrue(al.calculaAccion(apertura, promedio, actual, cambio).equals("Esperar"));
        
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
