package com.client;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WSTester {

    public static void main(String[] args) throws Exception {
//        ElementService elementService = new ElementService();
//
//        final CustomerWS servicePort = elementService.getElementServicePort();
//
//        requestData(servicePort);
    }

//    private static void requestData(CustomerWS servicePort) {
//        printAllElementNames(servicePort);
//    }
//
//    private static void printAllElementNames(CustomerWS servicePort) {
//
//    }
//
//    private static Element buildClient() {
//        return null;
//    }

//    private static void setTimeout(CustomerWS ws, int seconds) {
//        BindingProvider bindingProvider = (BindingProvider) ws;
//        bindingProvider.getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", seconds * 1000);
//        bindingProvider.getRequestContext().put("com.sun.xml.internal.ws.request.timeout", seconds * 1000);
//    }

//    private static void setUserAndPass(CustomerWS ws, String user, String pass) {
//        BindingProvider bindingProvider = (BindingProvider) ws;
//        Map<String, List<String>> headers = new HashMap<>();
//        headers.put("username", Collections.singletonList(user));
//        headers.put("password", Collections.singletonList(pass));
//        bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, headers);
//    }

//    private static void updatePortURL(CustomerWS ws) {
//        BindingProvider bindingProvider = (BindingProvider) ws;
//        bindingProvider.getRequestContext().put(
//            BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
//            "http://localhost:8080/ws-app/elementService/CustomerWS"
//        );
//    }
}
