package com.mftplus.storage.controller.api;

import com.mftplus.storage.model.entity.StuffUnit;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.inject.Inject;

@Path("/Stuff")

public class StuffApi {
    @Inject
    private StuffService stuffService;
    @Inject
    private StuffUnitService stuffUnitService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Stuff stuff) {


        try {

            return Response.ok().entity(stuffServiceService.save(stuff)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(StuffUnit stuffunit) {
        try {
            return Response.ok().entity(stuffUnitService.save(stuffunit)).build();

        } catch (Exception e) {
            return Response.status(500).entity("{\"message\":"+e.getMessage()+"\"}").build();
        }
    }
}