package com.cenk.tutorial.rabbitmqsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Rabbitmq sender application.
 */
@SpringBootApplication
public class RabbitmqSenderApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqSenderApplication.class, args);
    }
}
