package mx.com.itam.drachma;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
/**
 * 
 *
 */
@SuppressWarnings("restriction")
public class ValidacionMail implements HttpHandler {

	
	private static final int HTTP_OK_STATUS = 200;
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private final static Logger LOG = Logger.getLogger(ValidacionMail.class.getName());
	
	/**
	 * Método booleano para verificar si un mail es valido o no, utiliza un patrón y
	 * un matcher para validarlo.
	 * @param email recibe el email a validar como un string 
	 */
	public static boolean validar(String email){
	    boolean res;
	           // Patrón para validar el email
	        Pattern pattern = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
	        
	        // matcher para buscar a través del texto multiples ocurrencias de una expresión.
	        Matcher mather = pattern.matcher(email);
	 
	        if (mather.find() == true) {
	        	res = true;
	        	LOG.info("eMail valido");//el email es valido
	        } else {
	        	res = false;
	        	LOG.info("eMail no valido"); //email es invalido
	        }
	        return res;
	        
	}

	
	public void handle(HttpExchange t) throws IOException {

		
		Map<String, String> get = Utiles.getParams(t.getRequestURI().getQuery());
		String[] params = {"addr"};
		String res;
		if(Utiles.isset(get,params)){

			res = "[{\"valido\": \""+validar(get.get("addr"))+"\"}]";             


		}
		else{
			 res = "[{\"status\": \""+"err"+"\"}]";

		}

		t.getResponseHeaders().set(HEADER_CONTENT_TYPE, String.format("application/json; charset=%s", CHARSET));
		t.sendResponseHeaders(HTTP_OK_STATUS, res.getBytes().length);
		OutputStream os = t.getResponseBody();
		os.write(res.getBytes(CHARSET));
		os.close();


	}
	
	
}
