package com.example.resource;

import com.example.model.Room;
import com.example.service.RoomService;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/api/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {
    @Inject
    RoomService roomService;
    
    @POST
    public Response createRoom(@Context SecurityContext securityContext) {
        String userId = securityContext.getUserPrincipal().getName();
        Room room = roomService.createRoom(userId);
        return Response.ok(room).build();
    }
    
    @POST
    @Path("/{roomCode}/join")
    public Response joinRoom(@PathParam("roomCode") String roomCode, 
                           @Context SecurityContext securityContext) {
        String userId = securityContext.getUserPrincipal().getName();
        roomService.addParticipant(roomCode, userId);
        return Response.ok().build();
    }
} 