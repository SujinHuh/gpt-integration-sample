package com.gpt.integration;

import com.gpt.dto.GptRequest;
import com.gpt.dto.GptResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GptService {

    private final WebClient webClient;

    public Mono<String> getGptAnswer(GptRequest request){
        return webClient.post()
                .uri("/chat/completions")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(GptResponse.class)
                .map(response -> response.choices().get(0).message().content());
    }

}
