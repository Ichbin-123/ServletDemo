package FIlter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LogFilter implements Filter {


    //una classe Filter che può intercettare richieste e risposte HTTP
    // per trasformare o ispezionare le informazioni di intestazione e corpo
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        // PRE PROCESSING
        long startTIme = System.currentTimeMillis(); // Prendo il tempo iniziale
        HttpServletRequest request = (HttpServletRequest) servletRequest; // cast a HttpServletRequest
        System.out.println("------------------------------------------");
        System.out.println("Request path: " + request.getRequestURI()); // Recupero URI della richiesta
        System.out.println("Request method: " + request.getMethod()); // Recupero metodo HTTP della richiesta
        System.out.println("Request start time: " + startTIme);


        //PROCESSING
        // Dico all'anello di fianco della catena che ho finito il pre-processing
        filterChain.doFilter(servletRequest,servletResponse);


        // POST PROCESSING
        long endTime = System.currentTimeMillis(); // Prendo il tempo finale
        long duration = endTime - startTIme; // calcolo il tempo di esecuzione della chiamata
        System.out.println("End Time: " + endTime);
        System.out.println("Duration: " + duration);
        System.out.println("------------------------------------------");
    }
}
