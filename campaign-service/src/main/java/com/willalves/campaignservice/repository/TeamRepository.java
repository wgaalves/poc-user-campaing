package com.willalves.campaignservice.repository;

import com.willalves.campaignservice.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, Long> {

    boolean existsByTeam(String s);
}
