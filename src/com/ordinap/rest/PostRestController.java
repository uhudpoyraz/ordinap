package com.ordinap.rest;	

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordinap.entity.Comment;
import com.ordinap.entity.Post;
import com.ordinap.entity.Unite;
import com.ordinap.entity.User;
import com.ordinap.service.CommentService;
import com.ordinap.service.PostService;
import com.ordinap.service.UniteService;
import com.ordinap.service.UserService;

@RestController
@RequestMapping(value="rest/post")
public class PostRestController {

		@Autowired
		PostService postService;
		@Autowired
		UserService userService;
		@Autowired
		UniteService uniteService;
		@Autowired
		CommentService commentService;
		
	   @RequestMapping(value = "getFindPostByExamTypeId/{examTypeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)  
	    public ResponseEntity<List<Post>> listAllPostByExamType(@PathVariable("examTypeId") Integer examTypeId) {
		   
		   
	        List<Post> posts = postService.getFindByExamTypeId(examTypeId,0,0);
	        if(posts.isEmpty()){
	            return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	    }
	 
	   @RequestMapping(value = "getPostFindById/{postId}", method = RequestMethod.GET)  
	    public ResponseEntity<Post> getPostById(@PathVariable("postId") Integer postId) {
		   
		   
	        Post post = postService.get(postId);
	        if(post==null){
	            return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<Post>(post, HttpStatus.OK);
	    }
	   
	   @RequestMapping(value = "add/", method = RequestMethod.POST)  
	    public ResponseEntity<Post> add(
	    		@RequestParam("userId") Integer userId,
	    		@RequestParam("uniteId") Integer uniteId,
	    		@RequestParam("postDescription") String postDescription,
	    		@RequestParam("postImage") String postImage
	    		) {
		   
		   
			  /*File Upload Eklencek*/

		   
		   
		   		System.out.println(userId);
		   		User user=userService.get(userId);
		   		Unite unite=uniteService.get(uniteId);
		   		Post post=new Post();
		   		post.setUser(user);
		   		post.setUnite(unite);
		   		post.setPostDescription(postDescription);
		   		post.setPostImagePath(postImage);
		   		
		   		
		   		postService.add(user, unite, post);
		   		
	   
	        return new ResponseEntity<Post>(post, HttpStatus.OK);
	    }
	   
	   @RequestMapping(value = "comment/add/", method = RequestMethod.POST)  
	    	public ResponseEntity<Comment> addComment(
	    		@RequestParam("userId") Integer userId,
	    		@RequestParam("postId") Integer postId,
	    		@RequestParam("commentDescription") String commentDescription,
	    		@RequestParam("commentImage") String commentImage
	    		) {
		   
		   
			  /*File Upload Eklencek*/
		   
		   		System.out.println(userId);
		   		User user=userService.get(userId);
		   		Post post=postService.get(postId);
		   		Comment comment=new Comment();
		   		comment.setPost(post);
		   		comment.setUser(user);
		   		comment.setCommentDescription(commentDescription);
		   		comment.setCommentImagePath(commentImage);		   		
		   		commentService.add(user, post, comment);
		   		
	   
	        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	    }
	   
	   
}
