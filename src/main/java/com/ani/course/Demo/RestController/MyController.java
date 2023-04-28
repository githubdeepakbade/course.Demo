package com.ani.course.Demo.RestController;


import com.ani.course.Demo.Entity.Course;
import com.ani.course.Demo.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController
{
    @Autowired
    private CourseService courseService;

    // Post Course
@PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
    return this.courseService.addCourse(course);
}
    // get All Course

@GetMapping("/courses")
    public List<Course>getCourses(){
    return this.courseService.getCourses();
}
    // Get One Course By id

@GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
    return this.courseService.getCourse(Long.parseLong(courseId));
}

    // Update Course By id
@PutMapping("/courses/{courseId}")
    public Course UpDateCourse(@RequestBody Course courseId)
{
    return this.courseService.updateCourse((courseId));
}
    // Delete Course By id

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus>deleteCourse(@PathVariable String courseId)
    {try {
        this.courseService.deleteCourse(Long.parseLong(courseId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
}
