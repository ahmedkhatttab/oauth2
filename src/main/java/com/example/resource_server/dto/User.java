package com.example.resource_server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class User {

    private Long id;

    private String fullName;

    private LocalDateTime dob;

    private Gender gender;
}
