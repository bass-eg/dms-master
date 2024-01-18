package com.bass.dms.server.elasticsearch.controller;

import com.bass.dms.server.elasticsearch.feign.DocumentServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TestController {

    @Autowired
    private Environment environment;
    private final DocumentServiceProxy documentServiceProxy;

    public TestController(DocumentServiceProxy documentServiceProxy) {
        this.documentServiceProxy = documentServiceProxy;
    }

    @GetMapping("/port")
    public String retrieveExchangeValue() {


        return environment.getProperty("local.server.port");

    }

    @GetMapping("/document-port")
    public String test1() {
        return "The document service port is " + documentServiceProxy.retrievePort();
    }

    @GetMapping
    public String test2() {
        return "Hello World from test2!";
    }


}
