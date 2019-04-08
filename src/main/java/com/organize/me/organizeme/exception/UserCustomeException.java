package com.organize.me.organizeme.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class UserCustomeException extends ResponseEntityExceptionHandler {

    public ResponseEntity<UserError> handleUserNotFoundException(){
        UserError userError=new UserError(HttpStatus.NOT_FOUND.getReasonPhrase(), "","technical",String.valueOf(HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(userError,HttpStatus.NOT_FOUND);
    }
}
