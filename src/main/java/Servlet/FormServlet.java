package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html"); // importo content type della risposta ad HTML
        PrintWriter out = response.getWriter(); // estratto oggetto per scrittura su response HTTP
        out.println("<form action='form' method='POST'>");
        out.println("<label for='nome'>Il tuo nome:</label><br>");
        out.println("<input type='text' name='nome'><br><br>");
        out.println("<label for='messaggio'>Inviaci un messaggio:</label><br>");
        out.println("<textarea name='messaggio' rows='5'></textarea><br><br>");
        out.println("<button type='submit'>Invia messaggio</button>");
        out.println("</form>");
//        out.println("<label for='email'>Email:</label>");
//        out.println("<input type='email' id='email' name='email' required><br><br>");
//        out.println("<label for='password'>Password:</label>");
//        out.println("<input type='password' id='password' name='password' required><br><br>");
//        out.println("<button type='submit' value='Login'> Invia Messaggio</button>");
//        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
// Recupero i dati inseriti nella richiesta POST usando i lori nomi
        String nome = request.getParameter("nome");
        String messaggio = request.getParameter("messaggio");
        // Controlliamo che i dati esistano e non siano vuoti
        if(nome == null || nome.isBlank())
            nome = "Anonimo";
        if(messaggio == null || messaggio.isBlank())
            messaggio = "Vuoto";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>Grazie!</h1>");

        out.println("<h2>Autore del messaggio:</h2>");
        out.printf("<p>%s</p>", nome);

        out.println("<h2>Messaggio</h2>");
        out.printf("<p>%s</p>", messaggio);

        out.println("<a href='form'> Invia un altro messaggio</a>");

    }
}
