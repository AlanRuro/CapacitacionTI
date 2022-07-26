/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.paquetexpress.util;

import java.util.ArrayList;
import java.util.List;
import mx.com.paquetexpress.comun.SmartGeneralException;
import mx.com.paquetexpress.dto.message.Message;
import mx.com.paquetexpress.dto.message.body.Body;
import mx.com.paquetexpress.dto.message.header.Header;
import mx.com.paquetexpress.dto.message.header.security.Security;
import mx.com.paquetexpress.http.Request;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author gmadero
 */
public class MessageApi {
    
    private final String baseUrlString;
    private final int connectTimeout, connectionRequestTimeout;

    public MessageApi(String baseUrlString, int connectTimeout, int connectionRequestTimeout) {
        this.baseUrlString = baseUrlString;
        this.connectTimeout = connectTimeout;
        this.connectionRequestTimeout = connectionRequestTimeout;
    }
    
    public Message executeApiWS(Object data, String uri) throws SmartGeneralException, Exception {
        Message message = new Message();
        try {
            Security sec = new Security("", "", 2, "");
            sec.setPassword(null);
            Header head = new Header(sec, null, null, "JSON", "ESP");

            message.setHeader(head);

            message.setBody(new Body());
            message.getBody().setRequest(new mx.com.paquetexpress.dto.message.body.request.Request());
            message.getBody().getRequest().setData(data);

            List<NameValuePair> cabeceras = new ArrayList<NameValuePair>();
            cabeceras.add(new BasicNameValuePair("Content-Type", "application/json"));
            Request peticion = new Request(connectTimeout, connectionRequestTimeout);

            message = peticion.post(baseUrlString + uri, message, cabeceras);

        } catch (Exception ex) {
            throw ex;
        }
        return message;
    }
}
