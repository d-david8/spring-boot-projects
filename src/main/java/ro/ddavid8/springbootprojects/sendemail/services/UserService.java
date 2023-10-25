package ro.ddavid8.springbootprojects.sendemail.services;

import ro.ddavid8.springbootprojects.sendemail.models.CreateUserResponse;
import ro.ddavid8.springbootprojects.sendemail.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    CreateUserResponse createUser(User user);

    User getUserById(UUID id);

    List<User> getAllUsers();
}
