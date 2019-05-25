package com.service.administration.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data @AllArgsConstructor
public class UserError {

    private String message;
    private LocalDate date;
    //private String technicalMessage;
    private String code;
    private String path;


}
