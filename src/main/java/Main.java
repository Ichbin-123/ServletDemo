import FIlter.LogFilter;
import Listener.SectionListener;
import Servlet.FormServlet;
import Servlet.HelloServlet;
import Servlet.InfoServlet;
import jakarta.servlet.DispatcherType;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.util.EnumSet;

public class Main {

    private static final int PORT = 8080;
    public static void main(String[] args) throws Exception {
        // Avvia il server Jetty alla porta
        Server server = new Server(PORT);

        // Agganciamoci al contesto delle servlet di jetty
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        // associamo l'handler al server
        server.setHandler(context);

        // Aggiungiamo la nostra servlet al context
        context.addServlet(HelloServlet.class, "/hello");

        // Aggiungiamo la nostra servlet al context
        context.addServlet(InfoServlet.class, "/info");

        // Aggiungiamo la nostra servlet al context
        context.addServlet(FormServlet.class, "/form");

        // Aggiunta del Filter
        context.addFilter(LogFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));


        // Aggiunta del Listener
        context.addEventListener(new SectionListener());

        // Faccio partire il server
        server.start();
        System.out.println("Server avviato. Endpoint disponibile");
        System.out.println(" - http://localhost:8080/hello");
        System.out.println(" - http://localhost:8080/info");
        System.out.println(" - http://localhost:8080/form");

        // impedisce al software di chiudersi solo e lascia il server attivo
        server.join(); // un po come System.in
        // System.in.read();
    }
}
