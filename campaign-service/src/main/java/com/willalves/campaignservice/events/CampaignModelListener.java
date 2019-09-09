package com.willalves.campaignservice.events;

import com.willalves.campaignservice.model.Campaign;

import com.willalves.campaignservice.service.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class CampaignModelListener extends AbstractMongoEventListener<Campaign> {

    private SequenceGeneratorService sequenceGenerator;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Campaign> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Campaign.SEQUENCE_NAME));
        }
    }


}