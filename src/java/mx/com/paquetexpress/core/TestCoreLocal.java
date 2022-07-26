/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.core;

import javax.ejb.Local;
import mx.com.paquetexpress.comun.SmartGeneralException;
import mx.com.paquetexpress.dto.ApiDTO;

/**
 *
 * @author ealvarez
 */
@Local
public interface TestCoreLocal {
    
    
    public ApiDTO test(ApiDTO adto) throws Exception, SmartGeneralException;
    
    
}
