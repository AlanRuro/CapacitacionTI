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
import mx.com.paquetexpress.dto.TestProgresDTO;
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
    public Response getDataById(String param) throws Exception, SmartGeneralException {
        Response response = new Response();
        List<Message> messagesList = new ArrayList<Message>();
        Message messages = new Message();
        try {
            if (param != null) {
                response.setData(core.getPostgresRowsById(param));
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

    @Override
    public Response getAllData() throws Exception, SmartGeneralException {
        Response response = new Response();
        List<Message> messagesList = new ArrayList<Message>();
        Message messages = new Message();
        try {
            response.setData(core.getPostgresRows());
            response.setSuccess(Boolean.TRUE);
            messages.setCode("200");
            messages.setDescription("Ok");

            messagesList.add(messages);
            response.setMessages(messagesList);
        } catch (Exception ex) {
            throw ex;
        }
        return response;
    }

     

    @Override
    public Response setSomeData(String param) throws Exception, SmartGeneralException {
        Response response = new Response();
        List<Message> messagesList = new ArrayList<Message>();
        Message messages = new Message();
        try {
            if (param != null) {
                response.setData(core.createNewPostgresRow(param));
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

    @Override
    public Response updateSomeData(String param, String param2) throws Exception, SmartGeneralException {
        Response response = new Response();
        List<Message> messagesList = new ArrayList<Message>();
        Message messages = new Message();
        try {
            if (param != null) {
                response.setData(core.updatePostgresRowsById(param, param2));
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

    @Override
    public Response deleteSomeData(String param) throws Exception, SmartGeneralException {
        Response response = new Response();
        List<Message> messagesList = new ArrayList<Message>();
        Message messages = new Message();
        try {
            if (param != null) {
                response.setData(core.deletePostgresRowsById(param));
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

    @Override
    public Response demoCrudEntity() throws Exception, SmartGeneralException {
        Response response = new Response();
        List<Message> messagesList = new ArrayList<Message>();
        Message messages = new Message();
        try {
            core.entityCRUD();
            response.setData("demo");
            response.setSuccess(Boolean.TRUE);
            messages.setCode("200");
            messages.setDescription("Ok");

            messagesList.add(messages);
            response.setMessages(messagesList);
        } catch (Exception ex) {
            throw ex;
        }
        return response;
    }

}
