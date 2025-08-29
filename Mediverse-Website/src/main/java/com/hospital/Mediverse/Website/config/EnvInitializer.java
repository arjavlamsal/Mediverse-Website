package com.hospital.Mediverse.Website.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvInitializer {

    @PostConstruct
    public void init() {
        try {
            // Load .env file from current directory or classpath (optional)
            Dotenv dotenv = Dotenv.configure()
                    .ignoreIfMissing() // This makes the .env file optional
                    .load();
            
            // Set system properties for each environment variable
            dotenv.entries().forEach(entry -> {
                String key = entry.getKey();
                String value = entry.getValue();
                System.setProperty(key, value);
            });
        } catch (Exception e) {
            // Log warning but don't fail startup if .env file is missing
            System.out.println("Warning: Could not load .env file: " + e.getMessage());
        }
    }
}
