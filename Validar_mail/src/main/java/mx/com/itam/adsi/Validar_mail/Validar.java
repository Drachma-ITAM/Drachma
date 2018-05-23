package mx.com.itam.adsi.Validar_mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Cecilia V
 * Clase que incluye el método para validar un email.
 *
 */
public class Validar 
{
	
	/**
	 * Método booleano para verificar si un mail es valido o no, utiliza un patrón y
	 * un matcher para validarlo.
	 * @param email recibe el email a validar como un string
	 * @return true si es valido, false si no es valido 
	 */
	public static boolean validar(String email){
	    boolean res;
	           // Patrón para validar el email
	        Pattern pattern = Pattern
	                .compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
	        
	        // matcher para buscar a través del texto multiples ocurrencias de una expresión.
	        Matcher mather = pattern.matcher(email);
	 
	        if (mather.find() == true) {
	            res=true; //el email es valido
	        } else {
	           res=false; //email es invalido
	        }
	        return res;
	}
}
