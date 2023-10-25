package ro.ddavid8.springbootprojects.sendemail.services;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ddavid8.springbootprojects.sendemail.models.CreateUserResponse;
import ro.ddavid8.springbootprojects.sendemail.models.Email;
import ro.ddavid8.springbootprojects.sendemail.models.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> userList = new ArrayList<>();
    @Autowired
    private UserValidationService userValidationService;
    @Autowired
    private UserResponseService userResponseService;
    @Autowired
    private EmailService emailService;

    @Override
    public CreateUserResponse createUser(User user) {
        CreateUserResponse response = new CreateUserResponse();
        Email email = new Email();
        email.setRecipientEmail(user.getEmail());
        if (!emailService.isValidEmailAddress(email)) {
            response.setErrorCode("01");
            response.setMessage("Invalid email address!");
            userResponseService.setResponse(response);
            return response;
        }
        if (!userValidationService.isValidFirstName(user)) {
            response.setErrorCode("02");
            response.setMessage("Invalid first name!");
            userResponseService.setResponse(response);
            return response;
        }
        if (!userValidationService.isValidLastName(user)) {
            response.setErrorCode("03");
            response.setMessage("Invalid last name!");
            userResponseService.setResponse(response);
            return response;
        }
        user.setId(UUID.randomUUID());
        user.setCreatedAt(LocalDateTime.now());
        userList.add(user);
        try {
            emailService.sendEmail(email, user);
        } catch (MessagingException e) {
            response.setErrorCode("04");
            response.setErrorCode("Activation email was not send! Account was created!");
        }
        response.setErrorCode(null);
        response.setMessage("User was created successfully, and the activation mail was send with success");
        userResponseService.setResponse(response);
        return response;
    }

    @Override
    public User getUserById(UUID id) {
        return userList.stream()
                .filter(user -> user.getId().compareTo(id) == 0)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }
}
