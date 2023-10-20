package com.mftplus.storage.controller.api;

import com.mftplus.storage.model.entity.Stuff;
import com.mftplus.storage.model.entity.StuffUnit;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.inject.Inject;

@Path("/Stuff")

public class StuffApi {
    @Inject
    private StuffService stuffService;
    @Inject
    private StuffService stuffUnitService;


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


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(StuffUnit stuffunit) {
        try {
            return Response.ok().entity(stuffService.save(stuffunit)).build();

        } catch (Exception e) {
            return Response.status(500).entity("{\"message\":" + e.getMessage() + "\"}").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") Long id) {

    }