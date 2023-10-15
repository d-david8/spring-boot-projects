package ro.ddavid8.springbootprojects.entityclassmapping.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.ddavid8.springbootprojects.entityclassmapping.models.dtos.StudentDTO;
import ro.ddavid8.springbootprojects.entityclassmapping.services.StudentService;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/entityClassMapping")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody @Valid StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.createStudent(studentDTO));
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDTO> updateStudentById(@PathVariable @Valid Long id, @RequestBody StudentDTO studentDTO) {
        Optional<StudentDTO> studentDTOResponse = Optional.ofNullable(studentService.updateStudentById(id, studentDTO));
        return studentDTOResponse
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

}
