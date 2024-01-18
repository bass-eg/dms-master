package com.bass.dms.server.documentservice.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {
    private final Environment environment;

    public DocumentController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping
    public String test(){
        return "HELLO FROM DOCUMENT SERVICE!";
    }
    @GetMapping("/port")
    public String retrievePort() {
        return environment.getProperty("local.server.port");

    }
}
