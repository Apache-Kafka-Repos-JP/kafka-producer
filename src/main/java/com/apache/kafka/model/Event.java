package com.apache.kafka.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Event {

    private InternalUser user;
    private InternalProduct product;

}
