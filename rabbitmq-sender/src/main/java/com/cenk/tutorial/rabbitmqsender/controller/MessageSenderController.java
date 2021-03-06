package com.cenk.tutorial.rabbitmqsender.controller;

import com.cenk.tutorial.rabbitmqsender.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Message controller.
 */
@RestController
@RequestMapping("api/v1/message")
public class MessageSenderController {

    @Autowired
    private SenderService senderService;

    /**
     * Message push response entity.
     *
     * @param message the message
     * @return the response entity
     */
    @PostMapping("/push")
    public ResponseEntity<String> messagePush(@RequestParam(required = true) String message) {
        return ResponseEntity.ok(senderService.push(message));
    }

}
