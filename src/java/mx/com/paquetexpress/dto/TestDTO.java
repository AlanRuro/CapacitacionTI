/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gmadero
 */
public class TestDTO implements Serializable {

     private String comments;
     private Date crtdOn;
     private Integer test_column;

   

     public TestDTO() {
     }

     public TestDTO(String comments, Date crtdOn, Integer test_column) {
          this.comments = comments;
          this.crtdOn = crtdOn;
          this.test_column = test_column;
     }

     public String getComments() {
          return comments;
     }

     public void setComments(String comments) {
          this.comments = comments;
     }

     public Date getCrtdOn() {
          return crtdOn;
     }

     public void setCrtdOn(Date crtdOn) {
          this.crtdOn = crtdOn;
     }
     
    public Integer getTest_column() {
        return test_column;
    }

    public void setTest_column(Integer test_column) {
        this.test_column = test_column;
    }

    @Override
    public String toString() {
        return "TestDTO{" + "comments=" + comments + ", crtdOn=" + crtdOn + ", test_column=" + test_column + '}';
    }
     
 

}
