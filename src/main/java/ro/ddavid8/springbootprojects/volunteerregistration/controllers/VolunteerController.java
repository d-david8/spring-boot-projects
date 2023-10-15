package ro.ddavid8.springbootprojects.volunteerregistration.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ddavid8.springbootprojects.volunteerregistration.models.Volunteer;
import ro.ddavid8.springbootprojects.volunteerregistration.services.VolunteerService;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {
    private final VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    /**
     * Adds a new volunteer in the volunteers.txt file.
     *
     * @param volunteer The Volunteer object containing the volunteer's information.
     * @return The ResponseEntity containing a success message if the volunteer is added successfully.
     */
    @PostMapping()
    public ResponseEntity<String> addVolunteer(@RequestBody Volunteer volunteer) {
        return ResponseEntity.ok(volunteerService.addVolunteer(volunteer));
    }
}
