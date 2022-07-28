/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.core;

import java.util.List;
import javax.ejb.Local;
import mx.com.paquetexpress.comun.SmartGeneralException;
import mx.com.paquetexpress.dto.ApiDTO;
import mx.com.paquetexpress.dto.TestProgresDTO;

/**
 *
 * @author ealvarez
 */
@Local
public interface TestCoreLocal {
    
    
    public void entityCRUD() throws Exception, SmartGeneralException;
    
    public List<TestProgresDTO> getPostgresRowsById(String param) throws Exception, SmartGeneralException; 
    public List<TestProgresDTO> getPostgresRows() throws Exception, SmartGeneralException; 
    public Boolean createNewPostgresRow(String data) throws Exception, SmartGeneralException; 
    public Boolean  deletePostgresRowsById (String id) throws Exception, SmartGeneralException; 
    public Boolean updatePostgresRowsById (String oldValue, String newValue) throws Exception, SmartGeneralException; 
    
    
}
