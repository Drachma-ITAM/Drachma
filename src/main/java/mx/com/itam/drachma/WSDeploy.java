package mx.com.itam.drachma;

import javax.websocket.server.ServerContainer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

public class WSDeploy {
    public static void main(String[] args) {
        try{
        Server server = new Server(4040);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/ws");
        server.setHandler(context);

        // Solo se necesitan estas 2 lineas: 
        ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(context);
        wscontainer.addEndpoint(NewDataEndPoint.class);

        server.start();
        server.join();
        }catch(Exception e){
            System.out.println("lol");
        }
    }
}
