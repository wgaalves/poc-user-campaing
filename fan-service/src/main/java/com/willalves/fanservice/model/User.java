package com.willalves.fanservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Document
public class User {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private Long id;

    @Indexed
    @NotBlank(message = "O nome do usuario é obrigatorio")
    private String fullname;

    @Indexed
    @NotBlank(message = "O email do usuario é obrigatorio")
    private String email;

    @NotBlank(message = "Data de nascimento do usuario é obrigatorio")
    private Date bornDate;

    @NotBlank(message = "O time do coração é obrigatoria")
    private String heartTeam;

    @JsonIgnore
    private Set<String> authorities = new HashSet<>();
}
