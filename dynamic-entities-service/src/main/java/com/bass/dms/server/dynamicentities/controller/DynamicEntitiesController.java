package com.bass.dms.server.dynamicentities.controller;

import com.bass.dms.server.dynamicentities.entity.DynamicEntityRequest;
import com.bass.dms.server.dynamicentities.feign.DocumentServiceProxy;
import com.bass.dms.server.dynamicentities.service.DynamicModelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DynamicEntitiesController {
    private final DynamicModelService dynamicModelService;
    private final DocumentServiceProxy documentServiceProxy;


    public DynamicEntitiesController(DynamicModelService dynamicModelService, DocumentServiceProxy documentServiceProxy) {
        this.dynamicModelService = dynamicModelService;
        this.documentServiceProxy = documentServiceProxy;
    }

    @PostMapping("/create-entity/{entityName}")
    public void getAllUsers(@PathVariable("entityName") String entityName,
                            @RequestBody List<DynamicEntityRequest> requestList) {
        dynamicModelService.createXML(entityName, requestList);
    }


    @GetMapping("/document-port")
    public String test1() {
        return "The document service port is " + documentServiceProxy.retrievePort();
    }
}
