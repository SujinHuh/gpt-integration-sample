package com.gpt;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GptIntegrationSampleApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        System.setProperty("OPENAI_API_KEY", dotenv.get("OPENAI_API_KEY"));
        SpringApplication.run(GptIntegrationSampleApplication.class, args);
    }

}
