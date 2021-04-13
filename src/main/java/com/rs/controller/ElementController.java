package com.rs.controller;

import com.business.model.Element;
import com.business.model.ErrorMessage;
import com.business.service.ElementService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;

@Path("/v1/elements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ElementController {

    @Inject
    private ElementService elementService;

    @GET
    public Response getAll() {
        return Response.ok(elementService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") String id) {
        final Optional<Element> elementById = elementService.getElementById(id);
        if (elementById.isPresent()) {
            return Response.ok(elementById.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") String id) {
        elementService.delete(id);
        return Response.noContent().build();
    }

    @DELETE
    public Response delete() {
        elementService.delete();
        return Response.noContent().build();
    }

    @POST
    public Response create(Element element) {
        Element created = elementService.create(element);
        return Response.created(URI.create("/v1/elements/" + created.getId())).build();
    }

    @PUT
    @Path("/{id}")
    public Response replaceById(@PathParam("id") String id, Element element) {
        return elementService.replace(id, element)
            .map(e -> Response.ok(e).build())
            .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PATCH
    @Path("/{id}")
    public Response updateById(@PathParam("id") String id, Element element) {
        try {

            return elementService.merge(id, element)
                .map(e -> Response.ok(e).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());

        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(ErrorMessage.of(
                    Response.Status.BAD_REQUEST.getStatusCode(),
                    "Error updating the resource",
                    e.getMessage(),
                    null
                )).build();
        }
    }
}