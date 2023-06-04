package com.example.socialmeadia.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Post")
public class Post{
	
	
	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	private String body;
	private long likes;
	
	@Lob
	private byte[] image;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
	
	
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public long getLikes() {
		return likes;
	}
	public void setLikes(long likes) {
		this.likes = likes;
	}
	public Post(long id, String title, byte[] image, long likes,String body) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.likes = likes;
		this.body=body;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", image=" + image + ", likes=" + likes + "]";
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
	
	
	

}
