
package mx.com.paquetexpress.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class CustomServletContextListener implements ServletContextListener {

     @Override
     public void contextInitialized(ServletContextEvent sce) {
          System.out.print("EJB TEST web app arrancada");
     }

     @Override
     public void contextDestroyed(ServletContextEvent sce) {
          System.out.print("EJB TEST web app detenida");
     }
}
