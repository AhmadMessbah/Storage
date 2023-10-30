package com.mftplus.storage.controller.api;

import com.mftplus.storage.model.entity.Payment;
import com.mftplus.storage.model.entity.StorageTransaction;
import com.mftplus.storage.model.service.PaymentService;
import com.mftplus.storage.model.service.StorageTransactionService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NoContentException;
import jakarta.ws.rs.core.Response;

import javax.inject.Inject;

@Path("/storage")
public class StorageTransactionApi {
    @Inject
    private StorageTransactionService storageTransactionService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(StorageTransaction storageTransaction) {
        try {
            return Response.ok().entity(storageTransactionService.save(storageTransaction)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(StorageTransaction storageTransaction) throws Exception {
        try {
            return Response.ok().entity(storageTransactionService.edit(storageTransaction)).build();
        } catch (NoContentException e) {
            return Response.status(204).entity("{\"message\": \"No Content\"}").build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") Long id) throws Exception {
        try {
            return Response.ok().entity(storageTransactionService.remove(id)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception {
        try {
            return Response.ok().entity(storageTransactionService.findAll()).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) throws Exception {
        try {
            return Response.ok().entity(storageTransactionService.findById(id)).build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }
}
