package org.sport.foot.exceptions;

import org.sport.foot.service.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Response> handleEntityNotFoundException(EntityNotFoundException e){
        Response response = new Response(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<Response> handleEntityAlreadyExistException(EntityAlreadyExistException e){
        Response response = new Response(e.getMessage(), HttpStatus.FORBIDDEN.value());
        return new ResponseEntity<Response>(response, HttpStatus.FORBIDDEN);
    }


}
