package com.mftplus.storage.controller.api;

import com.mftplus.storage.model.entity.Stuff;
import com.mftplus.storage.model.service.StuffService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.inject.Inject;

@Path("/Stuff")

public class StuffApi {
    @Inject
    private StuffService stuffService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Stuff stuff) {


        try {

            return Response.ok().entity(stuffService.save(stuff)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }


    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") Long id) {
        try {
            return Response.ok().entity(stuffService.remove(id)).build();
        } catch (Exception e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();

        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            return Response.ok().entity(stuffService.findAll()).build();
        } catch (Exception e) {
            return Response.status(404).build();

        }
    }

@GET
@Path("/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Response findById(@PathParam("id") Long id){
    try {
        return Response.ok().entity(stuffService.findById(id)).build();

    }catch (Exception e){
        return Response.status(404).build();
    }

    }
}