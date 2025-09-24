package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InfoServlet extends HttpServlet {


    // Viene invocato quando un client effettua una richiesta http get a endpoint collegato (all'URI)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Legge un parametro dall URL (query string del tipo ?nome=pippo&eventuale
        String nome = request.getParameter("nome");

        // Se il parametro è vuoto metto un default

        if(nome == null || nome.isBlank())
            nome = "Default";

        // Legge un header dalla richiesta per capire il tipo di client utilizzato
        String userAgent = request.getHeader("User-Agent");

        // Otteniamo l'ora del server
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd/MM/yyyy HH:mm:ss");
        String dataOraCorrente = now.format(formatter);

        // Costruiamo la risposta HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>Info Servlet</h1>");
        out.println("<p>Benvenuto nella pagina Info Servlet </p>");
        out.println("<h2><b>Parametro nella richiesta</b></h2>");
        out.printf("<p>%s</p>\n", nome);
        out.println("<h2><b>Info del client</b></h2>");
        out.printf("<p>%s</p>", userAgent);
        out.println("<h2><b>Info del Server</b></h2>");
        out.printf("<p>%s</p>", dataOraCorrente);



    }
}
