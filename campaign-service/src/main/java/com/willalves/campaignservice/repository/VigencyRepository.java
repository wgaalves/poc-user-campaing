package com.willalves.campaignservice.repository;

import com.willalves.campaignservice.model.Vigency;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VigencyRepository extends MongoRepository<Vigency, String> {
    List<Vigency> findAllByInitGreaterThanEqualAndAndEndIsLessThanEqual(LocalDateTime init, LocalDateTime end);
}

