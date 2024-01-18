package com.bass.dms.server.elasticsearch.service;

import com.bass.dms.server.elasticsearch.models.Document;
import com.bass.dms.server.elasticsearch.utils.CryptoException;
import okhttp3.Response;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface FSCrawler {

    public Response uploadDocument(MultipartFile file, String filePath) throws CryptoException, IOException;

}
