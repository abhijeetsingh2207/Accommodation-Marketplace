package com.dcl.accommodate.model;

import com.dcl.accommodate.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;


@Entity
@Getter
@Setter
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   @Column(name = "user_id")
    private UUID userId;

   // first name validation
    @Column(name = "first_name", nullable = false)
    private String firstName;

    // last name validation
    @Column(name = "last_name", nullable = false)
    private String lastName;

    // date of birth validation
    @Column(name = "date_of_birth")
   private LocalDate dateOfBirth;

   // user role validation
    @Column(name = "user_role", nullable = false)
    @Enumerated(EnumType.STRING)                // Assuming Role is an Enum: public enum UserRoles { GUEST, HOST }
    @NotNull(message = "Role is required.")     // role - Required. Must be one of the enum values (handled by validation logic below).
    private UserRole roles;


    // user email validation
    @Column(name = "email", nullable = false, unique = true)
   private String email;

    // user password validation
    // password - Required. Length 8-20. Pattern: includes U/L case, digit, special character.
    @Column(name = "password", nullable = false)
      private String password;


    // phone Numer validation
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "created_at" ,updatable = false, nullable = false )
    @CreatedDate
    private Instant createdAt;


    @Column(name = "last_update_at")
    @LastModifiedDate
    private Instant lastUpdateAt;
}
