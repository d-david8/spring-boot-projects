package ro.ddavid8.springbootprojects.entityclassmapping.services;

import ro.ddavid8.springbootprojects.entityclassmapping.models.dtos.StudentDTO;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
}
