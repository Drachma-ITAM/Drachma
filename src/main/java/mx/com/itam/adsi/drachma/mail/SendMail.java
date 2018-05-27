package mx.com.itam.adsi.drachma.mail; 

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.MediaType;

public class SendMail {
	private String mail;
	private String msgBueno = "Hola, este correo es para informarle que el precio de la criptomoneda ha bajado drásticamente."; //mensaje cuando hay que comprar
	private String msgMalo = "Hola, este correo es para informarle que el precio de la criptomoneda ha subido drásticamente."; //mensaje cuando hay que vender
	public SendMail(String m) {
		mail = m;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendMail p = new SendMail("adsi.itam.03@gmail.com");
		p.SendSimpleMessage();

	}

	public ClientResponse SendSimpleMessage() {
	    Client client = Client.create();
	    client.addFilter(new HTTPBasicAuthFilter("api", "key-88d4a0b737fbec0f8f5f70a738dff845"));
	    WebResource webResource = client.resource("https://api.mailgun.net/v3/sandbox01f157d5443b43a5a07afc898d461c7e.mailgun.org/messages");
	    MultivaluedMapImpl formData = new MultivaluedMapImpl();
	    formData.add("from", "Drachma  <postmaster@sandbox01f157d5443b43a5a07afc898d461c7e.mailgun.org>");
	    formData.add("to", mail);
	    formData.add("subject", "Helloooooow");
	    formData.add("text", "No es para presumir, pero creo que tu novia es genial!");
	    return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
	                                        post(ClientResponse.class, formData);
	}
}
