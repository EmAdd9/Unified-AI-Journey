package com.spring.ai.initproject.first_project;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }

    public String promptChatting(MessageBody messageBody){
        String responseAi = "";

        try{
            responseAi = chatClient
                    .prompt(messageBody.getPrompt())
                    .call().content();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return responseAi;
    }

}
