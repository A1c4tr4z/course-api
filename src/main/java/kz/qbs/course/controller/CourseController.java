package kz.qbs.course.controller;

import kz.qbs.course.model.Course;
import kz.qbs.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Course registerCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

//    @PutMapping("/{id}")
//    public Course updateCourse(@PathVariable Long id, @RequestBody Course courseDetails){
//        return courseService.updateCourse(id, courseDetails);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCourse(@PathVariable Long id) {
//        courseService.deleteCourse(id);
//    }

}
