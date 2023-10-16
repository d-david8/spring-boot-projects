package ro.ddavid8.springbootprojects.studentsmanagement.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.ddavid8.springbootprojects.studentsmanagement.models.dtos.StudentDTO;
import ro.ddavid8.springbootprojects.studentsmanagement.services.StudentService;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/studentsManagement")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Method for creating a new student.
     *
     * @param studentDTO The StudentDTO object to be created.
     * @return The HTTP response containing the created StudentDTO or error code 400.
     */
    @PostMapping("/students")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody @Valid StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.createStudent(studentDTO));
    }

    /**
     * Method for updating a student by ID.
     *
     * @param id         The ID of the student to be updated.
     * @param studentDTO The StudentDTO object containing the updated information.
     * @return The HTTP response containing the updated StudentDTO or error code 400/404.
     */
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDTO> updateStudentById(
            @PathVariable @Valid Long id,
            @RequestBody @Valid StudentDTO studentDTO) {
        Optional<StudentDTO> studentDTOResponse = Optional.ofNullable(studentService.updateStudentById(id, studentDTO));
        return studentDTOResponse
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Method for deleting a student by ID.
     *
     * @param id The ID of the student to be deleted.
     * @return The HTTP response containing the deleted StudentDTO or error code 404.
     */
    @DeleteMapping("/students/{id}")
    public ResponseEntity<StudentDTO> deleteStudentById(@PathVariable @Valid Long id) {
        Optional<StudentDTO> studentDTOResponse = Optional.ofNullable(studentService.deleteStudentById(id));
        return studentDTOResponse
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Method for finding students by first name or/and last name.
     *
     * @param firstName The first name of the student.
     * @param lastName  The last name of the student.
     * @return The HTTP response containing the list of found StudentDTOs.
     */
    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> findStudentByFirstNameOrLastName(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        if (firstName == null && lastName == null)
            return ResponseEntity.ok(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudentsByFirstNameOrLastName(firstName, lastName));
    }

    /**
     * Method for finding a student by email address.
     *
     * @param email The email address of the searched student.
     * @return The HTTP response containing the found StudentDTO or error code 404.
     */
    @GetMapping(value = "/students/getStudentByEmail", params = "email")
    public ResponseEntity<StudentDTO> findStudentByEmail(@RequestParam @Valid String email) {
        Optional<StudentDTO> studentDTO = Optional.ofNullable(studentService.getUserByEmail(email));
        if (studentDTO.isPresent()) {
            return ResponseEntity.ok(studentService.getUserByEmail(email));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
