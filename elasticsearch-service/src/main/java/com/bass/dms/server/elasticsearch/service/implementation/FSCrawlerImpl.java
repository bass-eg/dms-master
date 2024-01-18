package com.bass.dms.server.elasticsearch.service.implementation;

import com.bass.dms.server.elasticsearch.service.FSCrawler;
import com.bass.dms.server.elasticsearch.utils.CryptoException;
import com.bass.dms.server.elasticsearch.utils.CryptoUtils;
import okhttp3.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FSCrawlerImpl implements FSCrawler {
    private transient OkHttpClient client;


    public FSCrawlerImpl() {
        client = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.MINUTES) // connect timeout
                .writeTimeout(3, TimeUnit.MINUTES) // write timeout
                .readTimeout(3, TimeUnit.MINUTES) // read timeout
                .build();
    }

    /*
     * setting the file name as the path from the root from the api
     *  sending the file to the fscrawler api
     * */
    @Override
    public Response uploadDocument(MultipartFile file, String filePath) throws CryptoException, IOException {
        File InputFile = new File("E:\\Doc-Man-Sys\\" + file.getOriginalFilename());
        System.err.println(InputFile.getName());

        OutputStream output = new FileOutputStream(InputFile);
        output.write(file.getInputStream().readAllBytes());
        output.close();

        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("file", filePath, RequestBody.create(MediaType.parse("application/octet-stream"), InputFile));
        RequestBody body = builder.build();
        Request request = new Request.Builder()
                .url(filePath)
                .method("POST", body)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException ex) {
            Logger.getLogger(FSCrawlerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        CryptoUtils.encrypt(InputFile, InputFile);
        return response;
    }
}
