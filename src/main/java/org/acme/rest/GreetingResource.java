package org.acme.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/greeting")
public class GreetingResource {

    @Inject
    ReactiveGreetingService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public Uni<String> greeting(@PathParam String name) {
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}