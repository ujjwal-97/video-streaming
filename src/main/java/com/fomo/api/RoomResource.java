import com.fomo.objects.entity.Room;
import com.fomo.service.RoomService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

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