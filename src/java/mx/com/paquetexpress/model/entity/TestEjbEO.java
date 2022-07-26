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
@Table(name = "TEST_EJB" )
@XmlRootElement
@Cacheable(false)
@NamedQueries({
    @NamedQuery(name = "TestEjbEO.findAll", query = "SELECT a FROM TestEjbEO a") 
})
public class TestEjbEO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "COMMENTS")
    private String comments;  

    @Id
    @Column(name = "CRTD_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crtdOn;
    
     
    public TestEjbEO() {
    }

     public Date getCrtdOn() {
          return crtdOn;
     }

     public void setCrtdOn(Date crtdOn) {
          this.crtdOn = crtdOn;
     }  

     public String getComments() {
          return comments;
     }

     public void setComments(String comments) { 
          this.comments = comments; 
     }

     @Override
     public String toString() {
          return "TestEjbEO{" + "crtdOn=" + crtdOn + ", comments=" + comments + '}';
     }
 

}
