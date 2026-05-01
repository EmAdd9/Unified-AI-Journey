package com.spring.ai.initproject.first_project;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AiConfig {

    @Bean(name = "openAiChatClient")
    ChatClient openAiChatModel(OpenAiChatModel openAiChatModel){
        return ChatClient.builder(openAiChatModel).build();
    }

    @Bean(name = "ollamaChatClient")
    ChatClient ollamaChatModel(OllamaChatModel ollamaChatModel){
        return ChatClient.builder(ollamaChatModel).build();
    }

}
