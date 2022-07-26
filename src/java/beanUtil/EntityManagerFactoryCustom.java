/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanUtil;

/**
 *
 * @author evillegas
 */
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.paquetexpress.comun.SmartGeneralException;  

/**
 *
 * @author jasanchez
 */
public class EntityManagerFactoryCustom {

     private static EntityManagerFactory entityManagerFactory;
     public static Map<String, Long> guiaSerie = new HashMap<String, Long>();
     public static boolean bloqueoGuiaSerie = false;

     /**
      * Constructor sin parametros
      */
     private EntityManagerFactoryCustom() {
     }

     public static void reloadGuiaSerie() {
          guiaSerie = null;
          guiaSerie = new HashMap<String, Long>();
     }

     /**
      * Método que regresa un objeto EntityManagerFactory singleton para la conexion 
      */ 

      
     public static EntityManagerFactory getInstance() {
          
        try {
         
               initSessionFactory();
          } catch (Exception e) {
               e.printStackTrace();
          } 
          return entityManagerFactory; 
     }
      
     public static EntityManagerFactory getReloadInstance() {
          try { 
               entityManagerFactory = null;
               initSessionFactory(); 
          } catch (Exception e) { 
               e.printStackTrace();
          }
          return entityManagerFactory;
     }

     private static synchronized void initSessionFactory() throws Exception {
          try {
               if (entityManagerFactory == null) {
                   entityManagerFactory = Persistence.createEntityManagerFactory("jtaGobernance"); 
               }
          } catch (Exception e) {
               e.printStackTrace();
               throw new SmartGeneralException("No se pudo inicializar");
          }
     } 
}
