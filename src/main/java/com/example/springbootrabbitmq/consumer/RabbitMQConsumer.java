package com.example.springbootrabbitmq.consumer;

import com.example.springbootrabbitmq.dto.CustomMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        LOGGER.info(String.format("Received message -> %s", message));
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void receiveCustomMessage(CustomMessage message) {
        System.out.println("Received custom message: " + message.getContent());
        System.out.println("Priority: " + message.getPriority());
        // Add your processing logic here
    }
}
