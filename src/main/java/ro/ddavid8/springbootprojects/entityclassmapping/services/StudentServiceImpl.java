package ro.ddavid8.springbootprojects.entityclassmapping.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ro.ddavid8.springbootprojects.entityclassmapping.models.dtos.StudentDTO;
import ro.ddavid8.springbootprojects.entityclassmapping.models.entities.Student;
import ro.ddavid8.springbootprojects.entityclassmapping.repositories.StudentRepository;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ObjectMapper objectMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ObjectMapper objectMapper) {
        this.studentRepository = studentRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student studentEntity = objectMapper.convertValue(studentDTO, Student.class);

        Student studentResponseEntity = studentRepository.save(studentEntity);
        log.info("Student with id: {} was created", studentResponseEntity.getId());

        return objectMapper.convertValue(studentResponseEntity, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> studentsEntityList = studentRepository.findAll(Sort.by("id"));
        return studentsEntityList.stream()
                .map(student -> objectMapper.convertValue(student, StudentDTO.class)).toList();
    }
}