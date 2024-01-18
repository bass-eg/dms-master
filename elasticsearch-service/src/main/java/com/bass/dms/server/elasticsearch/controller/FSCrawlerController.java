package com.bass.dms.server.elasticsearch.controller;

import com.bass.dms.server.elasticsearch.service.FSCrawler;
import com.bass.dms.server.elasticsearch.utils.CryptoException;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/fscrawler")
public class FSCrawlerController {
    private FSCrawler fsCrawler;

    @Autowired
    public FSCrawlerController(FSCrawler fsCrawler) {
        this.fsCrawler = fsCrawler;
    }

    @PostMapping
    public ResponseEntity<?> uploadFSCrawlerDocument(@RequestParam("file") MultipartFile file, @RequestParam("file-path") String filePath) throws IOException, CryptoException {
        Response response = fsCrawler.uploadDocument(file, filePath);
        if (response.isSuccessful()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(500).build();
        }
    }


}
