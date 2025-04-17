package com.gpt.controller;

import com.gpt.dto.GptRequest;
import com.gpt.integration.GptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gpt")
public class GptController {

    private final GptService gptService;

    @PostMapping("chat")
    public ResponseEntity<String> getChatResponse(@RequestBody GptRequest request){
        String response = gptService.getGptAnswer(request).block();
        return ResponseEntity.ok(response);
    }

}
