package com.cenk.tutorial.rabbitmqsender.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The type Sender service.
 */
@Component
public class SenderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${cenk.tutorial.topicExchangeName}")
    private String topicExchangeName;

    @Value("${cenk.tutorial.routingKey}")
    private String routingKey;

    /**
     * Push string.
     *
     * @param message the message
     * @return the string
     */
    public String push(String message) {
        rabbitTemplate.convertAndSend(topicExchangeName, routingKey, message);

        System.out.println("Message Sending: " + message);
        return message;
    }
}
