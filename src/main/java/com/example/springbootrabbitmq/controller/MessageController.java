package com.example.springbootrabbitmq.controller;

import com.example.springbootrabbitmq.dto.CustomMessage;
import com.example.springbootrabbitmq.publisher.MessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private final MessageProducer producer;

    public MessageController(MessageProducer producer) {
        this.producer = producer;
    }

    // http://localhost:8080/api/v1/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }

    @PostMapping("/send")
    public void sendCustomMessage(@RequestBody CustomMessage message) {
        producer.sendCustomMessage(message);
    }
}
