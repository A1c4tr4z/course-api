package kz.qbs.course.controller;

import kz.qbs.course.model.Student;
import kz.qbs.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student, @RequestParam Long courseId) {
        return studentService.registerStudent(student, courseId);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/search")
    public List<Student> searchStudent(@RequestParam String query) {
        return studentService.searchStudents(query);
    }

}
