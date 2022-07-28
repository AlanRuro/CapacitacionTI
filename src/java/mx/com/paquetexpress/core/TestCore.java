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
     public ApiDTO test(ApiDTO adto) throws Exception, SmartGeneralException {
          try {

               System.out.println("--------QUERY-------------");
               dao.testQuery(adto.getParamA());

               System.out.println("--------PERSIST-------------");
               TestEjbEO testEntity = new TestEjbEO();
               testEntity.setTest_column("paquete" + new Date().toString());
               em.persist(testEntity);
               em.flush();
               dao.testQuery();

               System.out.println("-------UPDATE--------------");
               List<TestEjbEO> testList = em.createNamedQuery("TestEjbEO.findAll").getResultList();
               for (TestEjbEO item : testList) {
                    item.setTest_column("paquete" + new Date().toString());
                    em.merge(item);
               }
               em.flush();
               dao.testQuery();

               System.out.println("-------REMOVE--------------");
               for (TestEjbEO item : testList) {
                    em.remove(item);
               }
               em.flush();
               dao.testQuery();

          } catch (Exception ex) {
               ex.printStackTrace();
               throw ex;
          }
          System.out.println("---------------------------------------------");
          return adto;
     }

}
