package org.github.wildfly.mongo.boilerplate.resource;

import org.github.wildfly.mongo.boilerplate.facade.SampleFacade;
import org.github.wildfly.mongo.boilerplate.model.Sample;
import org.github.wildfly.mongo.boilerplate.service.MyService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;

import static javax.ws.rs.core.Response.Status.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 *
 */
@Stateless
@Path("/sample")
public class SampleResource {

    @EJB
    private SampleFacade sampleFacade;

    @EJB
    private MyService myService;

    @GET
    public String test() {
        return "Hello!";
    }

    @GET
    @Path("/{name}")
    @Produces(APPLICATION_JSON)
    public Sample get(@PathParam("name") final String name) {
        return this.sampleFacade.get(name);
    }

    @DELETE
    @Path("/{name}")
    public void delete(@PathParam("name") final String name) {
        if (this.sampleFacade.delete(name) == false) {
            throw new WebApplicationException(NOT_FOUND);
        }
    }

    @POST
    @Path("/{name}")
    @Consumes(APPLICATION_JSON)
    public void add(
            @PathParam("name") final String name,
            @NotNull final Sample sample)
    {
        sample.name = name;
        this.sampleFacade.add(sample);
    }

}
