package com.spring.ai.initproject.first_project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatService {

    private static final String CHAT_CLIENT_FAILURE = "ChatClient ERR01";
    private final Logger log = LoggerFactory.getLogger(ChatService.class);
    private final ChatClient openAiChatClient;
    private final ChatClient ollamaChatClient;

    public ChatService(@Qualifier("openAiChatClient") ChatClient openAiChatClient, @Qualifier("ollamaChatClient") ChatClient ollamaChatClient) {
        this.openAiChatClient = openAiChatClient;
        this.ollamaChatClient = ollamaChatClient;
    }

    public String promptChatting(MessageBody messageBody) throws Exception {
        String responseAi = null;

        try{
            responseAi = this.ollamaChatClient
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
