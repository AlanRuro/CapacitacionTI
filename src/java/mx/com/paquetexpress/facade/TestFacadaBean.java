/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.com.paquetexpress.comun.SmartGeneralException;
import mx.com.paquetexpress.core.TestCore;
import mx.com.paquetexpress.core.TestCoreLocal;
import mx.com.paquetexpress.dto.ApiDTO;
import mx.com.paquetexpress.dto.message.body.response.Response;
import mx.com.paquetexpress.dto.message.body.response.message.Message;

 
@Stateless
public class TestFacadaBean implements TestFacadeLocal {

     @EJB
     private TestCoreLocal core = new TestCore(); 

     public TestFacadaBean() {
          try {
               core = new TestCore(); 
          } catch (Exception ex) {
               ex.printStackTrace();
          }
     }

    

     @Override
     public Response test(ApiDTO adto) throws Exception, SmartGeneralException {
          Response response = new Response();
          List<Message> messagesList = new ArrayList<Message>();
          Message messages = new Message();
          try {
               adto = core.test(adto);
               if (adto != null) { 
                    response.setData(adto);
                    response.setSuccess(Boolean.TRUE);
                    messages.setCode("200");
                    messages.setDescription("Ok");
               } else {
                    throw new SmartGeneralException("Ocurrio un error interno");
               }
               messagesList.add(messages);
               response.setMessages(messagesList);
          } catch (Exception ex) {
               throw ex;
          }
          return response;
     }

    
}
