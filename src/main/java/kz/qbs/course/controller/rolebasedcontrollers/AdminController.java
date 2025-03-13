package kz.qbs.course.controller.rolebasedcontrollers;

import kz.qbs.course.model.Course;
import kz.qbs.course.model.Student;
import kz.qbs.course.service.CourseService;
import kz.qbs.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    @Autowired
    private StudentService studentService;


    @PostMapping("/testAdmin")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from Admin");
    }
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/students/search")
    public List<Student> searchStudent(@RequestParam String query) {
        return studentService.searchStudents(query);
    }
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @Autowired
    private CourseService courseService;

    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course courseDetails){
        return courseService.updateCourse(id, courseDetails);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }




}
