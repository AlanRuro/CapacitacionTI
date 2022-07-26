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
public class TestProgresDTO implements Serializable {

     private String test_column;

     public TestProgresDTO() {
     }

    public String getTest_column() {
        return test_column;
    }

    public void setTest_column(String test_column) {
        this.test_column = test_column;
    }

    @Override
    public String toString() {
        return "TestProgresDTO{" + "test_column=" + test_column + '}';
    }

     

}
