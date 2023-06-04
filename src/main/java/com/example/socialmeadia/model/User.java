package com.example.socialmeadia.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@Lob
	private byte[] profilePhoto;
	
	
	@ManyToMany
	@JoinTable(
	    name = "user_followers",
	    joinColumns = @JoinColumn(name = "user_id"),
	    inverseJoinColumns = @JoinColumn(name = "follower_id")
	)
	private List<User> followers = new ArrayList<>();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}
	
	public void addFollowers(User user) {
		followers.add(user);
	}
}
