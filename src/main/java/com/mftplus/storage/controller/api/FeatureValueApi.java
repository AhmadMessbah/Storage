package com.mftplus.storage.controller.api;

import com.mftplus.storage.model.service.FeatureValueService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NoContentException;
import jakarta.ws.rs.core.Response;

    @Path("/featurevalue")
    public class FeatureValueApi {
        @Inject
        private FeatureValueService featurevalueService;

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response save(FeatureValue featurevalue) {
            try {
//            BeanValidator<FeatureValue> validator = new BeanValidator<>();
//            validator.validate(group);

                return Response.ok().entity(featurevalueService.save(featurevalue)).build();
            } catch (Exception e) {
                return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
            }
        }

        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response edit(FeatureValue featurevalue) {
            try {
                return Response.ok().entity(featurevalueService.edit(featurevalue)).build();
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
                return Response.ok().entity(featurevalueService.remove(id)).build();
            } catch (Exception e) {
                return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
            }
        }

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response findAll() {
            try {
                System.out.println("OUTPUT : "+featurevalueService.findAll());
                return Response.ok().entity(featurevalueService.findAll()).build();
//        }catch (NoContentException e){
//            return Response.noContent().build();
            }
            catch (Exception e) {
                e.printStackTrace();
                return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}") .build();
            }
        }

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/{id}")
        public Response findById(@PathParam("id") String id) {
            System.out.println("FindById");
            System.out.println(id);

            try {
                return Response.ok().entity(featurevalueService.findById(Integer.valueOf(id))).build();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
            }
        }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/parent")
//    public Response findByParents() {
//        try {
//            return Response.ok().entity(featurevalueService.findParents()).build();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
//        }
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/parent/{parentId}")
//    public Response findByParentId(@PathParam("parentId") String parentId) {
//        System.out.println("FindByParentId");
//        System.out.println(parentId);
//        try {
//            return Response.ok().entity(featurevalueService.findByParentId(Integer.valueOf(parentId))).build();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
//        }
//    }
    }