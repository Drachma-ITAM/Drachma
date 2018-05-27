package mx.com.itam.drachma;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.Map;


public class UtilesTest{


	@Test 
	public void getParamsTest(){
		String prueba = "k1=v1&k2=v2";
		Map<String, String> res = Utiles.getParams(prueba);
		assertTrue("Validacion parametros get: ",res.get("k1").equals("v1")&&res.get("k2").equals("v2"));

	}

	@Test
	public void getParamsNuloTest(){
		String prueba = "";
		Map<String, String> res = Utiles.getParams(prueba);
		assertTrue("Validacion parametros get: ",res==null);

	}

	@Test 
	public void issetTest(){
		String prueba = "k1=v1&k2=v2";
		Map<String, String> res = Utiles.getParams(prueba);
		String[] keys = {"k1", "k2"};
		assertTrue("Isset test: ",Utiles.isset(res,keys));

	}

	@Test 
	public void issetTestParametroFaltante(){
		String prueba = "k2=v2";
		Map<String, String> res = Utiles.getParams(prueba);
		String[] keys = {"k1", "k2"};
		assertTrue("Isset test: ",!Utiles.isset(res,keys));

	}


}