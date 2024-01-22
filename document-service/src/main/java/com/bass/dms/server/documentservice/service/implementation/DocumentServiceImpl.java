package com.bass.dms.server.documentservice.service.implementation;

import com.bass.dms.server.common.entity.ContentObject;
import com.bass.dms.server.documentservice.repository.ContentObjectRepo;
import com.bass.dms.server.documentservice.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DocumentServiceImpl implements DocumentsService {

    @Autowired
    private ContentObjectRepo contentObjectRepo;


    @Override
    public boolean addNewDocument(ContentObject contentObject) {
        try {
            contentObjectRepo.save(contentObject);
            contentObjectRepo.flush();
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    @Override
    public void deleteDocument(ContentObject contentObject) {
        contentObjectRepo.delete(contentObject);
    }

    @Override
    public void updateDocument(ContentObject contentObject) {
        if (contentObjectRepo.existsById(Math.toIntExact(contentObject.getId()))) {
            contentObjectRepo.save(contentObject);
        }
    }

    @Override
    public ContentObject getDocumentByName(String name) {
        return contentObjectRepo.getContentObjectByName(name);

    }
}
