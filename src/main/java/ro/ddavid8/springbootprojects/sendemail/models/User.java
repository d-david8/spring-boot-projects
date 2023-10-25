package ro.ddavid8.springbootprojects.sendemail.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class User {
    UUID id;
    String firstName;
    String lastName;
    String email;
    LocalDateTime createdAt;
}
