package com.willalves.campaignservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Team {

    @Transient
    public static final String SEQUENCE_NAME = "teams_sequence";


    @Id
    private Long id;

    @Indexed
    private String team;

}
