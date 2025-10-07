package com.dcl.accommodate.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import java.time.LocalDate;



public record UserRegistrationRequest(
        @JsonProperty("first_name")
        @NotNull(message = "first_name should not be null")
        @NotBlank(message = "First name is required.")
        @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters.")
        @Pattern(regexp = "^[A-Z][a-zA-Z\\s'-]{1,49}$",
                message = "First name must start with a capital letter and only contain letters, spaces, hyphens, or apostrophes.")
        String firstName,

        @JsonProperty("last_name")
        @NotNull(message = "last_name should not be null")
        @NotBlank(message = "Last name is required.")
        @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters.")
        @Pattern(regexp = "^[A-Z][a-zA-Z\\s'-]{0,49}$",
                message = "Last name must start with a capital letter and only contain letters, spaces, hyphens, or apostrophes.")
        String lastName,

        @JsonProperty("date_of_birth")
        @NotNull(message = "Date of birth is required.")
       @Past(message = "Date of birth must be in the past.")
        // Note: The 'at least 18 years old' check is more complex and typically done in the service layer or a custom annotation.
        @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
        LocalDate dateOfBirth,


        @JsonProperty("email")
        @NotNull(message = "email should not be null")
        @NotBlank(message = "Email is required.")
        @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message ="Invalid email format.")
        String email,

        @JsonProperty("password")
        @NotBlank(message = "Password is required.")
        @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters.")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,20}$",
                message = "Password must be 8-20 characters and include at least one uppercase letter, one lowercase letter, one digit, and one special character.")
        String password,


        @JsonProperty("phone_number")
        @Pattern(regexp = "^(\\+91\\s)?[6-9]\\d{9}$",
                message = "Invalid Indian mobile number. Must be 10 digits and optionally start with +91 give space and write number like +91 97XXX...")
        @NotBlank(message = "Phone number is required.")
        String phoneNumber
){
}
