package mx.com.itam.adsi.drachma.mail; 

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class SendMail {

	public SendMail() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendSimpleMessage();

	}

	public static ClientResponse SendSimpleMessage() {
	    Client client = Client.create();
	    client.addFilter(new HTTPBasicAuthFilter("api", "key-88d4a0b737fbec0f8f5f70a738dff845"));
	    WebResource webResource = client.resource("https://api.mailgun.net/v3/sandbox01f157d5443b43a5a07afc898d461c7e.mailgun.org/messages");
	    MultivaluedMapImpl formData = new MultivaluedMapImpl();
	    formData.add("from", "Mailgun Sandbox <postmaster@sandbox01f157d5443b43a5a07afc898d461c7e.mailgun.org>");
	    formData.add("to", "Moni <adsi.itam.03@gmail.com>");
	    formData.add("subject", "Hello Moni");
	    formData.add("text", "Congratulations Moni, you just sent an email with Mailgun!  You are truly awesome!");
	    return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
	                                        post(ClientResponse.class, formData);
	}
}
