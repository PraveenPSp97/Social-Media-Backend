package com.example.socialmeadia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialmeadia.model.Post;


public interface PostRepo extends JpaRepository<Post, Long> {

	List<Post> findBytitle(String title);

}
