   package com.example.socialmeadia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.socialmeadia.repositories.UserRepo;
import com.example.socialmeadia.service.UserService;

@SpringBootApplication
public class SocialmeadiaApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(SocialmeadiaApplication.class, args);
		
		System.out.println("hello");
	}

}
   