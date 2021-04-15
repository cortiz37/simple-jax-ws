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
        ElementService elementService = new ElementService();
        //ElementService elementService = new ElementService(new URL("file:///PATH_TO_PROJECT/simple-jax-ws/src/main/java/com/client/CustomerWS.xml"));

        final CustomerWS servicePort = elementService.getElementServicePort();
        //updatePortURL(servicePort);

        requestData(servicePort);
    }

    private static void requestData(CustomerWS servicePort) {
        printAllElementNames(servicePort);
        System.out.println("=================");
        System.out.println(servicePort.createElement(buildClient()));
        System.out.println("=================");
        printAllElementNames(servicePort);
    }

    private static void printAllElementNames(CustomerWS servicePort) {
        servicePort.getAllElements().forEach(System.out::println);
    }

    private static Element buildClient() {
        Element element = new Element();
        element.setDescription("from soap");
        element.setName("from Client");
        element.setAmount(50);
        element.setSuccess(true);
        return element;
    }

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

    private static void updatePortURL(CustomerWS ws) {
        BindingProvider bindingProvider = (BindingProvider) ws;
        bindingProvider.getRequestContext().put(
            BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
            "http://localhost:8090/ws-app/elementService/CustomerWS"
        );
    }
}
