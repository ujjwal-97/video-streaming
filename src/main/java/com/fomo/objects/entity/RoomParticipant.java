package com.fomo.objects.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.experimental.Accessors;


@Entity
@Data
@Accessors(chain = true)
public class RoomParticipant {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Room room;
    
    private String userId;
    private Role role;
}

