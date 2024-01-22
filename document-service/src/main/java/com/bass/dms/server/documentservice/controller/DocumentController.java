package com.bass.dms.server.documentservice.controller;

import com.bass.dms.server.common.entity.ContentObject;
import com.bass.dms.server.documentservice.services.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DocumentController {
    private final DocumentsService documentsService;
    private final Environment environment;

    @Autowired
    public DocumentController(DocumentsService documentsService, Environment environment) {
        this.documentsService = documentsService;
        this.environment = environment;
    }

    @GetMapping("/port")
    public String retrievePort() {
        return environment.getProperty("local.server.port");

    }

    @GetMapping("/doc/{name}")
    public ContentObject getContentObjectByName(@PathVariable("name") String name) {
        return documentsService.getDocumentByName(name);
    }

    @PostMapping("/doc")
    public ResponseEntity<?> addNewContentObject(@RequestBody ContentObject contentObject) {
        return documentsService.addNewDocument(contentObject) ? ResponseEntity.ok().build() : ResponseEntity.status(420).build();
    }
}
