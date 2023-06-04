package com.example.socialmeadia.controllers;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.example.socialmeadia.model.Post;
import com.example.socialmeadia.model.Postrequest;
import com.example.socialmeadia.model.User;
import com.example.socialmeadia.repositories.PostRepo;
import com.example.socialmeadia.service.PostService;
import com.example.socialmeadia.service.UserService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/posts")
	public List<Post> getPosts() {
		return postService.getposts();
	}
	
	
	
	@PostMapping("/upload")
	public String fileUpload(@RequestParam("file") MultipartFile file) throws Exception {
		postService.uploadfile(file);
		return "sucess";		
	}
	
	
	
	@PutMapping("/postput/{id}")
	public Post updatePost(@PathVariable long id, @RequestBody Post updatedPost) {
		
		Post post=postService.getPost(id);
		post.setLikes(updatedPost.getLikes());		
		postService.addpost(post);
		System.out.println(post.toString());
		return updatedPost;
	}
	
	@PutMapping("/posts/likePost/{id}")
	public long likePost(@PathVariable long id) {
	
		Post post=postService.getPost(id);
		long likes=post.getLikes();
		post.setLikes(++likes);
		postService.addpost(post);
		return post.getLikes(); 	
	}
	
	@DeleteMapping("/posts/deletePost/{id}")
	public long deletePost(@PathVariable long id) {
		System.out.println(postService.deletePost(id));
		return id;
		
	}
	
	@GetMapping("/getByTitle")
	public List<Post> getByTitile(@RequestParam String title){	
		System.out.println("inside tittle"+title);		
		return postService.getByTitle(title);
	}
	
	@GetMapping("/getOrderByTitle")
	public List<Post> getOrderByTitile(){
		return postService.getOrderByTitle();
	}

	
	@PostMapping("/posts")
	public ResponseEntity<Post> postImage(Postrequest postreq) throws IOException {
		Post post=new Post();
		System.out.println("inside file submit"+postreq.getUserId());
		post.setBody(postreq.getBody());
		post.setTitle(postreq.getTitle());
		
		User user=userService.getUser(postreq.getUserId());
		System.out.println();
		byte [] image=null;
		if(postreq.getImage()!=null) {
			image =postreq.getImage().getBytes();
		}
		post.setImage(image);
		post.setUser(user);
		
		Post result=postService.savePost(post);
		System.out.println("result"+result.toString());
	    
		
		return new ResponseEntity<>(result, HttpStatus.CREATED);
		

	}
	
	
	
}
