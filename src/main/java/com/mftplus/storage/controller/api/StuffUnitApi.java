package com.mftplus.storage.controller.api;

import com.mftplus.storage.model.entity.StuffUnit;
import com.mftplus.storage.model.service.StuffUnitService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.xbean.finder.AnnotationFinder;

import javax.inject.Inject;

@Path("/Unit")
public class StuffUnitApi {
    @Inject
    private StuffUnitService stuffUnitService;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(StuffUnit stuffUnit){
        try {
            return Response.ok().entity(stuffUnitService.save(stuffUnit).build());

        }catch (Exception e){
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
            {
        }
    }

}
