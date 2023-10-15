package ro.ddavid8.springbootprojects.entityclassmapping.services;

import ro.ddavid8.springbootprojects.entityclassmapping.models.dtos.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();
}
