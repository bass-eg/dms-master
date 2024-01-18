package com.bass.dms.server.elasticsearch.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "document-service")
public interface DocumentServiceProxy {
    @GetMapping("/document-service/port")
    String retrievePort();
}
