package mx.com.itam.drachma;

import org.apache.log4j.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ValidacionMailTest {
	private final static Logger LOG = Logger.getLogger(ValidacionMailTest.class);
	   

    private ValidacionMail v = new ValidacionMail();

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @Before
    public void before() {
        System.out.println("Before Test Case");
    }

    @Test
    public void isCorrectCalcTest() {
        String val="";
        LOG.info("Ejecutando la prueba");
        
        val= "adsi.itam@itam.mx";
        assertTrue("validación para: "+val+" ", val(val,true));
        val="c-e.@.fn";
        assertTrue("validación para: "+val+" ", val(val,false));
    }
    
    private  boolean val(String val,boolean res) {
        boolean calc = v.validar(val);
        System.out.println(calc);
        return res==calc;
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
