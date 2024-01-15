package com.bass.dms.server.elasticsearch.service.implementation;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import com.bass.dms.server.elasticsearch.service.Elasticsearch;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ElasticsearchImpl implements Elasticsearch {

    private final ElasticsearchClient elasticsearchClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ElasticsearchImpl(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @Override
    public Object createIndex(String indexName) throws ElasticsearchException, IOException {
        CreateIndexResponse response;

        log.info("Creating index: {}", indexName);
        response = elasticsearchClient.indices().create(c -> c.index(indexName));
        log.info("Successfully created index: {}", indexName);

        String jsonString = response.toString().replace("CreateIndexResponse: ", "");
        return convertJsonStringToJson(jsonString);
    }

    @Override
    public Object addDoc(String index, Object object) throws ElasticsearchException, IOException {
        IndexResponse response;

        log.info("Creating document for index: {} in Elasticsearch", index);
        response = elasticsearchClient.index(i -> i.index(index).document(object));
        log.info("Successfully created document with id: {}", response.id());

        // convert JSON string to Map
        String jsonString = response.toString().replace("IndexResponse: ", "");
        return convertJsonStringToJson(jsonString);
    }

    @Override
    public List<Object> searchByKeywordInAllIndices(String keyword) throws ElasticsearchException, IOException {
        List<Object> result;

        log.info("Executing search statement for keyword: {}", keyword);
        SearchResponse<Object> response = elasticsearchClient.search(s -> s
                .query(q -> q.multiMatch(m -> m.query(keyword))), Object.class);
        result = response.hits().hits().stream().map(Hit::source).collect(Collectors.toList());
        log.info("Successfully searched for keyword: {}", keyword);

        return result;
    }

    @Override
    public Object deleteDoc(String index, String id) throws ElasticsearchException, IOException {
        DeleteResponse response;
        log.info("Deleting document with id: {}, and index: {}", id, index);
        response = elasticsearchClient.delete(d -> d.index(index).id(id));
        log.info("Successfully deleted document with id: {}, and index: {}", id, index);

        String jsonString = response.toString().replace("DeleteResponse: ", "");
        return convertJsonStringToJson(jsonString);
    }

    @Override
    public Object updateDoc(String id, String index, Object object) throws ElasticsearchException, IOException {
        UpdateResponse<Object> response;

        log.info("Updating document with id: {}, and index: {}", id, index);
        response = elasticsearchClient.update(u -> u.index(index).id(id).doc(object), Object.class);
        log.info("Successfully updated document with id: {}, and index: {}", id, index);

        String jsonString = response.toString().replace("UpdateResponse: ", "");
        return convertJsonStringToJson(jsonString);
    }

    @Override
    public Object getDoc(String index, String id) throws ElasticsearchException, IOException {
        GetResponse<Object> response;
        log.info("Getting document with id: {}, and index: {}", id, index);
        response = elasticsearchClient.get(g -> g.index(index).id(id), Object.class);
        log.info("Successfully executed get query for document with id: {}, and index: {}", id, index);
        String jsonString = response.toString().replace("GetResponse: ", "");
        return convertJsonStringToJson(jsonString);
    }

    private HashMap<String, String> convertJsonStringToJson(String jsonString) throws JsonProcessingException {
        return objectMapper.readValue(jsonString, HashMap.class);
    }
}


