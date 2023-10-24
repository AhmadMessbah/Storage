package com.mftplus.storage.controller.api;

import com.mftplus.storage.model.entity.Person;
import com.mftplus.storage.model.entity.User;
import com.mftplus.storage.model.service.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NoContentException;
import jakarta.ws.rs.core.Response;

import javax.inject.Inject;

@Path("/user")
public class UserApi {

    @Inject
    private UserService userService;

    @POST
    @Path("/register")
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
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(User user){
        try {
            return Response.ok().entity(userService.edit(user)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id){ // TODO remove int DataType and replace it with Long
        try {
            return Response.ok().entity(userService.remove(id)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            System.out.println("OUTPUT : "+userService.findAll());
            return Response.ok().entity(userService.findAll()).build();
        }catch (NoContentException e){
            return Response.noContent().build();
        }
        catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}") .build();
        }
    }

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findById/{id}")
    public Response findById(@PathParam("id") int id) { // TODO remove int DataType and replace it with Long
        System.out.println("FindById Method in UserApi");
        System.out.println("Id : "+id);
        try {
            return Response.ok().entity(userService.findById(id)).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();

        }
    }




}
