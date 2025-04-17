package com.gpt.dto;

import java.util.List;

public record GptRequest(
        String model,
        List<GptMessage> messages
) {}