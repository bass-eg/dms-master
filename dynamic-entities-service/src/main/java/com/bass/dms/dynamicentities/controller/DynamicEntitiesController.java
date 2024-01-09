package com.bass.dms.dynamicentities.controller;

import com.bass.dms.dynamicentities.entity.DynamicEntityRequest;
import com.bass.dms.dynamicentities.service.DynamicModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DynamicEntitiesController {
    private final DynamicModelService dynamicModelService;

    public DynamicEntitiesController(DynamicModelService dynamicModelService) {
        this.dynamicModelService = dynamicModelService;
    }

    @PostMapping("/test/{entityName}")
    public void getAllUsers(@PathVariable("entityName") String entityName,
                            @RequestBody List<DynamicEntityRequest> requestList) {
        dynamicModelService.createXML(entityName,requestList);
//        dynamicModelService.test();
    }

//    @GetMapping("/find-all/{entityClassName}/{column}/{matching}")
//    public ResponseEntity<List<Object>> findAll(@PathVariable("entityClassName") String entityClassName,
//                                                @PathVariable("column") String column,
//                                                @PathVariable("matching") String matching) {
//        List<Object> test = dynamicModelService.findAll(entityClassName, column, matching);
//        if (test.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(test);
//    }


}
