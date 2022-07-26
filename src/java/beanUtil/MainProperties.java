package beanUtil;

/**
 * Created on 02/03/2006
 * @author DSARAURTJ
 *
 * Bean estatico para obtener el path de configuracion de las
 * aplicaciones ya que estan puedan leer los properties corres-
 * pondientes.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
 
public class MainProperties 
{
	private static final String HDR_ERR="MSERR_B_MainProperties.";
	private static String PATH_BASE="";

	static {
		File f=new File(".");
		
		try{ 
			
			PATH_BASE = f.getCanonicalPath() + File.separatorChar;
			System.out.println("PATH_BASE "+PATH_BASE);
			 //C:/WebSphere/zntwasconfig/zntapppisagrafico_os3/zntconfig/configOS3.properties
		} catch (Exception e) {
			System.out.println(new StringBuffer(HDR_ERR).append("{static body} Error al determinar el path absoluto del directorio base.Exception=").append(e.toString()));
		}
	}
	
	//private static final String ARCHIVO_MAIN = "c:zntwasconfig" + File.separatorChar + "main.properties"; //$NON-NLS-1$
	private static final String ARCHIVO_MAIN = new StringBuffer(PATH_BASE).append("paquetexpressConfig").append(File.separatorChar).append("main.properties").toString(); //$NON-NLS-1$

	private MainProperties()  
	{
		super();	
	}

	/** 
	 * Obtiene el path de la aplicacion solicitada y que se encuentra
	 * registrada en el main.properties.
	 * Fecha de creacion: (11/07/2002 12:23:29)
	 * @return java.lang.String
	 * @param var java.lang.String
	*/
	public static synchronized String getProperty(String propiedad)   
	{
		FileInputStream inputStream = null;
		PropertyResourceBundle properties = null;
		String property = null;
		StringBuffer buffer = new StringBuffer("");
		System.out.println("ARCHIVO_MAIN "+ARCHIVO_MAIN);
		try {
			inputStream = new FileInputStream(ARCHIVO_MAIN);
			properties = new PropertyResourceBundle(inputStream);
		} 
		catch (FileNotFoundException e)
		{
			buffer.append(HDR_ERR).append("getProperty() Archivo de propiedades (").append(ARCHIVO_MAIN).append(") no encontrado.");
			System.out.println(buffer);		
		}
		catch (Exception e) //RCC01 (Capturar todos las excepciones
		{
			
			buffer.delete(0,buffer.length());
			buffer.append(HDR_ERR).append("getProperty() Error de lectura de archivo de propiedades (").append(ARCHIVO_MAIN).append(").Exception=").append(e.toString());
			System.out.println(buffer);
		}
		
		if (properties!=null)
		{
			try 
			{
				property = properties.getString(propiedad);
			} 
			catch (MissingResourceException e) 
			{
				buffer.delete(0,buffer.length());
				buffer.append(HDR_ERR).append("getProperty() Propiedad (").append(propiedad).append(") no existente  en archivo (").append(ARCHIVO_MAIN).append(")");
				System.out.println(buffer);
			}
			catch (Exception e) 
			{
				buffer.delete(0,buffer.length());
				buffer.append(HDR_ERR).append("getProperty() Error al recuperar propiedad (").append(propiedad).append(") de archivo (").append(ARCHIVO_MAIN).append(").Exception=").append(e.toString());
				System.out.println(buffer);
			}
			finally
			{
				try {
					if (inputStream!=null) {
						inputStream.close();
					}
				} catch (Exception e) {
					buffer.delete(0,buffer.length());
					buffer.append(HDR_ERR).append("getProperty() Error al cerrar inputStream: ").append(e.toString());
					System.err.println(buffer);
				}
			}
		}
		return property;		
	}
	public static synchronized String getCanonicalPath(){
	  return 	ARCHIVO_MAIN;
	}

	public static String getPATH_BASE() {
		return PATH_BASE;
	}
}