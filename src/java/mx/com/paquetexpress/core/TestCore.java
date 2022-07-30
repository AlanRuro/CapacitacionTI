/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.core;

import beanUtil.EntityManagerFactoryCustom;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.paquetexpress.ado.OracleConnection;
import mx.com.paquetexpress.comun.SmartGeneralException;
import mx.com.paquetexpress.dao.TestDAO;
import mx.com.paquetexpress.dao.TestDAOLocal;
import mx.com.paquetexpress.dto.ApiDTO;
import mx.com.paquetexpress.dto.TestProgresDTO;
import mx.com.paquetexpress.model.entity.TestEjbEO;
import mx.com.paquetexpress.properties.InitPropertiesConfig;

/**
 *
 * @author ealvarez
 */
@Stateless
public class TestCore implements TestCoreLocal {

    @PersistenceContext
    private EntityManager em;

    private TestDAOLocal dao;
    private OracleConnection oracleConnection;
    private String datasourceOracle;
    private ObjectMapper mapper;
    private String genericTokenAccessString;
    private Map<String, Integer> hierarchy;
 
    protected EntityManager getEntityManager() {
        return em;
    }

    public TestCore() {
        try {
            em = EntityManagerFactoryCustom.getInstance().createEntityManager();
           dao = new TestDAO();
            //datasourceOracle = InitPropertiesConfig.getInstance().getProperty("datasourceOracleTX");
            //oracleConnection = new OracleConnection();
            //mapper = new ObjectMapper();
            //genericTokenAccessString = InitPropertiesConfig.getInstance().getProperty("genericTokenAccess");

        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public List<TestProgresDTO> getPostgresRowsById(String param) throws Exception, SmartGeneralException {
        List<TestProgresDTO> data = null;
        try {
            data = dao.getPostgresRowsById(param);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return data;
    }
    @Override
    public List<TestProgresDTO> getPostgresRows() throws Exception, SmartGeneralException {
        List<TestProgresDTO> data = null;
        try {
            data = dao.getPostgresRows();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return data;
    }

    @Override
    public Boolean createNewPostgresRow(String param) throws Exception, SmartGeneralException {
        Boolean success = true;
        try {
            System.out.println("--------PERSIST-------------");
            TestEjbEO testEntity = new TestEjbEO();
            testEntity.setId(getDateLikeInteger()); //get date value into Integer
            testEntity.setTest_column(param);
            em.persist(testEntity);
            em.flush();
        } catch (Exception ex) {
            success = false;
            ex.printStackTrace();
            throw ex;
        }
        System.out.println("---------------------------------------------");
        return success;
    }

    @Override
    public Boolean updatePostgresRowsById(String oldValue, String newValue) throws Exception, SmartGeneralException {
        Boolean success = true;
        try {
            List<TestEjbEO> testList = em.createNamedQuery("TestEjbEO.findAll").getResultList();
            for (TestEjbEO item : testList) {  
                System.out.println(item);
                if (item.getTest_column().equals(oldValue)) {
                    item.setTest_column(newValue);
                    em.merge(item);
                    break;
                }
            }
            em.flush();
        } catch (Exception ex) {
            success = false;
            ex.printStackTrace();
            throw ex;
        } 
        return success;
    }

    @Override
    public Boolean deletePostgresRowsById(String param) throws Exception, SmartGeneralException {
        Boolean success = true;
        try {
            List<TestEjbEO> testList = em.createNamedQuery("TestEjbEO.findAll").getResultList();
 
            for (TestEjbEO item : testList) {
                System.out.println(item);
                if (item.getTest_column().equals(param)) {
                    em.remove(item);
                    break;
                }
            }
            em.flush();
        } catch (Exception ex) {
            success = false;
            ex.printStackTrace();
            throw ex;
        } 
        return success;
    }

    @Override
    public void entityCRUD( ) throws Exception, SmartGeneralException { 
        try {
            System.out.println("--------QUERY-------------");
            printRowsTestQueryPostgres();

            System.out.println("--------PERSIST-------------");
            TestEjbEO testEntity = new TestEjbEO();
            testEntity.setId(getDateLikeInteger()); //get date value into Integer
            testEntity.setTest_column("paquete old date:" + getDateLikeInteger());
            em.persist(testEntity);
            em.flush();
            printRowsTestQueryPostgres();

            System.out.println("-------UPDATE--------------");
            List<TestEjbEO> testList = em.createNamedQuery("TestEjbEO.findAll").getResultList();
            for (TestEjbEO item : testList) {
                item.setTest_column("paquete new date:" + getDateLikeInteger(1));
                em.merge(item);
            }
            em.flush();
            printRowsTestQueryPostgres();

            System.out.println("-------REMOVE--------------");
            for (TestEjbEO item : testList) {
                em.remove(item);
            }
            em.flush();
            printRowsTestQueryPostgres();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        System.out.println("---------------------------------------------");
    }

    public void readListTestProgresDTO(List<TestProgresDTO> list) {
        if (list == null || list.size() == 0) {
            System.out.println("List void");
        } else {
            System.out.println("List size: " + list.size());
            for (TestProgresDTO row : list) {
                System.out.println(row.toString());
            }
        }
    }

    private void printRowsTestQueryPostgres() {
        readListTestProgresDTO(
                dao.getPostgresRows()
        );
    }

    private Integer getDateLikeInteger() {
        return (int) (new Date().getTime() / 1000);
    }

    private Integer getDateLikeInteger(Integer sum) {
        return (int) (new Date().getTime() / 1000) + sum;
    }
}
