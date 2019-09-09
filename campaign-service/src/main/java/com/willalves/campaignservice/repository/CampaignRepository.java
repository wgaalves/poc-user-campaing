package com.willalves.campaignservice.repository;

import com.willalves.campaignservice.model.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CampaignRepository extends MongoRepository<Campaign, Long> {
}
