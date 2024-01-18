package com.bass.dms.server.elasticsearch.models;

import lombok.Data;

@Data
public class Document {
    private String name;
    private byte[] content;

}
