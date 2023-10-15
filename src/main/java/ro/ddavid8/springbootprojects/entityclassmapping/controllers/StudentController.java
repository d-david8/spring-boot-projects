package ro.ddavid8.springbootprojects.entityclassmapping.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ddavid8.springbootprojects.entityclassmapping.models.dtos.StudentDTO;
import ro.ddavid8.springbootprojects.entityclassmapping.services.StudentService;

@Validated
@RestController
@RequestMapping("/api/entityClassMapping")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("students")
    public ResponseEntity<StudentDTO> createUser(@RequestBody @Valid StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.createStudent(studentDTO));
    }
}
