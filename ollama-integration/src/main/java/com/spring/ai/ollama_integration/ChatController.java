package com.spring.ai.ollama_integration;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/api")
public class ChatController {
    private final Logger log = LoggerFactory.getLogger(ChatController.class);
    private final ChatClient chatClient;
    @Autowired
    public ChatController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chatWithLlama(@RequestParam("prompt") String message){
        @Nullable String response = null;
        try {
            response = chatClient.prompt(message).call().content();
        }catch (Exception exception){
            log.warn(exception.getMessage());
        }
        return ResponseEntity.ok(response);
    }
}
