package com.dcl.accommodate.exception.handler;

import com.dcl.accommodate.dto.wrapper.ApiAck;
import com.dcl.accommodate.exception.customException.UserAlreadyExistsByEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler <T>{

    @ExceptionHandler(UserAlreadyExistsByEmailException.class)
    public ResponseEntity<ApiAck> handleEmailAreadyExistsException(UserAlreadyExistsByEmailException ex){
             return  ResponseEntity.status(HttpStatus.CONFLICT)
                     .body(new ApiAck(false, ex.getExceptionMessage()));

    }
}
