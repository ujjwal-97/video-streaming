package com.fomo.objects.entity;

//import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

//@Entity
@Data
@Accessors(chain = true)
public class Room {
//    @Id
//    @GeneratedValue
    private Long id;
    
    private String roomCode;
    private String creatorId;
    private String currentVideo;
    private VideoStatus status = VideoStatus.STOPPED;
    private Double currentTime = 0.0;
    
//    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<RoomParticipant> participants = new HashSet<>();
}