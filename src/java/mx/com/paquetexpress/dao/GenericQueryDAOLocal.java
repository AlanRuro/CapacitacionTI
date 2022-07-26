package mx.com.paquetexpress.dao;

/**
 *
 * @author evillegas
 */
import
        java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import javax.ejb.Local;
import mx.com.paquetexpress.type.TypeDataSourceConstants; 
import mx.com.paquetexpress.type.TypePropertiesConstants;
 
//@Local  
public interface GenericQueryDAOLocal {

    public ArrayList getAllItemsByFilters(String nameQuery, Object[] filters, Object dto, TypePropertiesConstants propertiesFile) throws Exception;
    public ArrayList getAllItemsByFiltersOL(String nameQuery, Object[] filters, Object dto, TypePropertiesConstants propertiesFile) throws Exception;    
    public Object getOnlyOneItemByFilters(String nameQuery, Object[] filters, Object dto, TypePropertiesConstants propertiesFile) throws Exception;
    public Object getOnlyOneItemByFiltersOL(String nameQuery, Object[] filters, Object dto, TypePropertiesConstants propertiesFile) throws Exception;
    public Object getOnlyOneValue(String nameQuery, Object[] filters, TypePropertiesConstants propertiesFile) throws Exception;
    public Properties getProperties(TypePropertiesConstants propertiesFile) throws Exception;
    public ArrayList getAllItemsByFiltersWithConnGeo(String nameQuery, String[] parameters, Object dto, TypePropertiesConstants propertiesFile , Connection con , boolean close) throws Exception;
    public ArrayList getAllItemsByFilters(String nameQuery, Object[] filters, Object dto, TypePropertiesConstants propertiesFile, TypeDataSourceConstants typeDataSource) throws Exception;
    public ArrayList getAllItemsByFiltersIn(String nameQuery, Object[] filters, Object dto, TypePropertiesConstants propertiesFile) throws Exception;
}
