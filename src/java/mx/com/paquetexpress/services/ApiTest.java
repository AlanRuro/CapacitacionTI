/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.List;
import java.util.TimeZone;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mx.com.paquetexpress.comun.SmartGeneralException;
import mx.com.paquetexpress.dto.ApiDTO;
import mx.com.paquetexpress.dto.message.Message;
import mx.com.paquetexpress.dto.message.body.Body;
import mx.com.paquetexpress.dto.message.body.response.Response;
import mx.com.paquetexpress.facade.TestFacadaBean;
import mx.com.paquetexpress.facade.TestFacadeLocal;

/**
 *
 * @author RLOPEZ
 */
@Path("/test")
public class ApiTest {

     private ObjectMapper mapper = null;
     private final SimpleDateFormat df;

     @EJB
     private final TestFacadeLocal facade = new TestFacadaBean();

     public ApiTest() {
          df = new SimpleDateFormat("yyyy-MM-dd@HH:mm:ss.SSSZ");
          mapper = new ObjectMapper();
          mapper.setDateFormat(df);
          mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
          mapper.setTimeZone(TimeZone.getDefault());
     }

     @GET
     @Produces(MediaType.APPLICATION_JSON) 
     @Path("/get")
     public Message addressValidator() throws Exception {
          //initMapper();  
          Message data = new Message();
          Body body = new Body();
          data.setBody(body);  
          Response resp = new Response();  
          double time = System.currentTimeMillis();
          List<mx.com.paquetexpress.dto.message.body.response.message.Message> messagesList = new ArrayList<mx.com.paquetexpress.dto.message.body.response.message.Message>();
          mx.com.paquetexpress.dto.message.body.response.message.Message messages = new mx.com.paquetexpress.dto.message.body.response.message.Message();
          try {

               //InitPropertiesApiSalesForce.getReloadInstance();
               System.out.println("Hello");
               
               
               messages.setDescription("OK");
               messagesList.add(messages);
               resp.setSuccess(true);
               resp.setData("OK");
          } catch (Exception ex) {
               ex.printStackTrace(); 
               messages.setDescription("Ha ocurrido un error interno");
               messagesList.add(messages);
               resp.setMessages(messagesList);
               resp.setSuccess(false);
          } finally {
               resp.setTime((System.currentTimeMillis() - time) + " miliseconds");
               data.setHeader(null);
               data.setBody(new Body());
               data.getBody().setRequest(null);
               data.getBody().setResponse(resp);  
          }
          return data;
     }
     

     @POST
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_JSON)
     @Path("/post")
     public Message test(Message data) throws Exception {
          String result = "";
          double time = System.currentTimeMillis();
          Response response = new Response();
          List<mx.com.paquetexpress.dto.message.body.response.message.Message> messagesList = new ArrayList<mx.com.paquetexpress.dto.message.body.response.message.Message>();
          mx.com.paquetexpress.dto.message.body.response.message.Message messages = new mx.com.paquetexpress.dto.message.body.response.message.Message();
          try {

               if (data.getBody().getRequest().getData() != null) {
                    ApiDTO audit = mapper.convertValue(data.getBody().getRequest().getData(), ApiDTO.class);
                    response = facade.test(audit);
                    result = "OUT";
               } else {
                    throw new SmartGeneralException("Debe indicarse objeto de auditoria");
               }
          } catch (SmartGeneralException sge) {
               result = "ERORR";
               messages.setCode("400");
               messages.setDescription(sge.getMessage());
               messages.setTypeError("SmartGeneralException");
               response.setSuccess(false);
          } catch (Exception ex) {
               result = "ERORR";
               messages.setCode("500");
               messages.setDescription(ex.getLocalizedMessage());
               messages.setTypeError("Exception");
               response.setSuccess(false);
               ex.printStackTrace();
          } finally {
               if (response.getMessages() == null) {
                    messagesList.add(messages);
                    response.setMessages(messagesList);
               }
               response.setTime("" + (System.currentTimeMillis() - time) + " miliseconds");
               data.getBody().setResponse(response);
               data.getBody().getRequest().setData(null);
          }
          return data;
     }

}
