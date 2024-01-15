package com.bass.dms.server.elasticsearch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private Environment environment;

    @GetMapping("/port")
    public String retrieveExchangeValue() {


        return environment.getProperty("local.server.port");

    }

    @GetMapping("/inventory")
    public String test1() {
        return "Hello World!";
    }

    @GetMapping
    public String test2() {
        return "Hello World from test2!";
    }


}
