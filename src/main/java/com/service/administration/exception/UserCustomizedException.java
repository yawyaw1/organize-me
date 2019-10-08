package com.service.administration.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;


@ControllerAdvice
public class UserCustomizedException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserError> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
        UserError userError=new UserError(ex.getMessage(), LocalDate.now(),"404",request.getDescription(false));
        return new ResponseEntity<>(userError,HttpStatus.NOT_FOUND);
    }
}
