package com.willalves.fanservice.repository;

import com.willalves.fanservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    boolean existsByEmail(String s);
}
