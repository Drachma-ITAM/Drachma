package mx.com.itam.drachma;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 */
@SuppressWarnings("restriction")
public class RutaDos implements HttpHandler {
	
	private static final String F_NAME = "fname";
	private static final String L_NAME = "lname";
	
	private static final int PARAM_NAME_IDX = 0;
	private static final int PARAM_VALUE_IDX = 1;
	
	private static final int HTTP_OK_STATUS = 200;
	
	private static final String AND_DELIMITER = "&";
	private static final String EQUAL_DELIMITER = "=";
	
	public void handle(HttpExchange t) throws IOException {

		
		Map<String, String> get = Utiles.getParams(t.getRequestURI().getQuery());
		String[] params = {"nom", "apel"};
		if(Utiles.isset(get,params)){

			String res = "Adios"+get.get("nom")+get.get("apel");
			t.sendResponseHeaders(HTTP_OK_STATUS, res.getBytes().length);
			//Write the response string
			OutputStream os = t.getResponseBody();
			os.write(res.getBytes());
			os.close();


		}


	}
	
	
}
