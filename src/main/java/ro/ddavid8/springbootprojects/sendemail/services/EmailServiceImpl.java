package ro.ddavid8.springbootprojects.sendemail.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ro.ddavid8.springbootprojects.sendemail.models.Email;
import ro.ddavid8.springbootprojects.sendemail.models.User;

import java.util.regex.Pattern;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${application.sender.email}")
    private String senderEmailAddress;

    @Value("${application.name}")
    private String applicationName;
    @Value("${application.support.email}")
    private String supportEmail;
    @Value("${application.sender.name}")
    private String sederName;

    public void sendEmail(Email email, User user) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setSubject("Welcome to " + applicationName + "! Your account has been created");
        helper.setFrom(senderEmailAddress);
        helper.setTo(email.getRecipientEmail());
        String bodyMessage = "<p><b>Hello " + user.getFirstName() + ",</b></p>"
                + "<p> We're excited to let you know that your account for " + applicationName.toUpperCase() + " has been successfully created! </p>"
                + "<p> You can check your account <a href=\"http://localhost:8080/api/sendEmail/users/" + user.getId() + "\" target=\"_blank\">here</a>.</p>"
                + "<p> Our support team is here to assist you. You can reach out to us at <a href=\"mailto:" + supportEmail + "\">" + supportEmail + "</a> or visit our Help Center.</p>"
                + "<p> Thank you for choosing " + applicationName + ". We're thrilled to have you on board and can't wait to see what you'll achieve!</p>"
                + "<p> Warm regards,<br> " + sederName + "</p>";
        helper.setText(bodyMessage, true);

        javaMailSender.send(message);
    }

    public boolean isValidEmailAddress(Email email) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(email.getRecipientEmail())
                .matches();
    }
}