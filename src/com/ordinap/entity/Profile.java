package com.ordinap.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="profile")
public class Profile {

 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
 
	@Column(name="`value`")
	private String value;
	
	@Column(updatable = false,name="`createdAt`")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name="`updatedAt`")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatedAt;
	
 
	@ManyToOne
	@JoinColumn(name = "`userId`", referencedColumnName = "`id`")
  	private User user;

	@ManyToOne
	@JoinColumn(name = "`contactTypeId`", referencedColumnName = "`id`")
  	private ContactType contactType;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
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


	public User getUser() {
		return user;
	}

/*
	public void setUser(User user) {
		this.user = user;
	}
 */
}
