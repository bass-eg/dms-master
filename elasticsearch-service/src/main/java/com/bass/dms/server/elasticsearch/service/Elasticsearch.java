package com.bass.dms.server.elasticsearch.service;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import com.bass.dms.server.elasticsearch.models.Document;
import com.bass.dms.server.elasticsearch.utils.CryptoException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Elasticsearch {
    Object createIndex(String indexName) throws IOException;

    Object addDoc(String index, Object object) throws IOException;

    List<Object> searchByKeywordInAllIndices(String keyword) throws IOException;

    Object deleteDoc(String index, String id) throws IOException;

    Object updateDoc(String id, String index, Object object) throws IOException;

    Object getDoc(String index, String id) throws IOException, ElasticsearchException;

    Document downloadDocument(File file) throws IOException, CryptoException;

}
