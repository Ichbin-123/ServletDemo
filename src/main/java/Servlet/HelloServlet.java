package Servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// La classe Servlet associa una request http (quindi metodo URI) a una classe
public class HelloServlet extends HttpServlet{


    // Viene chiamato dal container (Il server Jetty) ogni volta che riceve una richiesta su URL mappato a questa servlet
    @Override
    protected void doGet(HttpServletRequest request,
                            HttpServletResponse response)throws IOException {
        // Logica poi risponde

        try{
            Thread.sleep(10000);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        // Imposto il content type della response perché tornerò una pagina html
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();

        // Scrivo sul writer i dati che voglio mandare alla response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
            out.println("<head>");
                out.println("<title>Esempio di Servlet</title>");
            out.println("</head>");
            out.println("<body>");
                out.println("<h1>Ciao da Servlet</h1>");
                out.println("<p>Questa pagina è stata creata senza olio di palma. </p>");
                out.println("<p>Il tutto, a runtime </p>");
            out.println("</body>");
        out.println("</html>");
    }
}

/*
out.println("<!DOCTYPE html>");
out.println("<html>");
    out.println("<head>");
        out.println("<title>Login su Servlet</title>");
    out.println("</head>");
    out.println("<body>");
        out.println("<h1>Pagina di Login - Senza Olio di palma</h1>");
        out.println("<form action='LoginServlet' method='post'>");
            out.println("<label for='email'>Email:</label>");
            out.println("<input type='email' id='email' name='email' required><br><br>");

            out.println("<label for='password'>Password:</label>");
            out.println("<input type='password' id='password' name='password' required><br><br>");

            out.println("<input type='submit' value='Login'>");
        out.println("</form>");
    out.println("</body>");
out.println("</html>");

*/
