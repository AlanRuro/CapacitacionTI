/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ealvarez
 */
@Entity
@Table(name = "test_table" )
@XmlRootElement 
@Cacheable(false)
@NamedQueries({
    @NamedQuery(name = "TestEjbEO.findAll", query = "SELECT a FROM TestEjbEO a") 
})
public class TestEjbEO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "test_column")
    private String test_column;  
    
     
    public TestEjbEO() {
    }

    public String getTest_column() {
        return test_column;
    }

    public void setTest_column(String test_column) {
        this.test_column = test_column;
    }


     @Override
     public String toString() {
          return "TestEjbEO{" + "Test_column=" + test_column + '}';
     }
 

}
