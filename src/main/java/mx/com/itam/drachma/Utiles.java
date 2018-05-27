package mx.com.itam.drachma;
import java.util.HashMap;
import java.util.Map;

public class Utiles{




   /**
   * Extrae los parametros get del url
   * los regresa en un Map
   * @param url
   * @return res
   */
  public static Map<String, String> getParams(String url){
  	
    Map<String, String> res = new HashMap<String, String>();

    if(url.equals(""))
      res = null;
    else{
      for (String param : url.split("&")) {
          String pair[] = param.split("=");
          if (pair.length>1) {
              res.put(pair[0], pair[1]);
          }else{
              res.put(pair[0], "");
          }
      }
    }
    return res;
  }

  public static boolean isset(Map<String, String> params, String[] keys){
    boolean res = true;

    if(params != null){
      for(String k : keys)
        res = res&&params.containsKey(k);

    }
    else
      res = false;

    return res;

  }


}

