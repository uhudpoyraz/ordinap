package com.ordinap.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordinap.entity.Course;
import com.ordinap.service.CourseService;

@RestController
@RequestMapping("rest/course")
public class CourseRestController {
	@Autowired
	CourseService courseService;

	   @RequestMapping(value = "/", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)  
	    public ResponseEntity<List<Course>> listAllCourse() {
	        List<Course> courses = courseService.all();
	        if(courses.isEmpty()){
	            return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
	    }
	 
	 
	     
	    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Course> getUser(@PathVariable("id") Integer id) {
 	        Course course = courseService.get(id);
	        if (course == null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Course>(course, HttpStatus.OK);
	    }

}