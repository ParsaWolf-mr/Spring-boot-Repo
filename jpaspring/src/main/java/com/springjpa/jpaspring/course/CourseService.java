package com.springjpa.jpaspring.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

/*
    private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
            new Topic("spring", "Spring Framework", "spring Framwork description"),
        new Topic("java", "java Framework", "Java Framwork description"),
        new Topic("tomcat", "Tomcat Framework", "Tomcat Framwork description"),
        new Topic("javaScrit", "JavaScript Framework", "spring Framwork description")));
*/

    public List<Course> getListOfCourrses(String id){
        //return topics;
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(String id){
        // search for the first match topic in topics list
        return courseRepository.findById(id);
       }


    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course, String id) {
/*        for (Topic item: topics){
            if (item.getId() == id) {
                topics.set(topics.indexOf(item), topic);
                return;
            }
        }*/
        courseRepository.save(course);
    }

    public void deleteCourse (String id){
//        topics.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }

}
