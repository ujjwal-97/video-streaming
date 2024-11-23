//@ServerEndpoint("/room/{roomCode}")
//@ApplicationScoped
//public class RoomWebSocket {
//    @Inject
//    RoomService roomService;
//
//    private Map<String, Session> sessions = new ConcurrentHashMap<>();
//
//    @OnOpen
//    public void onOpen(Session session, @PathParam("roomCode") String roomCode) {
//        sessions.put(session.getId(), session);
//        // Add participant to room
//    }
//
//    @OnMessage
//    public void onMessage(String message, @PathParam("roomCode") String roomCode) {
//        JsonObject jsonMessage = Json.createReader(new StringReader(message)).readObject();
//        String action = jsonMessage.getString("action");
//
//        switch (action) {
//            case "PLAY":
//                handlePlay(roomCode, jsonMessage);
//                break;
//            case "PAUSE":
//                handlePause(roomCode, jsonMessage);
//                break;
//            case "SEEK":
//                handleSeek(roomCode, jsonMessage);
//                break;
//            // Handle other actions
//        }
//    }
//
//    private void broadcast(String roomCode, JsonObject message) {
//        // Broadcast message to all participants in room
//    }
//}