package com.ws;

import com.business.model.Element;
import com.business.service.ElementService;
import com.security.SecurityUtil;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;

@Stateless
@WebService(serviceName = "elementService", portName = "elementServicePort")
public class CustomerWS {

    @Resource
    private WebServiceContext webServiceContext;

    @Inject
    private ElementService elementService;

    @Inject
    private SecurityUtil securityUtil;

    public List<Element> getAllElements() {
        return elementService.getAll();
    }

    public Element getElementById(String id) {
        return elementService.getElementById(id).orElse(null);
    }

    public boolean deleteElementById(String id) {
        return checkPermissions("ADMIN") && elementService.delete(id);
    }

    public String createElement(Element element) {
        return elementService.create(element).getId();
    }

    public Element replaceElement(Element element) {
        return null;
    }

    public Element updateElement(Element element) {
        return null;
    }

    private boolean checkPermissions(String ROLE) {
        MessageContext messageContext = webServiceContext.getMessageContext();
        Map<Object, Object> requestHeaders = (Map<Object, Object>) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
        List<Object> username = (List<Object>) requestHeaders.get("username");
        List<Object> password = (List<Object>) requestHeaders.get("password");
        return securityUtil.hasPermissions(extractFirstValue(username), extractFirstValue(password), ROLE);
    }

    private String extractFirstValue(List<Object> list) {
        if (list != null && !list.isEmpty()) {
            return (String) list.get(0);
        }
        return null;
    }
}
