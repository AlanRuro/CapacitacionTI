/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.dao;

import java.util.List;
import mx.com.paquetexpress.dto.ApiDTO;
import mx.com.paquetexpress.dto.TestProgresDTO;

/**
 *
 * @author gmadero
 */
public interface TestDAOLocal {
    
 
   
    public List<TestProgresDTO> getPostgresRows();
     
    public List<TestProgresDTO> getPostgresRowsById(String param);
 
    
    
}
