package net.userregistration.user.exception;

import net.userregistration.user.payload.ApiResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponce> resourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponce apiResponce = new ApiResponce(message, false);
        return new ResponseEntity<>(apiResponce, HttpStatus.NOT_FOUND);
    }
}
