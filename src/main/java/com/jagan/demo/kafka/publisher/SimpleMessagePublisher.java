package com.jagan.demo.kafka.publisher;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;


@Component
public class SimpleMessagePublisher {
    
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    public void publishMessage(String message){
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("user-tracking", message);
        future.whenComplete((result, ex)->{
            System.out.println("Message published " + result.getRecordMetadata());
        });
    }
}
