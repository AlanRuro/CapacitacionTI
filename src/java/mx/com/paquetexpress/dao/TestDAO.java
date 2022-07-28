/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.dao;

import java.util.List;
import javax.ejb.Stateless;
import mx.com.paquetexpress.dto.ApiDTO;
import mx.com.paquetexpress.dto.TestDTO;
import mx.com.paquetexpress.dto.TestProgresDTO;
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
    public List<TestProgresDTO> getPostgresRows() {
        List<TestProgresDTO> rows = null;
        try {
            rows = genericQueryDAOLocal.getAllItemsByFilters("query_pg_crud_read", new Object[]{"1"}, new TestProgresDTO(), TypePropertiesConstants.TEST);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<TestProgresDTO> getPostgresRowsById(String param) {
        List<TestProgresDTO> rows = null;
        try {
            rows = genericQueryDAOLocal.getAllItemsByFilters("query_pg_crud_read_id", new Object[]{param}, new TestProgresDTO(), TypePropertiesConstants.TEST);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rows;
    }

}
