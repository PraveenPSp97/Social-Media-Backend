package com.example.socialmeadia.model;

import org.springframework.web.multipart.MultipartFile;

public class Postrequest {

	private String title;
	private String body;
	private MultipartFile image;
	private long userId;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	
}
