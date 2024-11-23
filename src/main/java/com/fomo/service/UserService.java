package com.fomo.service;

import com.fomo.objects.entity.User;
import com.fomo.repository.UserRepository;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Uni<List<User>> getAllUsers(){
        return userRepository
                .listAll()
                .onFailure()
                .invoke(ex-> Log.error("Error retrieving users: "+ex));
    }

    public Uni<User> createUser(User user) {
        if(user.getUuid()==null)user.setUuid(UUID.randomUUID().toString());
        return userRepository
                .persistOrUpdate(user)
                .onFailure()
                .invoke(ex-> Log.error("Error retrieving users: "+ex));
    }
}
