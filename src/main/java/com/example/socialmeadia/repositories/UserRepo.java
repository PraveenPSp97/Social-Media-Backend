package com.example.socialmeadia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialmeadia.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

	User getByName(String name);

}
