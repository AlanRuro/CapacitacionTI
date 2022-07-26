package mx.com.paquetexpress.util;

import java.util.ArrayList;
import mx.com.paquetexpress.dto.message.body.response.Response;


/**
 *
 * @author evillegas
 */
public class Util {

    public static void getError(String description, String code, String typeError, Response response) throws Exception{
        try{
            if(response.getMessages() == null)
                response.setMessages(new ArrayList<mx.com.paquetexpress.dto.message.body.response.message.Message>());
                
            mx.com.paquetexpress.dto.message.body.response.message.Message message = new mx.com.paquetexpress.dto.message.body.response.message.Message();
            message.setCode(code);
            message.setDescription(description);
            message.setTypeError(typeError);

            response.getMessages().add(message);
            response.setSuccess(Boolean.FALSE);
        }catch(Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }
    
    public static void addMessage(String description, String code, String typeError, Response response) throws Exception{
        try{
            if(response.getMessages() == null)
                response.setMessages(new ArrayList<mx.com.paquetexpress.dto.message.body.response.message.Message>());
                
            mx.com.paquetexpress.dto.message.body.response.message.Message message = new mx.com.paquetexpress.dto.message.body.response.message.Message();
            
            message.setCode(code);
            message.setDescription(description);
            message.setTypeError(typeError);

            response.getMessages().add(message);
            response.setSuccess(Boolean.FALSE);
        }catch(Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }
    
}
