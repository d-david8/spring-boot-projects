package ro.ddavid8.springbootprojects.sendemail.services;

import org.springframework.stereotype.Service;
import ro.ddavid8.springbootprojects.sendemail.models.CreateUserResponse;

@Service
public class UserResponseServiceImpl implements UserResponseService {
    @Override
    public CreateUserResponse setResponse(CreateUserResponse createUserResponse) {
        return createUserResponse;
    }
}
