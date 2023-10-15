package ro.ddavid8.springbootprojects.volunteerregistration.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.ddavid8.springbootprojects.volunteerregistration.models.Volunteer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Value("${volunteer.path}")
    private String path;

    @Override
    public String addVolunteer(Volunteer volunteer) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
            volunteer.setId(UUID.randomUUID());
            volunteer.setSubmittedAt(LocalDateTime.now());
            out.write(volunteerToString(volunteer));
            out.append("\n");
            out.close();
        } catch (IOException e) {
            return "An error occurred while saving volunteer information. Error: " + e.getMessage();
        }
        return "Volunteer information has been successfully saved.";
    }

    private String volunteerToString(Volunteer volunteer) {
        return "ID: " + volunteer.getId() + "\n" +
                "Name: " + volunteer.getName() + "\n" +
                "Email: " + volunteer.getName() + "\n" +
                "Phone number: " + volunteer.getPhone() + "\n" +
                "Event: " + volunteer.getEvent() + "\n" +
                "Submission date and time: " + volunteer.getSubmittedAt().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) + "\n";
    }
}
