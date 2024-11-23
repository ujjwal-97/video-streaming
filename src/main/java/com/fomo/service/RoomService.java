package com.fomo.service;

import com.fomo.objects.entity.Role;
import com.fomo.objects.entity.Room;
import com.fomo.objects.entity.RoomParticipant;
import com.fomo.objects.entity.VideoStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class RoomService {
    @Inject
    EntityManager em;
    
    public Room createRoom(String creatorId) {
        Room room = new Room();
        room.setRoomCode(generateUniqueCode());
        room.setCreatorId(creatorId);
        
        RoomParticipant creator = new RoomParticipant();
        creator.setUserId(creatorId);
        creator.setRole(Role.CREATOR);
        creator.setRoom(room);
        
        room.getParticipants().add(creator);
        
        em.persist(room);
        return room;
    }

    public void addParticipant(String roomCode, String userId) {
        Room room = findByCode(roomCode);
        // Add participant logic
    }

    public void updateVideoStatus(String roomCode, VideoStatus status, Double currentTime) {
        Room room = findByCode(roomCode);
        room.setStatus(status);
        room.setCurrentTime(currentTime);
        em.merge(room);
    }
} 