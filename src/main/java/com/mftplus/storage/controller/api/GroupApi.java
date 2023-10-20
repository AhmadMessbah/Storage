package com.mftplus.storage.controller.api;


import com.mftplus.storage.model.entity.Group;
import com.mftplus.storage.model.service.GroupService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NoContentException;
import jakarta.ws.rs.core.Response;

@Path("/group")
public class GroupApi {
    @Inject
    private GroupService groupService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Group group) {
        try {
            return Response.ok().entity(groupService.save(group)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(Group group) {
        try {
            return Response.ok().entity(groupService.edit(group)).build();
        } catch (NoContentException e) {
            return Response.status(204).entity("{\"message\": \"No Content\"}").build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") Integer id) {
        try {
            return Response.ok().entity(groupService.remove(id)).build();
        } catch (Exception e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            return Response.ok().entity(groupService.findAll()).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Path("/parents/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findParents(@PathParam("id") Integer id) {
        try {
            System.out.println(groupService.findParentsId(id));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") String id) {
        try {
            return Response.ok().entity(groupService.findById(Integer.valueOf(id))).build();
        } catch (Exception e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }
}
