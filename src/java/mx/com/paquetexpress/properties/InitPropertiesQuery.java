/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.properties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import mx.com.paquetexpress.comun.SmartGeneralException;

/**
 *
 * @author gmadero
 */
public class InitPropertiesQuery {
    
    private static Properties properties;

    public InitPropertiesQuery() {
    }
        
     /**
     * Método que regresa un objeto properties singleton con todos los querys de
     * la aplicacion RAD
     *
     * @return Objeto properties con querys de aplicacion RAD
     */
    public static Properties getInstance() {
        try {
            initSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * Método que que regresa un objeto properties no singleton con todos los
     * querys de la aplicacion RAD
     *
     * @return Objeto properties con querys de aplicacion RAD
     */
    public static Properties getReloadInstance() {
        try {
            properties = null;
            initSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * Método que regresa el query en base a la clave solicitada
     *
     * @param key es la clave para obtener el query
     * @return query con la clave
     */
    public String getValue(String key) {
        return properties.getProperty(key);
    }

    /**
     * Método que lee el archivo querys.Properties y los almacena en una
     * variable singleton
     */
    /**
     * Método que lee el archivo querys.Properties y los almacena en una
     * variable singleton
     */
    private static synchronized void initSessionFactory() throws Exception {
        FileInputStream is = null;
        try {
            String ruta = "";
            if (properties == null) {
                //System.out.println("Entra a configApplication.properties");
                ruta = System.getProperty("user.dir") + File.separator + "paquetexpressConfig" + File.separator + "querysSipWeb" + File.separator + "querys_test.properties";
                System.out.println(ruta);
                is = new FileInputStream(ruta);
                properties = new Properties();
                properties.load(is);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SmartGeneralException("No se encontro el Archivo configApplication.properties");
        } finally {
            if (is != null) {
                is.close();
                is = null;
            }
        }
    }
}
