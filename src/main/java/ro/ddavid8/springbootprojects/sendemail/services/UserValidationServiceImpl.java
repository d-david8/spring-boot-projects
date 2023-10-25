package ro.ddavid8.springbootprojects.sendemail.services;

import org.springframework.stereotype.Service;
import ro.ddavid8.springbootprojects.sendemail.models.User;

@Service
public class UserValidationServiceImpl implements UserValidationService {
    private final int MIN_LENGTH = 2;

    @Override
    public boolean isValidFirstName(User user) {
        return user.getFirstName().length() > MIN_LENGTH;
    }

    @Override
    public boolean isValidLastName(User user) {
        return user.getLastName().length() > MIN_LENGTH;
    }
}
