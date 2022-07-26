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
public class ApiDTO implements Serializable {

     private String paramA;

     public ApiDTO() {
     }

     public ApiDTO(String paramA) {
          this.paramA = paramA;
     }

     public String getParamA() {
          return paramA;
     }

     public void setParamA(String paramA) {
          this.paramA = paramA;
     }

     @Override
     public String toString() {
          return "ApiDTO{" + "paramA=" + paramA + '}';
     }

}
