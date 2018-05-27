package mx.com.itam.drachma; 

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
import org.apache.log4j.Logger; 

/**
*Clase SendMail
*
*Se encarga de enviar un correo del tipo requerido al destinatario deseado.
**/
public class SendMail {

	private final static Logger LOG = Logger.getLogger(SendMail.class);

	/**
	*Correo del destinatario
	*/
	private String mail;
	/**
	*Tipo de correo a enviar
	*/
	private int tipo; //si es 0, aumenta precio, si no, disminuye

	public SendMail(String m, int t) {
		mail = m;
		tipo = t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendMail p = new SendMail("adsi.itam.03@gmail.com",1);
		p.enviaMail();

	}

	/**
	*Envía correo al destinatario
	*@param cambio tipo de cambio en la cripto moneda
	*@return respuesta del servidor de correo
	*/
	public ClientResponse SendSimpleMessage(String cambio) {
	    LOG.info("Enviando correo a destinatario");
	    Client client = Client.create();
	    client.addFilter(new HTTPBasicAuthFilter("api", "key-88d4a0b737fbec0f8f5f70a738dff845"));
	    WebResource webResource = client.resource("https://api.mailgun.net/v3/sandbox01f157d5443b43a5a07afc898d461c7e.mailgun.org/messages");
	    MultivaluedMapImpl formData = new MultivaluedMapImpl();
	    //Aquí se ponen los datos del correo
	    formData.add("from", "Drachma  <postmaster@sandbox01f157d5443b43a5a07afc898d461c7e.mailgun.org>");
	    formData.add("to", mail);
	    formData.add("subject", "Cambio en el precio de la criptomoneda");
	    //Aquí se escribe el cuerpo del correo
	    formData.add("text", "Hola, este correo es para informarle que el precio de la criptomoneda ha "+cambio+" notoriamente.");
	    formData.add("text", "Saludos");
	    formData.add("text", "Drachma");
	    return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
	                                        post(ClientResponse.class, formData);
	}

	/**
	*Llama a SendSimpleMessage y guarda información del correo enviado
	*@return true si el mensaje se envió correctamente, false en caso contrario
	*/
	public boolean enviaMail(){
		LOG.info("Destinatario: "+mail);
		String tipoM = "Tipo de correo: ";
		ClientResponse r = null;
		if(tipo == 0){
			LOG.info(tipoM+"disminuye precio");
			r = SendSimpleMessage("disminuido");
		}else{
			LOG.info(tipoM+"aumenta precio");
			r = SendSimpleMessage("aumentado");
		}
		
		if(r.getStatus() == 200){
			LOG.info("Correo enviado correctamente!");
			return true;
		}else{
			LOG.info("No se ha logrado enviar el correo");
			return false;
		}
	}
		
}
