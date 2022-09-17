package org.sport.foot.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class Response {
    private Integer code;
    private String message;

    public Response(String message, Integer code) {
        this.code = code;
        this.message = message;
    }
}
