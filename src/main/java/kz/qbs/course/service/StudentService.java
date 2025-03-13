package kz.qbs.course.service;

import kz.qbs.course.model.Student;
import kz.qbs.course.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JavaMailSender mailSender;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student registerStudent(Student student, Long courseId){
        student.setRegistrationDate(LocalDate.now());
        Student savedStudent = studentRepository.save(student);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(student.getEmail());
        message.setSubject("Регистрация прошла успешна");
        message.setText("Вы были успешно зарегестрированы на курс. Курс начнется в: "+
                student.getCourse().getStartDate());
        mailSender.send(message);
        return savedStudent;
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public List<Student> searchStudents(String query){
        return studentRepository.findByFirstNameContainingOrLastNameContainingOrEmailContaining(query,query,query);
    }

}
