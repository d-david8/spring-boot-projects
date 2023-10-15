package ro.ddavid8.springbootprojects.entityclassmapping.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    private String email;
    @NotNull(message = "Birth date cannot be empty")
    private LocalDate birthDate;
}
