/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.facade;

import javax.ejb.Local;
import mx.com.paquetexpress.comun.SmartGeneralException;
import mx.com.paquetexpress.dto.ApiDTO; 
import mx.com.paquetexpress.dto.message.body.response.Response;

/**
 *
 * @author ealvarez
 */ 
@Local
public interface TestFacadeLocal {
    
     
    public Response getAllData( ) throws Exception, SmartGeneralException; 
    
    public Response getDataById(String adto) throws Exception, SmartGeneralException;
    
    public Response setSomeData(String adto) throws Exception, SmartGeneralException;
    
    public Response deleteSomeData(String adto) throws Exception, SmartGeneralException;
    
    public Response updateSomeData(String param1, String param2) throws Exception, SmartGeneralException;
     
    public Response demoCrudEntity( ) throws Exception, SmartGeneralException;
}
