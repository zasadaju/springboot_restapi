package com.aplikacja.przyklad1.repository;

import com.aplikacja.przyklad1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {

}