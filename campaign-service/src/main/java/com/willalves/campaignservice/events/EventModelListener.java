package com.willalves.campaignservice.events;

import com.willalves.campaignservice.model.Campaign;
import com.willalves.campaignservice.model.Team;
import com.willalves.campaignservice.service.SequenceGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class EventModelListener extends AbstractMongoEventListener<Team> {
    private SequenceGeneratorService sequenceGenerator;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Team> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Team.SEQUENCE_NAME));
        }
    }
}
