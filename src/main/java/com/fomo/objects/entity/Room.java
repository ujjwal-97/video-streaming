@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    
    private String roomCode;
    private String creatorId;
    private String currentVideo;
    private VideoStatus status = VideoStatus.STOPPED;
    private Double currentTime = 0.0;
    
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<RoomParticipant> participants = new HashSet<>();
    
    // Getters, setters, and constructors
}

public enum VideoStatus {
    PLAYING, PAUSED, STOPPED
} 