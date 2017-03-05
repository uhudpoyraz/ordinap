package com.ordinap.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordinap.api.route.V1;
import com.ordinap.entity.Course;
import com.ordinap.entity.Unite;
import com.ordinap.service.CourseService;

@RestController
@RequestMapping(V1.apiPrefix)
public class CourseRestController {
	@Autowired
	CourseService courseService;

	@RequestMapping(value = V1.courses, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Course>> listCourse() {
		List<Course> courses = courseService.all();
		if (courses.isEmpty()) {
			return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
	}

	@RequestMapping(value = V1.GET_COURSE_DETAILS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> getCourse(@PathVariable("id") Integer id) {
		Course course = courseService.get(id);
		if (course == null) {
 			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	@RequestMapping(value = V1.GET_UNITES_BY_COURSE, method = RequestMethod.GET)
	public ResponseEntity<List<Unite>> listAllCourse(@PathVariable("courseId") Integer courseId) {
		List<Unite> unites = courseService.get(courseId).getUnites();
		if (unites.isEmpty()) {
			return new ResponseEntity<List<Unite>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Unite>>(unites, HttpStatus.OK);
	}

}