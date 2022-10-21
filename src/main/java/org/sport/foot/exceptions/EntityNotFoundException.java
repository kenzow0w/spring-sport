package org.sport.foot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String message){
        super (message);
    }
}
