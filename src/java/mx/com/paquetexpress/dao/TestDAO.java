/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.dao;

import java.util.List;
import javax.ejb.Stateless;
import mx.com.paquetexpress.dto.TestDTO;
import mx.com.paquetexpress.properties.InitPropertiesConfig;
import mx.com.paquetexpress.type.TypePropertiesConstants;
import mx.com.paquetexpress.util.MessageApi;

/**
 *
 * @author gmadero
 */
@Stateless(name = "TestDAO")
public class TestDAO implements TestDAOLocal {

     private final GenericQueryDAOLocal genericQueryDAOLocal;
     //private final MessageApi messageApi;
     //private final String urlServer;
     //private final int connectTimeout, connectionRequestTimeout;

     public TestDAO() {
          genericQueryDAOLocal = new GenericQueryDAO();
          //connectTimeout = Integer.parseInt(InitPropertiesApi.getInstance().getProperty("connectTimeout", "10"));
          //connectionRequestTimeout = Integer.parseInt(InitPropertiesApi.getInstance().getProperty("connectionRequestTimeout", "10"));
          //messageApi = new MessageApi(urlServer, connectTimeout, connectionRequestTimeout);
          //messageApi = new MessageApi("http://wldev.paquetexpress.mx:7007");

     }

     @Override
     public void testQuery() {
          List<TestDTO> rows = null;
          try {
               rows = genericQueryDAOLocal.getAllItemsByFilters("query_pg", new Object[]{"1"}, new TestDTO(), TypePropertiesConstants.TEST);
               for (TestDTO row : rows) {
                    System.out.println(row.getComments());
               }
               System.out.println(rows.size());
          } catch (Exception ex) {
               ex.printStackTrace();
          }
     }
     
     
     public void testQuery(String param) {
          List<TestDTO> rows = null;
          try {
               rows = genericQueryDAOLocal.getAllItemsByFilters("query_pg", new Object[]{param}, new TestDTO(), TypePropertiesConstants.TEST);
               for (TestDTO row : rows) {
                    System.out.println(row.getComments());
               }
               System.out.println(rows.size());
          } catch (Exception ex) {
               ex.printStackTrace();
          }
     }

}
