package ro.ddavid8.springbootprojects.entityclassmapping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ddavid8.springbootprojects.entityclassmapping.models.entities.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String firstName, String lastName);

    Optional<Student> findStudentByEmail(String email);
}
