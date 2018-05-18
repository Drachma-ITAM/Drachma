import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAlerta{
    private final static Logger LOG = Logger.getLogger(TestSolucion.class);
    private Alerta al = new Alerta('BTCUSDT')
    
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
        LOG.info("Ejecutando la prueba");
        
        apertura = 0;
        promedio = 0;
        actual = 0;
        cambio = 0;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        assertTrue(mensaje, al.calculaAccion.equals("Esperar"));
        
        apertura = 0;
        promedio = 5;
        actual = 3;
        cambio = 0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        assertTrue(mensaje, al.calculaAccion.equals("Comprar"));
        
        apertura = 0;
        promedio = 5;
        actual = 3;
        cambio = -0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        assertTrue(mensaje, al.calculaAccion.equals("Esperar"));
        
        apertura = 0;
        promedio = 5;
        actual = 8;
        cambio = 0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        assertTrue(mensaje, al.calculaAccion.equals("Comprar"));
        
        apertura = 0;
        promedio = 5;
        actual = 8;
        cambio = -0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        assertTrue(mensaje, al.calculaAccion.equals("Vender"));
        
        apertura = 0;
        promedio = -5;
        actual = -1;
        cambio = 0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        assertTrue(mensaje, al.calculaAccion.equals("Esperar"));
        
        apertura = 0;
        promedio = -5;
        actual = -1;
        cambio = -0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        assertTrue(mensaje, al.calculaAccion.equals("Vender"));
        
        apertura = 0;
        promedio = -5;
        actual = -8;
        cambio = -0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        assertTrue(mensaje, al.calculaAccion.equals("Vender"));
        
        apertura = 0;
        promedio = -5;
        actual = -8;
        cambio = 0.1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        assertTrue(mensaje, al.calculaAccion.equals("Comprar"));
        
        apertura = 0;
        promedio = 0;
        actual = 0;
        cambio = 1;
        mensaje = "Probando con los siguientes datos: \nApertura: " + apertura.toString();
        mensaje += "\nPromedio: " + promedio.toString();
        mensaje += "\nActual: " + actual.toString();
        mensaje += "\nCambio: " + cambio.toString();
        assertTrue(mensaje, al.calculaAccion.equals("Comprar"));
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