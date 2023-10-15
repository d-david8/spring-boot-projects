package ro.ddavid8.springbootprojects.entityclassmapping.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class StudentDTO implements Serializable {
    private Long id;
    @NotEmpty(message = "First name cannot be empty!")
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty!")
    private String lastName;
    @NotEmpty(message = "Email cannot be empty!")
    private String email;
    private LocalDate birthDate;
}
