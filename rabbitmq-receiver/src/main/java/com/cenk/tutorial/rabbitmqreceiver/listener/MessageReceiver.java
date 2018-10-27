package com.cenk.tutorial.rabbitmqreceiver.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(bindings = @QueueBinding(value = @Queue(name = "test-queue", durable = "true"), exchange = @Exchange(value = "test-exchange")))
public class MessageReceiver {

    @RabbitHandler()
    public void receiver(String message) {
        System.out.println("Received: " + message);
    }
}
