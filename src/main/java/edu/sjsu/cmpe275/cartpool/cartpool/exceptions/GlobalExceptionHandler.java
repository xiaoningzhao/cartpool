package edu.sjsu.cmpe275.cartpool.cartpool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
@org.springframework.web.bind.annotation.ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseBody handleException(Exception e){
        e.printStackTrace();
        return new ResponseBody(LocalDateTime.now().toString(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getClass().getSimpleName(), e.getMessage());
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseBody handleConflictException(Exception e){
        System.out.println(e.getMessage());
        return new ResponseBody(LocalDateTime.now().toString(), HttpStatus.CONFLICT.value(), e.getClass().getSimpleName(), e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseBody handleNotFoundException(Exception e){
        System.out.println(e.getMessage());
        return new ResponseBody(LocalDateTime.now().toString(), HttpStatus.NOT_FOUND.value(), e.getClass().getSimpleName(), e.getMessage());
    }
}
