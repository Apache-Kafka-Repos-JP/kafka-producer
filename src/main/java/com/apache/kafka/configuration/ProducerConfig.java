package com.apache.kafka.configuration;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Optional;
import java.util.Properties;

@Configuration
public class ProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.producer.key-serializer}")
    private String keySerializer;

    @Value("${spring.kafka.producer.value-serializer}")
    private String valueSerializer;

    private Properties getKafkaConsumerProperties() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("key.serializer", keySerializer);
        properties.put("value.serializer", valueSerializer);
        properties.put("schema.registry.url", "http://localhost:8081");
        return properties;
    }

    @Bean
    @Primary
    public Producer<String, String> createProducer() {
        return new KafkaProducer<>(getKafkaConsumerProperties());
    }

    @Bean
    public Producer<String, String> createProducer2(Optional<String> hola) {
        System.out.println("hola" + hola);
        return new KafkaProducer<>(getKafkaConsumerProperties());
    }


}
