package com.example.ivan.ruzhalovich.notifications.kafka;

import com.example.ivan.ruzhalovich.notifications.model.NotificationModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private static final Logger log = LoggerFactory.getLogger(NotificationProducer.class);
    private final NewTopic topic;

    public void sendStatusToDataBase(NotificationModel model){
        try {
            kafkaTemplate.send(topic.name(), objectMapper
                            .writeValueAsString(model))
                    .whenComplete((result, exception) -> {
                        if(exception==null)
                            log.info("Message id:{} was sent to{}",model.getId(),result.getProducerRecord().topic());
                        else log.error("Message id:{} was not sent, exception:{}",model.getId(),exception.getMessage());
                    });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
