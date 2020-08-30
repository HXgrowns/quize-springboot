package com.thoughtworks.rslist.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity handle(Exception e) {
        if (e instanceof ProductException) {
            ErrorEnum.BUSSINESS_ERROR.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(ErrorEnum.BUSSINESS_ERROR);
        }
        return ResponseEntity.badRequest().body(ErrorEnum.UNKNOWN_ERROR);
    }
}
