package com.bass.dms.server.elasticsearch.controller;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import com.bass.dms.server.elasticsearch.models.Document;
import com.bass.dms.server.elasticsearch.service.Elasticsearch;
import com.bass.dms.server.elasticsearch.utils.CryptoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class ElasticsearchController {

    private final Elasticsearch elasticSearch;

    public ElasticsearchController(Elasticsearch elasticSearch) {
        this.elasticSearch = elasticSearch;
    }

    @GetMapping(value = "/create-index/{index}")
    public Object createIndex(@PathVariable String index) throws IOException, ElasticsearchException {
        return elasticSearch.createIndex(index);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/{index}")
    public Object createDocument(@PathVariable String index, @RequestBody Object object) throws IOException, ElasticsearchException {
        return elasticSearch.addDoc(index, object);
    }

    @GetMapping(value = "/find/{keyWord}")
    public List<Object> searchByKeywordInAllIndices(@PathVariable String keyWord) throws IOException, ElasticsearchException {
        return elasticSearch.searchByKeywordInAllIndices(keyWord);
    }

    @DeleteMapping("/{index}/{id}")
    public Object deleteDoc(@PathVariable String index, @PathVariable String id) throws IOException, ElasticsearchException {
        return elasticSearch.deleteDoc(index, id);
    }

    @PutMapping("/{index}/{id}")
    public Object updateDoc(@PathVariable String index, @PathVariable String id, @RequestBody Object object) throws IOException, ElasticsearchException {
        return elasticSearch.updateDoc(id, index, object);
    }

    @GetMapping("/{index}/{id}")
    public Object getDoc(@PathVariable String index, @PathVariable String id) throws IOException, ElasticsearchException {
        return elasticSearch.getDoc(index, id);
    }

    @GetMapping("/download-file")
    public Document downloadFile(@RequestParam("file") String fileName) throws CryptoException, IOException {
        fileName = fileName.replaceAll("/", "\\\\");
        File file = new File(fileName);
        return elasticSearch.downloadDocument(file);
    }

}
