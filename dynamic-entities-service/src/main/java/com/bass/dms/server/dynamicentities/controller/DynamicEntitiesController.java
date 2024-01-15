package com.bass.dms.server.dynamicentities.controller;

import com.bass.dms.server.dynamicentities.entity.DynamicEntityRequest;
import com.bass.dms.server.dynamicentities.service.DynamicModelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DynamicEntitiesController {
    private final DynamicModelService dynamicModelService;

    public DynamicEntitiesController(DynamicModelService dynamicModelService) {
        this.dynamicModelService = dynamicModelService;
    }

    @PostMapping("/create-entity/{entityName}")
    public void getAllUsers(@PathVariable("entityName") String entityName,
                            @RequestBody List<DynamicEntityRequest> requestList) {
        dynamicModelService.createXML(entityName,requestList);
    }



}
