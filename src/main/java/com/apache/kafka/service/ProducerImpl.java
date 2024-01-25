package com.apache.kafka.service;

import com.apache.kafka.events.EventGenerator;
import com.apache.kafka.model.Event;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProducerImpl implements ProducerInterface {

    private final Producer<String, String> kafkaProducer;

    @Override
    @PostConstruct
    public void run() {

        try {
            EventGenerator eventGenerator = new EventGenerator();

            for(int i = 1; i <= 10; i++) {
                log.info("Generating event #" + i);

                Event event = eventGenerator.generateEvent();

                String key = extractKey(event);
                String value = extractValue(event);

                ProducerRecord<String, String> producerRecord = new ProducerRecord<>("user-tracking-avro", key, value);

                log.info("Producing to Kafka the record: " + key + ":" + value);
                kafkaProducer.send(producerRecord);

                sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        kafkaProducer.close();

    }

    private static String extractKey(Event event) {
        return event.getUser().getUserId().toString();
    }

    private static String extractValue(Event event) {
        return String.format("%s,%s,%s", event.getProduct().getType(), event.getProduct().getColor(), event.getProduct().getDesignType());
    }
}
