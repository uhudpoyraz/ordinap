package com.ordinap.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="users")
public class User {
	
	
	
	/*"id" int PRIMARY KEY,
	"name" varchar(255),
	"surname" varchar(255),
	"password" varchar(255),
	"username" varchar(255),
	"type" int,
	"createdAt" datetime,
	"updatedAt" datetime*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="`name`")
	private String name;
	
	@Column(name="`surname`")
	private String surname;
	
	@Column(name="`email`")
	private String email;
	
	@Column(name="`username`")
	private String username;
	
	@Column(name="`password`")
	private String password;
	
	@Column(name="`type`")
	private int type;
	
	@Column(updatable = false,name="`createdAt`")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdAt;
	
	
	@Column(name="`updatedAt`")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatedAt;
	
	 
	@OneToMany(mappedBy = "user",fetch=FetchType.EAGER ,cascade = CascadeType.ALL)
	private Set<Profile> userProfile=new HashSet<>();

	public Set<Profile> getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(Set<Profile> userProfile) {
		this.userProfile = userProfile;
	}

	public int getId() {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

}
