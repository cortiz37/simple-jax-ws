package com.client;

import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.List;

public class WSTester {

    public static void main(String[] args) throws Exception {
//        BookStore bookStore = new BookStore();
//
//        final CustomerWS bookStorePort = bookStore.getBookStorePort();
//
//        requestData(bookStorePort);
    }

//    private static void requestData(CustomerWS ws) {
//        final List<Section> allSections = ws.getAllSections();
//
//        for (Section section : allSections) {
//            System.out.println(section.getName());
//        }
//
//        System.out.println("=================");
//        System.out.println("===> " + ws.registerNewSection("Special"));
//        System.out.println("=================");
//
//    }

//    private static void setTimeout(CustomerWS ws, int seconds) {
//        BindingProvider bindingProvider = (BindingProvider) ws;
//        bindingProvider.getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", seconds * 1000);
//        bindingProvider.getRequestContext().put("com.sun.xml.internal.ws.request.timeout", seconds * 1000);
//    }

//    private static void updatePortURL(CustomerWS ws) {
//        BindingProvider bindingProvider = (BindingProvider) ws;
//        bindingProvider.getRequestContext().put(
//            BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
//            "http://localhost:9090/ws-app/bookStore/CustomerWS"
//        );
//    }
}
