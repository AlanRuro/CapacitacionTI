package mx.com.paquetexpress.dao;

/**
 *
 * @author evillegas
 */
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import javax.ejb.Stateless;
import mx.com.paquetexpress.ado.DataRowSet;
import mx.com.paquetexpress.ado.OracleConnection;
import mx.com.paquetexpress.ado.PostGresConnection;
import mx.com.paquetexpress.log.LoggerCustom;
import mx.com.paquetexpress.properties.InitPropertiesConfig;
import mx.com.paquetexpress.properties.InitPropertiesQuery;
import mx.com.paquetexpress.type.TypeDataSourceConstants;
import mx.com.paquetexpress.type.TypeModule;
import mx.com.paquetexpress.type.TypePropertiesConstants;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler; 


//@Stateless(name = "GenericQueryTESTDAO", mappedName = "PQEXPRESS.TEST.CATALOGS.GenericQueryDAO")
public class GenericQueryDAO implements GenericQueryDAOLocal {

    private String datasourceOracle = null;
    private PostGresConnection postgresConnection = null;
    private final LoggerCustom log;

    public GenericQueryDAO() {
        datasourceOracle = InitPropertiesConfig.getInstance().getProperty("datasourceOracle");
        log = (LoggerCustom) LoggerCustom. getLogger(GenericQueryDAO.class.getName());        
    }
 
    @Override
    public ArrayList getAllItemsByFilters(String nameQuery, Object[] filters, Object dto, TypePropertiesConstants propertiesFile, TypeDataSourceConstants typeDataSource) throws Exception 
    {
        ArrayList list = null;
        Properties propertiesQuerys = null;
        try {
            OracleConnection oracleConnection = new OracleConnection();
            propertiesQuerys = getProperties(propertiesFile);
            String ds = getDataSource(typeDataSource);
            nameQuery = propertiesQuerys.getProperty(nameQuery);
            if(nameQuery.contains("@")){
                if(filters != null) {
                for(short x = 0; x < filters.length; x++) {
                    nameQuery = nameQuery.replace("@"+x, (String)filters[x]);
                }
                filters = null;
            }
            }
            list = oracleConnection.runOracleQueryBeanList(nameQuery, filters, new BeanListHandler(dto.getClass()), ds);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Error en GenericQueryDAO", ex, TypeModule.MODULE.getType(), nameQuery);            
            throw ex;
        }
        return list;
    }  
     
 
    @Override    
    public ArrayList getAllItemsByFilters(String nameQuery, Object[] filters, Object dto, TypePropertiesConstants propertiesFile) throws Exception {
        ArrayList list = null; 
        Properties propertiesQuerys = null; 
        try {
            OracleConnection oracleConnection = new OracleConnection();
            propertiesQuerys = getProperties(propertiesFile); 
            nameQuery = propertiesQuerys.getProperty(nameQuery); 
            list = oracleConnection.runOracleQueryBeanList(nameQuery, filters, new BeanListHandler(dto.getClass()), datasourceOracle);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Error en GenericQueryDAO", ex, TypeModule.MODULE.getType(), nameQuery);            
            throw ex;
        } 
        return list; 
    }
    
 
    @Override    
    public ArrayList getAllItemsByFiltersOL(String nameQuery, Object[] filters, Object dto, TypePropertiesConstants propertiesFile) throws Exception {
        ArrayList list = null;
        Properties propertiesQuerys = null;
        try {
            OracleConnection oracleConnection = new OracleConnection();
            propertiesQuerys = getProperties(propertiesFile);
            nameQuery = propertiesQuerys.getProperty(nameQuery);
            list = oracleConnection.runOracleQueryBeanList(nameQuery, filters, new BeanListHandler(dto.getClass()), datasourceOracle);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Error en GenericQueryDAO", ex, TypeModule.MODULE.getType(), nameQuery);            
            throw ex;
        }
        return list;
    }
    
 
    @Override
    public Object getOnlyOneItemByFilters(String nameQuery, Object[] filters, Object dto, TypePropertiesConstants propertiesFile) throws Exception {
        Properties propertiesQuerys = null;
        try {
            OracleConnection oracleConnection = new OracleConnection();
            propertiesQuerys = getProperties(propertiesFile);
            nameQuery = propertiesQuerys.getProperty(nameQuery);
            dto = oracleConnection.runOracleQueryBean(nameQuery, filters, new BeanHandler(dto.getClass()), datasourceOracle);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Error en GenericQueryDAO", ex, TypeModule.MODULE.getType(), nameQuery);            
            throw ex;
        }
        return dto;
    }
    
    @Override
    public Object getOnlyOneItemByFiltersOL(String nameQuery, Object[] filters, Object dto, TypePropertiesConstants propertiesFile) throws Exception {
        Properties propertiesQuerys = null;
        try {
            OracleConnection oracleConnection = new OracleConnection();
            propertiesQuerys = getProperties(propertiesFile);
            nameQuery = propertiesQuerys.getProperty(nameQuery);
            dto = oracleConnection.runOracleQueryBean(nameQuery, filters, new BeanHandler(dto.getClass()), datasourceOracle);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Error en GenericQueryDAO", ex, TypeModule.MODULE.getType(), nameQuery);            
            throw ex;
        }
        return dto;
    }

    @Override
    public Object getOnlyOneValue(String nameQuery, Object[] filters, TypePropertiesConstants propertiesFile) throws Exception {
        Properties propertiesQuerys = null;
        Object dto = null;
        try {
            OracleConnection oracleConnection = new OracleConnection();
            propertiesQuerys = getProperties(propertiesFile);
            nameQuery = propertiesQuerys.getProperty(nameQuery);
            DataRowSet rs = oracleConnection.runOracleQuery(nameQuery, filters, datasourceOracle);
            if(rs.next()){
                dto = rs.getObject(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Error en GenericQueryDAO", ex, TypeModule.MODULE.getType(), nameQuery);            
            throw ex;
        }
        return dto;
    }    
    
    @Override
    public Properties getProperties(TypePropertiesConstants propertiesFile) throws Exception {
        Properties propertiesQuerys = null;
        try {
           switch (propertiesFile) {
                case TEST:
                    propertiesQuerys = InitPropertiesQuery.getInstance();
                default:
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Error en GenericQueryDAO", ex, TypeModule.MODULE.getType(), propertiesFile);
            throw ex;
        }
        return propertiesQuerys;
    }

    public String getDataSource(TypeDataSourceConstants typeDataSourceConstants) throws Exception {
        String dataSource = null;
        try {
            switch (typeDataSourceConstants) {
                case AUD:
                    dataSource = InitPropertiesConfig.getInstance().getProperty("datasourceOracle");
                    break;
                default:
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Error en GenericQueryDAO", ex, TypeModule.MODULE.getType(), typeDataSourceConstants);
            throw ex;
        }
        return dataSource;
    }
    
    @Override
    public ArrayList getAllItemsByFiltersWithConnGeo(String nameQuery, String[] parameters, Object dto, TypePropertiesConstants propertiesFile , Connection con , boolean close) throws Exception {
        ArrayList list = null;
        Properties propertiesQuerys = null;
        try {
            propertiesQuerys = getProperties(propertiesFile);
            nameQuery = propertiesQuerys.getProperty(nameQuery); 
            postgresConnection = new PostGresConnection();
            list = postgresConnection.runOracleQueryBeanList(nameQuery, parameters, new BeanListHandler(dto.getClass()), con, close);
 
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Error en GenericQueryDAO Connection Geo", ex, TypeModule.MODULE.getType(), nameQuery);            
            throw ex;
        }finally {
           if (close){
                con.close();
            }
        }
        return list;
    }    
    
    
    /**
     * **************************************************************
     * Método para hacer querys genéricos, donde exista condición IN 
     * **************************************************************
     * @param nameQuery : Objeto donde se definen la clave del query a ejecutar usando el metodo ? para lo parametros
     * @param filters : Lista de parametros
     * @param dto : Objeto DTO a llenar y regresar en la lista
     * @param propertiesFile : Archivo properties donde se busca la clave del query a consultar
     * @return : Lista de DTOs obtenidos a partir de la consulta
     * @throws java.lang.Exception
     */     
    public ArrayList getAllItemsByFiltersIn(String nameQuery, Object[] filters, Object dto, TypePropertiesConstants propertiesFile) throws Exception {
        ArrayList list = null;
        Properties propertiesQuerys = null;
        try {
            OracleConnection oracleConnection = new OracleConnection();
            propertiesQuerys = getProperties(propertiesFile);
            nameQuery = propertiesQuerys.getProperty(nameQuery);
            String paramsPositions = "";
             for (int x = 0; x<filters.length; x++) {
//                paramsPositions += "'".concat(filters[x].toString()).concat("'").concat((x < filters.length - 1) ? ", " : "");
                paramsPositions += "?".concat((x < filters.length - 1) ? ", " : "");
            } 
            int times = //StringUtils.countMatches(nameQuery, "@inParams");
                    nameQuery.split("@inParams").length - 1;
            nameQuery = nameQuery.replace("@inParams", paramsPositions);
            Object[] filters_repeated = new Object[filters.length*times];
            int fr_idx = 0;
            for(int i = 0; i < times; i++){
                for (Object filter : filters) {
                    filters_repeated[fr_idx] = filter;
                    fr_idx++;
                }
            }
            
            list = oracleConnection.runOracleQueryBeanList(nameQuery, filters_repeated, new BeanListHandler(dto.getClass()), datasourceOracle);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Error en GenericQueryDAO", ex, TypeModule.MODULE.getType(), nameQuery);            
            throw ex;
        }
        return list;
    }
    
}