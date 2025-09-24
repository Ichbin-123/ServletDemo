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
