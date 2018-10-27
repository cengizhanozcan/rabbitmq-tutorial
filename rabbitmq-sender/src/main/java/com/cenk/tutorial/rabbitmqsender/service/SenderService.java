package com.cenk.tutorial.rabbitmqsender.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String push(String message) {
        rabbitTemplate.convertAndSend("rabbitmq-exchange", "foo.bar.baz", message);
        System.out.println("Message Sending: " + message);
        return message;
    }
}
