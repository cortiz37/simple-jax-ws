package com.ws;

import com.business.model.Element;
import com.business.service.ElementService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(serviceName = "elementService", portName = "elementServicePort")
public class CustomerWS {

    @Inject
    private ElementService elementService;

    public List<Element> getAllElements() {
        return elementService.getAll();
    }

    public Element getElementById(String id) {
        return elementService.getElementById(id).orElse(null);
    }

    //delete

    public String createElement(Element element) {
        return elementService.create(element).getId();
    }

    public String replaceElement(Element element) {
        return "Not implemented yet!";
    }

    //update (merge)
}
