package com.willalves.campaignservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Campaign {

    @Transient
    public static final String SEQUENCE_NAME = "campaigns_sequence";

    @Id
    private Long id;

    @Indexed
    private Team team;

    private Vigency vigency;
}
