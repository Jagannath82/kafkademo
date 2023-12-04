package com.jagan.demo.kafka.consumer;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class SimpleKafkaListerner {

    @KafkaListener(topics = "user-tracking", clientIdPrefix = "myClientId", id="foo", autoStartup = "${listen.auto.start:true}", concurrency = "${listen.concurrency:3}")
    public void listenGroupFoo(String message) {
        System.out.println("<<<<<<<<<<<<<<<<<<<Received Message in group foo>>>>>>>>>>>>>: " + message);
    }

}
