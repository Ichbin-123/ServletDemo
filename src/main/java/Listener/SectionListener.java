package Listener;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;


// Viene notificato dell'evento di creazione della sessione HTTP
public class SectionListener implements HttpSessionListener
{
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||SESSIONE CREATA||||||||||");
        System.out.println("||||||||| " + se.getSession().getId() + "||||||||||"); // Stampo JSESSIONID
        System.out.println("||||||||||||||||||||||||||||||||||");
    }
}
