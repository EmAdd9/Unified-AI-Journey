package com.spring.ai.rag_app;

import com.spring.ai.rag_app.helpers.Helper;
import com.spring.ai.rag_app.service.ChatService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RagAppApplicationTests {

	private final Logger log = LoggerFactory.getLogger(RagAppApplicationTests.class);
	@Autowired
	private ChatService chatService;

	@Test
	public void testSavedata(){

		log.info("Saving datas into DB");
		try {
			this.chatService.saveData(Helper.getData());
		}catch (Exception ex){
			log.warn("Save Exception: "+ex.getMessage());
		}
	}
}
