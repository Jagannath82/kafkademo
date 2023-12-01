package com.jagan.demo.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jagan.demo.kafka.publisher.SimpleMessagePublisher;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    
    @Autowired
    SimpleMessagePublisher messagePublisher;

    @PostMapping
    public ResponseEntity<String> publishMessage(@RequestParam("newmsg") String message){
        messagePublisher.publishMessage(message);
        return new ResponseEntity<>("Message Published", HttpStatus.ACCEPTED);
    }
}
