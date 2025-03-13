package kz.qbs.course.service;

import kz.qbs.course.model.Course;
import kz.qbs.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
    public Course updateCourse(Long id, Course courseDetails) {
        Course course = getCourseById(id);
        if(course!=null){
            course.setName(courseDetails.getName());
            course.setDescription(courseDetails.getDescription());
            course.setStartDate(courseDetails.getStartDate());
            course.setEndDate(courseDetails.getEndDate());
            return courseRepository.save(course);
        }
        return null;
    }
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
