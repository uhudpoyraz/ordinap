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

import com.ordinap.entity.Unite;
import com.ordinap.service.UniteService;

@RestController
@RequestMapping("rest/unite")
public class UniteRestController {
	@Autowired
	UniteService uniteService;
	
	
	   @RequestMapping(value = "/", method = RequestMethod.GET)  
	    public ResponseEntity<List<Unite>> list() {
	        List<Unite> unites = uniteService.all();
	        if(unites.isEmpty()){
	            return new ResponseEntity<List<Unite>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Unite>>(unites, HttpStatus.OK);
	    }
	

	   @RequestMapping(value = "/getByCourseId/{courseId}", method = RequestMethod.GET)  
	    public ResponseEntity<List<Unite>> listAllCourse(@PathVariable("courseId") Integer courseId) {
	        List<Unite> unites = uniteService.all(courseId);
	        if(unites.isEmpty()){
	            return new ResponseEntity<List<Unite>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Unite>>(unites, HttpStatus.OK);
	    }
	   
	    @RequestMapping(value = "/getUniteFindById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Unite> getUser(@PathVariable("id") Integer id) {
	    	Unite unite = uniteService.get(id);
	        if (unite == null) {
 	            return new ResponseEntity<Unite>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Unite>(unite, HttpStatus.OK);
	    }

}