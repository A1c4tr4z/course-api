package kz.qbs.course.repository;

import kz.qbs.course.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByCourseId(Long courseId);
    List<Student> findByFirstNameContainingOrLastNameContainingOrEmailContaining(String firstName, String lastName, String email);

}
