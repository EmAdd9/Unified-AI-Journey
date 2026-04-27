package com.spring.ai.initproject.first_project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatService {

    private static final String CHAT_CLIENT_FAILURE = "ChatClient ERR01";
    private final Logger log = LoggerFactory.getLogger(ChatService.class);
    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }

    public String promptChatting(MessageBody messageBody) throws Exception {
        String responseAi = null;

        try{
            responseAi = chatClient
                    .prompt(messageBody.getPrompt())
                    .call().content();

        }catch (Exception e){
            log.info("ChatClient Exception: "+e.getMessage());
        }

        if(responseAi == null){
            throw new RuntimeException(CHAT_CLIENT_FAILURE);
        }
        return responseAi;
    }

}
