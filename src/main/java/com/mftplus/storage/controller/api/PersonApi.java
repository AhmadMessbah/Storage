package com.mftplus.storage.controller.api;

import com.mftplus.storage.model.entity.Person;
import com.mftplus.storage.model.service.PersonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NoContentException;
import jakarta.ws.rs.core.Response;


@Path("/person")
public class PersonApi {
    @Inject
    private PersonService personService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Person person) throws Exception {
        try {
            return Response.ok().entity(personService.save(person)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(Person person) {
        try {
            return Response.ok().entity(personService.edit(person)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        try {
            return Response.ok().entity(personService.remove(id)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            System.out.println("OUTPUT : " + personService.findAll());
            return Response.ok().entity(personService.findAll()).build();
        } catch (NoContentException e) {
            return Response.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        System.out.println("FindById Method in UserApi");
        System.out.println("Id : " + id);
        try {
            return Response.ok().entity(personService.findById(id)).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();

        }
    }
}
