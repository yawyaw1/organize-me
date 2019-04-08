package com.organize.me.organizeme.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class UserError {

    private String message;
    private String date;
    private String technicakMessage;
    private String code;


}
