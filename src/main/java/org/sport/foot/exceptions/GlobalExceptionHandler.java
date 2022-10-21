package org.sport.foot.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Response> handleEntityNotFoundException(EntityNotFoundException e) {
        Response response = new Response(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<Response> handleEntityAlreadyExistException(EntityAlreadyExistException e) {
        Response response = new Response(e.getMessage(), HttpStatus.CONFLICT.value());
        return new ResponseEntity<Response>(response, HttpStatus.CONFLICT);
    }


    @Getter
    @Setter
    class Response {

        private Integer code;
        private String message;

        public Response(String message, Integer code) {
            this.code = code;
            this.message = message;
        }

        public Response(String message) {
            this.message = message;
        }

    }
}
