package com.apache.kafka.events;

import com.apache.kafka.model.Event;
import com.apache.kafka.model.InternalProduct;
import com.apache.kafka.model.InternalUser;
import java.time.LocalDate;
import static com.apache.kafka.enums.Color.GREEN;
import static com.apache.kafka.enums.DesignType.SUITCASE;
import static com.apache.kafka.enums.ProductType.TSHIRT;
import static com.apache.kafka.enums.UserId.ABC123;


public class EventGenerator {

    public Event generateEvent() {
        return Event.builder()
                .user(generateRandomUser())
                .product(generateRandomObject())
                .build();
    }

    private InternalUser generateRandomUser() {
        return InternalUser.builder()
                .userId(ABC123)
                .username("benitex")
                .dateOfBirth(LocalDate.now())
                .build();
    }

    private InternalProduct generateRandomObject() {
        return InternalProduct.builder()
                .color(GREEN)
                .type(TSHIRT)
                .designType(SUITCASE)
                .build();
    }
}
