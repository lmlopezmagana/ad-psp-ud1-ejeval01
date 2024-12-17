package com.salesianostriana.dam.resteval;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalErrorController
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PlaceNotFoundException.class)
    public ProblemDetail notFound(PlaceNotFoundException ex) {
        var result = ProblemDetail
                .forStatusAndDetail(
                        HttpStatus.NOT_FOUND, ex.getMessage());
        return result;
    }


}
