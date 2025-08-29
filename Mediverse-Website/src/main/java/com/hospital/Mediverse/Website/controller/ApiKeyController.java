package com.hospital.Mediverse.Website.controller;

import com.hospital.Mediverse.Website.config.EnvConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiKeyController {

    private final EnvConfig envConfig;

    @Autowired
    public ApiKeyController(EnvConfig envConfig) {
        this.envConfig = envConfig;
    }

    @GetMapping("/check-api-key")
    public String checkApiKey() {
        String apiKey = envConfig.getApiKey();
        return "API Key is configured: " + (apiKey != null && !apiKey.isEmpty() ? "Yes" : "No");
    }

    @GetMapping("/api-key")
    public String getApiKey() {
        return "API Key: " + envConfig.getApiKey();
    }
}
