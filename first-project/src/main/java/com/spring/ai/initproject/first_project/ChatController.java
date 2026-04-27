package com.spring.ai.initproject.first_project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;
    @Autowired
    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }
    @GetMapping("/v1/chat")
    public ResponseEntity<String> chatWithGpt(@RequestBody MessageBody msg) throws Exception {
       return ResponseEntity.ok(chatService.promptChatting(msg));
    }
}
