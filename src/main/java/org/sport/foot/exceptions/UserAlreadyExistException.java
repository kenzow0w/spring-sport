package org.sport.foot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException(String message){
        super (message);
    }
}
