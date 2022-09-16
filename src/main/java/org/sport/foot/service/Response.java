package org.sport.foot.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class Response {

    private Integer code;
    private String message;


    @Autowired
    public Response(String message, Integer code) {
        this.code = code;
        this.message = message;
    }

    @Autowired
    public Response(String message) {
        this.message = message;
    }
}
