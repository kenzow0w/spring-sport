package org.sport.foot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class TeamAlreadyExistException extends Exception{
    public TeamAlreadyExistException(String message){
        super (message);
    }
}
