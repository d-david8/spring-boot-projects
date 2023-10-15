package ro.ddavid8.springbootprojects.volunteerregistration.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Volunteer {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String event;
    private LocalDateTime submittedAt;
}
