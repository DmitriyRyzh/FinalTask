package com.rdm.rdm.config;

/*import com.rdm.rdm.kafka.Log;
import com.rdm.rdm.kafka.Message;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration */
public class KafkaProducerConfig {
/*
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public ProducerFactory<String, Message> messageProducerFactory() {
        return new DefaultKafkaProducerFactory<>(getCommonConfigProperties());
    }
    @Bean
    public KafkaTemplate<String, Message> messageKafkaTemplate() {
        return new KafkaTemplate<>(messageProducerFactory());
    }

    @Bean
    public ProducerFactory<String, Log> logProducerFactory() {
        return new DefaultKafkaProducerFactory<>(getCommonConfigProperties());
    }

    @Bean
    public KafkaTemplate<String, Log> logKafkaTemplate() {
        return new KafkaTemplate<>(logProducerFactory());
    }

    private Map<String, Object> getCommonConfigProperties() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return configProps;
    }

 */
}