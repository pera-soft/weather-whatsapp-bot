package com.perasoftware.chatbotwhatsapp.controller;

import com.perasoftware.chatbotwhatsapp.model.LocationMessage;
import com.perasoftware.chatbotwhatsapp.service.MessageService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @PostMapping(path = "/messages",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void handleIncomingMessage(LocationMessage payload) {
        logger.info("Payload: {}", payload);
        messageService.sendWeatherForecastMessage(payload);
    }
}