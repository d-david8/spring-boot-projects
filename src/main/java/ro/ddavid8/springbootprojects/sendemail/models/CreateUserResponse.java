package ro.ddavid8.springbootprojects.sendemail.models;

import lombok.Data;

@Data
public class CreateUserResponse {
    private String errorCode;
    private String message;
}
