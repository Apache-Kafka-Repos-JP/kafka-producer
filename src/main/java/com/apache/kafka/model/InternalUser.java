package com.apache.kafka.model;

import com.apache.kafka.enums.UserId;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class InternalUser {

    private UserId userId;

    private String username;

    private LocalDate dateOfBirth;

}
