package com.mftplus.storage.controller.api;

import com.mftplus.storage.model.entity.Person;
import com.mftplus.storage.model.entity.User;
import com.mftplus.storage.model.service.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.inject.Inject;

@Path("/register")
public class UserApi {

    @Inject
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(User user) throws Exception {
        try {
            return Response.ok().entity(userService.save(user)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(User user){
        try {
            return Response.ok().entity(userService.edit(user)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }



}
