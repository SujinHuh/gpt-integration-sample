package com.gpt.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gpt.dto.GptMessage;
import com.gpt.dto.GptRequest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureWebClient
class GptControllerTest {

    @Autowired
    private WebTestClient webTestClient;
    private static final Logger log = LoggerFactory.getLogger(GptControllerTest.class);

    @BeforeAll
    static void loadEnv() {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        System.setProperty("OPENAI_API_KEY", dotenv.get("OPENAI_API_KEY"));
    }

    @Test
    void gpt_response_test() {
        GptMessage message = new GptMessage("user","Spring Boot란?");
        GptRequest request = new GptRequest("gpt-3.5-turbo", List.of(message));

        webTestClient.post()
                .uri("/api/gpt/chat")
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .consumeWith(response ->
                        log.info("💬 GPT 응답: {}", response.getResponseBody())
                );
    }
}