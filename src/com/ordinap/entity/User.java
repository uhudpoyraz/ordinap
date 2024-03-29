package com.ordinap.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;
 
 
 
@Entity
@Table(name="users")
public class User implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="`name`")
	private String name;
	
	@Column(name="`surname`")
	private String surname;
	
	@Column(name="`email`")
	private String email;
	
	@Column(name="`password`")
	private String password;
	
	@Column(name="`profile_image`")
	private String profileImage;
	
	@Column(name="`token`")
	private String token;
	
	@Column(name="`type`")
	private int type;
	
	

	@Column(updatable = false,name="`created_at`")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdAt;
	
	
	@Column(name="`updated_at`")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatedAt;
	
	 
	@OneToMany(mappedBy = "user",fetch=FetchType.LAZY ,cascade = CascadeType.ALL)
	private Set<Profile> userProfile=new HashSet<>();
	
	 
	@OneToMany(mappedBy = "user",fetch=FetchType.LAZY ,cascade = CascadeType.ALL)
	private Set<Post> userPosts=new HashSet<>();

	 
	@OneToMany(mappedBy = "user",fetch=FetchType.LAZY ,cascade = CascadeType.ALL)
	private List<Comment> comments=new ArrayList<Comment>();
	
	@Formula("(select count(p.id) from post as p where p.user_id=`id`)")
	private Integer postCount;
	
	@Formula("(select count(c.id) from comment as c where c.user_id=`id`)")
	private Integer commentCount;
	
	public User(){}
	public User(Integer id,String name,String surname,String email,String profileImage,String token){
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.profileImage=profileImage;
		this.email=email;
		this.token=token;
	}
	
	
	public Integer getPostCount() {
		return postCount;
	}

	public void setPostCount(Integer postCount) {
		this.postCount = postCount;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Set<Profile> getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(Set<Profile> userProfile) {
		this.userProfile = userProfile;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<Post> getUserPosts() {
		return userPosts;
	}

	public void setUserPosts(Set<Post> userPosts) {
		this.userPosts = userPosts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
