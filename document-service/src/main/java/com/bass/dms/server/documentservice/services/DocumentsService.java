package com.bass.dms.server.documentservice.services;

import com.bass.dms.server.common.entity.ContentObject;

public interface DocumentsService {

    public boolean addNewDocument(ContentObject contentObject);

    public void deleteDocument(ContentObject contentObject);

    public void updateDocument(ContentObject contentObject);

    public ContentObject getDocumentByName(String name);

}
