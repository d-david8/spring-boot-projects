package ro.ddavid8.springbootprojects.entityclassmapping.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ro.ddavid8.springbootprojects.entityclassmapping.models.dtos.StudentDTO;
import ro.ddavid8.springbootprojects.entityclassmapping.models.entities.Student;
import ro.ddavid8.springbootprojects.entityclassmapping.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

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
        log.info("The list of students was retrieved, count {}", studentsEntityList.size());

        return studentsEntityList.stream()
                .map(studentEntity -> objectMapper.convertValue(studentEntity, StudentDTO.class))
                .toList();
    }

    @Override
    public StudentDTO updateStudentById(Long id, StudentDTO studentDTO) {
        studentDTO.setId(id);
        Student studentEntity = objectMapper.convertValue(studentDTO, Student.class);

        if (studentRepository.findById(studentDTO.getId()).isPresent()) {
            Student studentResponseEntity = studentRepository.save(studentEntity);
            log.info("Student with id: {} was updated", studentResponseEntity.getId());
            return objectMapper.convertValue(studentResponseEntity, StudentDTO.class);
        }
        log.info("Student with id: {} was not found", id);
        return null;
    }

    @Override
    public StudentDTO deleteStudentById(Long id) {
        Optional<Student> studentEntity = studentRepository.findById(id);
        if (studentEntity.isPresent()) {
            StudentDTO studentDTO = objectMapper.convertValue(studentEntity, StudentDTO.class);
            studentRepository.deleteById(id);
            log.info("Student with id: {} was deleted", id);
            return studentDTO;
        }
        log.info("Student with id: {} was not found", id);
        return null;
    }

    @Override
    public List<StudentDTO> getStudentIgnoreCaseByFirstNameOrLastNameIgnoreCase(String firstName, String lastName) {
        List<StudentDTO> studentDTOList;
        studentDTOList = studentRepository.findByFirstNameIgnoreCaseOrLastNameIgnoreCase(firstName, lastName).stream()
                .map(studentEntity -> objectMapper.convertValue(studentEntity, StudentDTO.class))
                .toList();
        log.info("The list of students with first name = {} or last name = {}, count {} was returned", firstName, lastName, studentDTOList.size());

        return studentDTOList;
    }

    @Override
    public StudentDTO getUserByEmail(String email) {
        Optional<Student> studentEntity = studentRepository.findStudentByEmail(email);
        if (studentEntity.isPresent())
            return objectMapper.convertValue(studentEntity, StudentDTO.class);
        else
            return null;
    }


}
