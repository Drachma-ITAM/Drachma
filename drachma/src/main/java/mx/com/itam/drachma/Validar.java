package mx.com.itam.drachma;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;


/**
 * @author Drachma
 * Clase que incluye el método para validar un email.
 *
 */
public class Validar 
{
	 // se inicializa el logger
	private final static Logger LOG = Logger.getLogger(Validar.class.getName());
	
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
	public static void main(String[] args) {
	}
	}


