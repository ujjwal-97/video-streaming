@Entity
public class RoomParticipant {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Room room;
    
    private String userId;
    private Role role;
    
    // Getters, setters, and constructors
}

public enum Role {
    CREATOR, PARTICIPANT
} 