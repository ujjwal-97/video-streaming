package com.fomo.objects.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;


@Data
@MongoEntity(database = "fomo", collection = "user")
public class User {
    @BsonId
    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
}
