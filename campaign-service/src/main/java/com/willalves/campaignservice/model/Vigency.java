package com.willalves.campaignservice.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Document
public class Vigency {

    private LocalDateTime init;
    private LocalDateTime end;
}
