package com.gpt.dto;

import org.apache.logging.log4j.message.Message;

import java.awt.*;
import java.util.List;

public record GptResponse (
    List <Choice> choices
){
    public record Choice(
            Message message
    ){
        public record Message(
                String role,
                String content
        ){}
    }
}
