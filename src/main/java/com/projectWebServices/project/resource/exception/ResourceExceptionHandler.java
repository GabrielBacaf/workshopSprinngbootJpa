package com.projectWebServices.project.resource.exception;

import com.projectWebServices.project.services.exception.DatabaseException;
import com.projectWebServices.project.services.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice // essa annotation significa que essa classe faz a intersepção
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error1 = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return  ResponseEntity.status(status).body(error1);


    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error1 = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return  ResponseEntity.status(status).body(error1);


    }

}
