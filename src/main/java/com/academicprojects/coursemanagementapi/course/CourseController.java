package com.academicprojects.coursemanagementapi.course;

import com.academicprojects.coursemanagementapi.topic.Topic;
import com.academicprojects.coursemanagementapi.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private TopicRepository topicRepository;


    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }


    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }


    @RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        if(topicRepository.existsById(topicId)) course.setTopic(topicRepository.findById(topicId).get());
        else course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }



    @RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course,@PathVariable String topicId) {
        if(topicRepository.existsById(topicId)) course.setTopic(topicRepository.findById(topicId).get());
        else course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }



    @RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
