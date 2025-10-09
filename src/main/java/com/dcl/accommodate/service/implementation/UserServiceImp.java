package com.dcl.accommodate.service.implementation;
import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.enums.UserRole;
import com.dcl.accommodate.exception.customException.UserAlreadyExistsByEmailException;
import com.dcl.accommodate.model.User;
import com.dcl.accommodate.repository.UserRepository;
import com.dcl.accommodate.service.contracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private UserRepository userRepository;


    @Override
    public void registerUser(UserRegistrationRequest userRegistrationRequest) {
            if(userRepository.existsByEmail(userRegistrationRequest.email())){
                throw new UserAlreadyExistsByEmailException("User Account Already exists by given email");
            }

            var user = toUser(userRegistrationRequest);
           userRepository.save(user);

    }

    private static User toUser(UserRegistrationRequest userRegistrationRequest) {
        return User.builder()
                .firstName(userRegistrationRequest.firstName())
                .lastName(userRegistrationRequest.lastName())
                .email(userRegistrationRequest.email())
                .password((userRegistrationRequest.password()))
                .phoneNumber(userRegistrationRequest.phoneNumber())
                .dateOfBirth(userRegistrationRequest.dateOfBirth())
                .roles(UserRole.GUEST)    // all the user are GUEST by default
                .build();
    }
}
