package com.ordinap.api.v1;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.monitorjbl.json.JsonResult;
import com.monitorjbl.json.JsonView;
import com.monitorjbl.json.Match;

import static com.monitorjbl.json.Match.match;
 import com.ordinap.api.route.V1;
import com.ordinap.entity.User;
import com.ordinap.service.UserService;

@RestController
@RequestMapping(V1.apiPrefix)
public class LoginRestController {
	
	private JsonResult json = JsonResult.instance();
	
	@Autowired
	UserService userService;

	@RequestMapping(value=V1.register,method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> register(
			@RequestParam("name") String name,
			@RequestParam("surname") String surname,
			@RequestParam("email") String email,
			@RequestParam("password") String password){
		
		User user=new User();
		user.setName(name);
		user.setSurname(surname);
		user.setEmail(email);
		user.setPassword(password);
		user.setType(0);
		userService.add(user);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value=V1.login,method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> register(
			@RequestParam("email") String email,
			@RequestParam("password") String password){
		User user=null;
		try{
			user=userService.getByEmailAndPassword(email, password);
			 /*user=json.use(JsonView.with(user)
			        .onClass(User.class, Match.match()
			            .exclude("createdAt")
			            .exclude("updatedAt")
			            .exclude("password").exclude("userProfile").exclude("userPosts")
			            ))
			         .returnValue(); */
  			return new ResponseEntity<User>(user, HttpStatus.OK);
			
		}catch (Exception e) {
 
			System.out.println("Hata:"+e.getMessage());
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);

		}
			
	
		
		
	}
	
}
