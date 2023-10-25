package ro.ddavid8.springbootprojects.sendemail.services;

import ro.ddavid8.springbootprojects.sendemail.models.User;

public interface UserValidationService {
    boolean isValidFirstName(User user);

    boolean isValidLastName(User user);

}
