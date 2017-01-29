package com.ordinap.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordinap.entity.User;
import com.ordinap.service.UserService;

@RestController
@RequestMapping("rest/user/")
public class UserRestController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="register",method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> register(@RequestParam("name") String name,
			@RequestParam("surname") String surname,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("type") int type){
		
		User user=new User();
		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setPassword(password);
		user.setType(type);
		userService.add(user);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
