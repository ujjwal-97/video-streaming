package com.fomo.repository;

import com.fomo.objects.entity.User;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class UserRepository implements ReactivePanacheMongoRepositoryBase<User, UUID> {
}
