package mx.com.paquetexpress.util;

/**
 *
 * @author jruiz
 */
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.CalendarConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;

public class BeansUtil {
  
  private static BeanUtilsBean INSTANCE;
  
  /**
   * private Constructor
   */
  private BeansUtil() {
    super();  
  }
  
  /**
   * Initializes the BeanUtilsBean component registering the convertors
   */
  private static void init()
  {
    INSTANCE.getConvertUtils().register(new BigDecimalConverter(null),BigDecimal.class);
    INSTANCE.getConvertUtils().register(new SqlTimestampConverter(null),Timestamp.class);
    INSTANCE.getConvertUtils().register(new CalendarConverter(null),Calendar.class);
    INSTANCE.getConvertUtils().register(new DateConverter(null),Date.class);
  }
  
  /**
   * Gets the Singleton Instance
   * @return
   */
  private static BeanUtilsBean getInstance(){
      if (INSTANCE == null) {
        INSTANCE = new BeanUtilsBean();
        BeansUtil.init();
      }
      return INSTANCE;
    }

/**
   * copyProperties from one object to another
   * @param objOrigin
   * @param objDestination
   * @throws IllegalAccessException
   * @throws InvocationTargetException
   */
  public static void copyProperties(Object objOrigin,Object objDestination) 
 {
    try {
      getInstance().copyProperties(objDestination, objOrigin);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  
}