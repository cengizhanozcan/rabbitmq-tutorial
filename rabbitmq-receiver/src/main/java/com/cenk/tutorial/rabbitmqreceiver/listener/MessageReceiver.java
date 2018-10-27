package com.cenk.tutorial.rabbitmqreceiver.listener;


import org.springframework.stereotype.Component;

/**
 * The type Message receiver.
 */
@Component
public class MessageReceiver {

    /**
     * Receive message.
     *
     * @param message the message
     */
    public void receiveMessage(String message) {
        System.out.println("Received Message: " + message);
    }

}
