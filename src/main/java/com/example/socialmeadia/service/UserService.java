package com.example.socialmeadia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.socialmeadia.model.User;
import com.example.socialmeadia.repositories.UserRepo;

@Service
public class UserService {
	
	  @Autowired
	  UserRepo userRepo;
	  
	public User getUser(Long id){
		User user=userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id"));
		
		return user;
	  }
	
	public void addUser(User user) {
		userRepo.save(user);
	}

	public  String add(User user) {
		
		userRepo.save(user);
		return "sucess";
	}

	public User getUserByName(String username) {
		
		return userRepo.getByName(username);
	}

	public User addUserService(Long followerId, Long userId) {
		User follower=getUser(followerId);
		User user=getUser(userId);
		user.addFollowers(follower);
		
		return userRepo.save(user);
	}

	public User getUserById(Long userId) {
		return getUser(userId);
	}
	
	
}
