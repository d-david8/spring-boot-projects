package ro.ddavid8.springbootprojects.entityclassmapping.services;

import ro.ddavid8.springbootprojects.entityclassmapping.models.dtos.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();

    StudentDTO updateStudentById(Long id, StudentDTO studentDTO);

    StudentDTO deleteStudentById(Long id);

    List<StudentDTO> getAllStudentsByFirstNameOrLastName(String firstName, String lastName);

    StudentDTO getUserByEmail(String email);
}
