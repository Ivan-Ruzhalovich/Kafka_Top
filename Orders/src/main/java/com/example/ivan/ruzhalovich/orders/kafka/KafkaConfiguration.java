package com.example.ivan.ruzhalovich.orders.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    @Bean(name = "newTopic")
    public NewTopic newTopic(){
        return new NewTopic("new_orders",1,(short)1);
    }
}
