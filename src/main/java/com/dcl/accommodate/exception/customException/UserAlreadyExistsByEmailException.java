package com.dcl.accommodate.exception.customException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAlreadyExistsByEmailException extends RuntimeException {
    private String exceptionMessage;
}
