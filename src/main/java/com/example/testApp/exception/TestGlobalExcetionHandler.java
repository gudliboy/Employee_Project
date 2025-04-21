package com.example.testApp.exception;

import com.example.testApp.dto.response.TestResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TestGlobalExcetionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<TestResponseDto> handleRuntimeException(Exception ex){

//        Map<String,Object>errorDetails=new HashMap<>();
//        errorDetails.put("message",ex.getMessage());
//        errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        TestResponseDto testResponseDto=new TestResponseDto(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );

        return new ResponseEntity<>(testResponseDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
