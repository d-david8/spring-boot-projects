package ro.ddavid8.springbootprojects.sendemail.models;

import lombok.Data;

@Data
public class Email {
    private String recipientEmail;
    private String subject;
    private String content;
}
