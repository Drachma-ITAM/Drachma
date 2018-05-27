package mx.com.itam.drachma;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 *
 * 
 */

@SuppressWarnings("restriction")
public class BackendDrachma {

	// private static final String ruta = "/";
	// private static final int puertoBACKD = 8000;

	public BackendDrachma (int puerto) throws Exception{

		HttpServer httpServer;

		try {
			//Create HttpServer which is listening on the given port 
			httpServer = HttpServer.create(new InetSocketAddress(puerto), 0);
			//Create a new context for the given context and handler
			httpServer.createContext("/mail", new ValidacionMail());
			httpServer.createContext("/adios", new RutaDos());
			//Create a default executor
			httpServer.setExecutor(null);
			httpServer.start();
			System.out.println("Servidor en puerto: "+puerto);
		} catch (IOException e) {
			e.printStackTrace();
		}



	}

	// public static void main(String[] args) throws Exception {

	// 	BackendDrachma back = new BackendDrachma(puertoBACKD);
		


	// }

}
