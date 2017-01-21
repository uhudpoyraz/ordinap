package com.ordinap.rest;




import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ordinap.entity.Course;
import com.ordinap.service.CourseService;

/**
 * 
 * @author uhudpoyraz 
 * 200 OK 
 * 201 Created 
 * 204 No Content
 */

@Path("bina")
@Component

public class CourseRest {
	@Autowired
	CourseService courseService;

	@GET 
	@Path("add")
	@Produces("application/json")
	public Response add(@QueryParam("name") String name) {

		Course course = new Course();
		course.setName(name);
		courseService.add(course);

		return Response.status(201).entity(course).build();
	}

	 
}