package com.ordinap.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordinap.dao.PostDao;
import com.ordinap.entity.Post;
import com.ordinap.service.PostService;

@RestController
@RequestMapping(value="rest/post")
public class PostRestController {

		@Autowired
		PostService postService;
	
	   @RequestMapping(value = "getFindByExamType/{examTypeId}", method = RequestMethod.GET)  
	    public ResponseEntity<List<Post>> listAllPostByExamType(@PathVariable("examTypeId") Integer examTypeId) {
		   
		   
	        List<Post> posts = postService.getFindByExamTypeId(examTypeId,0,0);
	        if(posts.isEmpty()){
	            return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	    }
	 
	   @RequestMapping(value = "getById/{postId}", method = RequestMethod.GET)  
	    public ResponseEntity<Post> getPostById(@PathVariable("postId") Integer postId) {
		   
		   
	        Post post = postService.get(postId);
	        if(post==null){
	            return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<Post>(post, HttpStatus.OK);
	    }
	
}
