package ro.ddavid8.springbootprojects.sendemail.services;

import jakarta.mail.MessagingException;
import ro.ddavid8.springbootprojects.sendemail.models.Email;
import ro.ddavid8.springbootprojects.sendemail.models.User;

public interface EmailService {
    void sendEmail(Email email, User user) throws MessagingException;

    boolean isValidEmailAddress(Email email);

}