package com.bass.dms.server.elasticsearch.controller.handler;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ElasticsearchErrorHandler {


    @ResponseBody
    @ExceptionHandler(value = {JsonProcessingException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody handleJsonProcessingExceptions(JsonProcessingException ex) {
        List<String> violations = List.of("Failed to convert Response to JSON");
        violations.forEach(log::error);
        return ExceptionBody.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(violations)
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {IOException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody handleIOExceptions(IOException ex) {
        List<String> violations = List.of(ex.getMessage());
        violations.forEach(log::error);
        return ExceptionBody.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(violations)
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {ElasticsearchException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody handleElasticsearchExceptions(ElasticsearchException ex) {
        List<String> violations = List.of(ex.getMessage());
        violations.forEach(log::error);
        return ExceptionBody.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(violations)
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody handleRuntimeExceptions(RuntimeException ex) {
        List<String> violations = List.of("Unexpected error has occurred!");
        violations.forEach(log::error);
        return ExceptionBody.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(violations)
                .build();
    }

}
