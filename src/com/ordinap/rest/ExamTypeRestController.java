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

import com.ordinap.entity.ExamType;
import com.ordinap.service.ExamTypeService;

@RestController
@RequestMapping("rest/examtype")
public class ExamTypeRestController {
	@Autowired
	ExamTypeService examTypeService; 

	   @RequestMapping(value = "/", method = RequestMethod.GET)  
	    public ResponseEntity<List<ExamType>> listAllCourse() {
	        List<ExamType> examTypes = examTypeService.all();
	        if(examTypes.isEmpty()){
	            return new ResponseEntity<List<ExamType>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<ExamType>>(examTypes, HttpStatus.OK);
	    }
	 
	 
	     
	    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<ExamType> getUser(@PathVariable("id") Integer id) {
	    	ExamType examType = examTypeService.get(id);
	        if (examType == null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<ExamType>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<ExamType>(examType, HttpStatus.OK);
	    }

}