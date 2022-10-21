package org.sport.foot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class EntityAlreadyExistException extends RuntimeException{
    public EntityAlreadyExistException(String message){
        super (message);
    }
}
