package org.HappyRestApi.springREST.exeptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GeneralExceptionsHandler extends ResponseEntityExceptionHandler  {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleEnyException(Exception ex, WebRequest request){

        String errorMessageDescription = ex.getLocalizedMessage();

        if (errorMessageDescription == null) {errorMessageDescription = ex.toString();}

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>(
                errorMessage,
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST
        );
    }
}
