package mx.com.itam.adsi.drachma.mail;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestSendMail {
    private final static Logger LOG = Logger.getLogger(TestSendMail.class);
    
    

    private static String direc = "";
    

    private SendMail msgBuenoCorreoBueno = new SendMail("adsi.itam.03@gmail.com",0);
    private SendMail msgMaloCorreoBueno = new SendMail("adsi.itam.03@gmail.com",1);
    private SendMail msgBuenoCorreoMalo = new SendMail("adsi.itam.03@",0);
    private SendMail msgMaloCorreoMalo = new SendMail("adsi.itam.03@",1);

    @Test
    public void mensaje1() {
	LOG.info("Ejecutando la prueba 1");
	LOG.info("Correo bueno, sube precio");	
	boolean resp = msgBuenoCorreoBueno.enviaMail();
	assertTrue("Envió correo 1:", calc(true, resp));
    }
    
    @Test
    public void mensaje2() {
	LOG.info("Ejecutando la prueba 2");
	LOG.info("Correo bueno, baja precio");	
	boolean resp = msgMaloCorreoBueno.enviaMail();
	assertTrue("Envió correo 2:", calc(true, resp));
    }

    @Test
    public void mensaje3() {
	LOG.info("Ejecutando la prueba 3");
	LOG.info("Correo malo, sube precio");	
	boolean resp = msgBuenoCorreoMalo.enviaMail();
	assertTrue("Envió correo 3:", calc(false, resp));
    }

    @Test
    public void mensaje4() {
	LOG.info("Ejecutando la prueba 4");
	LOG.info("Correo malo, sube precio");	
	boolean resp = msgMaloCorreoMalo.enviaMail();
	assertTrue("Envió correo 4:", calc(false, resp));
    }

    private boolean calc(boolean r1, boolean r2) {
	return r1 == r2;
    }

}
