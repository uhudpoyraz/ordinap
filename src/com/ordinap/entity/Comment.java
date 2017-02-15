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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="comment")
public class Comment {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="`postId`",insertable=false,updatable=false)
	private String postId;
	
	@Column(name="`userId`",insertable=false,updatable=false)
	private String userId;
	
	@Column(name="`commentDescription`")
	private String commentDescription;
	
	@Column(name="`commentImagePath`")
	private String commentImagePath;
	
	@Column(name="`isAnswer`")
	private boolean isAnswer;
	
	@Column(updatable = false,name="`createdAt`")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdAt;
	
	
	@Column(name="`updatedAt`")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatedAt;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "`postId`", referencedColumnName = "`id`")
	private Post post;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "`userId`", referencedColumnName = "`id`")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public String getCommentImagePath() {
		return commentImagePath;
	}

	public void setCommentImagePath(String commentImagePath) {
		this.commentImagePath = commentImagePath;
	}

	public boolean isAnswer() {
		return isAnswer;
	}

	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
