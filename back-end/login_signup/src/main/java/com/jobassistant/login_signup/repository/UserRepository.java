package com.jobassistant.login_signup.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.jobassistant.login_signup.model.User;

public interface UserRepository extends MongoRepository<User, ObjectId>{
    @Query("{Email:'?0'}")
    public Optional<User> findbyEmail(String email);

}                  