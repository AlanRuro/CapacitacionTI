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
    
    
    public Response test(ApiDTO adto) throws Exception, SmartGeneralException;
     
}
