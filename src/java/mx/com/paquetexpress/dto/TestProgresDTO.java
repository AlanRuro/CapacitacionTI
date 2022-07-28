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

    private Integer id;
    private String test_column;

    public TestProgresDTO() {
    }

    public TestProgresDTO(Integer id, String test_column) {
        this.id = id;
        this.test_column = test_column;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTest_column() {
        return test_column;
    }

    public void setTest_column(String test_column) {
        this.test_column = test_column;
    }

    @Override
    public String toString() {
        return "TestProgresDTO{" + "id=" + id + ", test_column=" + test_column + '}';
    }

}
