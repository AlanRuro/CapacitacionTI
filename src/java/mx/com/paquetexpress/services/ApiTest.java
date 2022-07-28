/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import static java.awt.event.PaintEvent.UPDATE;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
    @Path("/get/table")
    public Message getAll() throws Exception {
        Message data = new Message();
        Body body = new Body();
        data.setBody(body);
        double time = System.currentTimeMillis();
        List<mx.com.paquetexpress.dto.message.body.response.message.Message> messagesList = new ArrayList<mx.com.paquetexpress.dto.message.body.response.message.Message>();
        mx.com.paquetexpress.dto.message.body.response.message.Message messages = new mx.com.paquetexpress.dto.message.body.response.message.Message();

        Response response = new Response();
        try {

            response.setData(facade.getAllData());

        } catch (SmartGeneralException sge) {
            messages.setCode("400");
            messages.setDescription(sge.getMessage());
            messages.setTypeError("SmartGeneralException");
            response.setSuccess(false);
        } catch (Exception ex) {
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
        }
        return data;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/get/id")
    public Message getDataById(Message data) throws Exception {
        String result = "";
        double time = System.currentTimeMillis();
        Response response = new Response();
        List<mx.com.paquetexpress.dto.message.body.response.message.Message> messagesList = new ArrayList<mx.com.paquetexpress.dto.message.body.response.message.Message>();
        mx.com.paquetexpress.dto.message.body.response.message.Message messages = new mx.com.paquetexpress.dto.message.body.response.message.Message();
        try { 

            if (data.getBody().getRequest().getData() != null) {
                ApiDTO audit = mapper.convertValue(data.getBody().getRequest().getData(), ApiDTO.class);
                response = facade.getDataById(audit.getParamA());
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Message createData(Message data) throws Exception {
        String result = "";
        double time = System.currentTimeMillis();
        Response response = new Response();
        List<mx.com.paquetexpress.dto.message.body.response.message.Message> messagesList = new ArrayList<mx.com.paquetexpress.dto.message.body.response.message.Message>();
        mx.com.paquetexpress.dto.message.body.response.message.Message messages = new mx.com.paquetexpress.dto.message.body.response.message.Message();
        try {

            if (data.getBody().getRequest().getData() != null) {
                ApiDTO audit = mapper.convertValue(data.getBody().getRequest().getData(), ApiDTO.class);
                response = facade.setSomeData(audit.getParamA());
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Message updateData(Message data) throws Exception {
        String result = "";
        double time = System.currentTimeMillis();
        Response response = new Response();
        List<mx.com.paquetexpress.dto.message.body.response.message.Message> messagesList = new ArrayList<mx.com.paquetexpress.dto.message.body.response.message.Message>();
        mx.com.paquetexpress.dto.message.body.response.message.Message messages = new mx.com.paquetexpress.dto.message.body.response.message.Message();
        try {

            if (data.getBody().getRequest().getData() != null) {
                ApiDTO audit = mapper.convertValue(data.getBody().getRequest().getData(), ApiDTO.class);
                response = facade.updateSomeData(audit.getParamA(), "MARKED");
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/remove")
    public Message deleteData(Message data) throws Exception {
        String result = "";
        double time = System.currentTimeMillis();
        Response response = new Response();
        List<mx.com.paquetexpress.dto.message.body.response.message.Message> messagesList = new ArrayList<mx.com.paquetexpress.dto.message.body.response.message.Message>();
        mx.com.paquetexpress.dto.message.body.response.message.Message messages = new mx.com.paquetexpress.dto.message.body.response.message.Message();
        try {

            if (data.getBody().getRequest().getData() != null) {
                ApiDTO audit = mapper.convertValue(data.getBody().getRequest().getData(), ApiDTO.class);
                response = facade.deleteSomeData(audit.getParamA());
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/demo")
    public Message entityDemo(Message data) throws Exception {
        String result = "";
        double time = System.currentTimeMillis();
        Response response = new Response();
        List<mx.com.paquetexpress.dto.message.body.response.message.Message> messagesList = new ArrayList<mx.com.paquetexpress.dto.message.body.response.message.Message>();
        mx.com.paquetexpress.dto.message.body.response.message.Message messages = new mx.com.paquetexpress.dto.message.body.response.message.Message();
        try {

            if (data.getBody().getRequest().getData() != null) {
                ApiDTO audit = mapper.convertValue(data.getBody().getRequest().getData(), ApiDTO.class);
                facade.demoCrudEntity();
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
