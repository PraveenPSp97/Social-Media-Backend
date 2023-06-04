package com.example.socialmeadia.controllers;

import java.io.IOException;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.socialmeadia.model.User;
import com.example.socialmeadia.model.UserSo;
import com.example.socialmeadia.service.UserService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public String addUser(UserSo userSo) throws IOException {
		byte [] image=null;	
		if(userSo.getProfilePhoto()!=null) {
			image =userSo.getProfilePhoto().getBytes();
		}
		User user =new User();
		user.setName(userSo.getName());   
		user.setProfilePhoto(image);
		return userService.add(user);
	}
	
	@GetMapping("/getUser")
	private User getUser(@RequestParam("name") String username) {
		User user= userService.getUserByName(username);
		return user;
		
	}
	

	@PostMapping("/addUsers")
	public String addUsers(@RequestParam("profilePhoto") MultipartFile photo,@RequestParam("name") String name) throws IOException {
		
		byte [] image=null;
		if(photo!=null) {
			image =photo.getBytes();
		}
		User user =new User();
		user.setName(name);   
		user.setProfilePhoto(image);
		return userService.add(user);
	}
	
	@PutMapping("/addFollower/{id}")
	public User addFollower(@RequestParam Long followerId, @PathVariable("id") Long userId) {
		
		return userService.addUserService(followerId,userId);
		
	}
	
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable("id") Long userId) {
		
		return userService.getUserById(userId);
		
	}
	
}
