package com.support.incident_api.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//for handling exception 
@ControllerAdvice
public class GlobalExceptionHandler{


    @ExceptionHandler(RuntimeException.class)

    public ResponseEntity<Map<String,Object>> handleRunTimeException(RuntimeException ex){

        Map<String ,Object> error= new HashMap<>();
        error.put("timestamp",LocalDateTime.now());
        error.put("error","Application Error");
        error.put("message",ex.getMessage());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}