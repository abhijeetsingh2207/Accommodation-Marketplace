package com.dcl.accommodate.dto.response;

import com.dcl.accommodate.enums.UserRoles;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class UserResponse {
 private String firstName;
 private String lastName;
 private LocalDate dateOfBirth;
 private String email;
 private UserRoles role;
 private String avatar;
 private String createdAt;
 private String lastUpdatedAt;

}
