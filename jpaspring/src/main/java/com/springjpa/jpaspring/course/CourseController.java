package com.springjpa.jpaspring.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService CourseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourse(@PathVariable String id){
        return CourseService.getListOfCourrses(id);
    }

    // how you can send the specific id to the requestMapping anotation
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id){
        return CourseService.getCourse(id);
    }

    // how to make a method a POST method
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId/courses/{id}")
    public void addTopic(@RequestBody Course course){
        CourseService.addCourse(course);

    }

    // how to make a method a O´PUT method
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Course course, @PathVariable String id){
        CourseService.updateCourse(course, id);
    }

    // how to make a method a delete Method
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@RequestBody Course course, @PathVariable String id){
        CourseService.deleteCourse(id);
    }




}
