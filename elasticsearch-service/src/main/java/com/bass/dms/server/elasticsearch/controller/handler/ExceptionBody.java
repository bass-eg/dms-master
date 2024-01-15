package com.bass.dms.server.elasticsearch.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ExceptionBody {

    private final String code;
    private final List<String> message;


}