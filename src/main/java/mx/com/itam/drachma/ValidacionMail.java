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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * 
 *
 */
@SuppressWarnings("restriction")
public class ValidacionMail implements HttpHandler {

	
	private static final int HTTP_OK_STATUS = 200;
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final Charset CHARSET = StandardCharsets.UTF_8;

	
	public void handle(HttpExchange t) throws IOException {

		
		Map<String, String> get = Utiles.getParams(t.getRequestURI().getQuery());
		String[] params = {"addr"};
		String res;
		if(Utiles.isset(get,params)){

			res = "[{\"addr\": \""+get.get("addr")+"\"}]";             


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
