package com.bass.dms.documentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {
    @GetMapping
    public String test(){
        return "HELLO FROM DOCUMENT SERVICE!";
    }
}
