package com.mftplus.storage.controller.api;

import com.mftplus.storage.model.entity.Role;
import com.mftplus.storage.model.service.RoleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NoContentException;
import jakarta.ws.rs.core.Response;

@Path("/role")
public class RoleApi {
    @Inject
    private RoleService roleService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Role role) {
        try {
            return Response.ok().entity(roleService.save(role)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(Role role) {
        try {
            return Response.ok().entity(roleService.edit(role)).build();
        } catch (NoContentException e) {
            return Response.status(204).entity("{\"message\": \"No Content\"}").build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") Long id) {
        try {
            return Response.ok().entity(roleService.remove(id)).build();
        } catch (Exception e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            System.out.println("OUTPUT : " + roleService.findAll());
            return Response.ok().entity(roleService.findAll()).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") String id) {
        try {
            return Response.ok().entity(roleService.findById(Long.valueOf(id))).build();
        } catch (Exception e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }
}
