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
@Table(name="`uniteToExam`")
public class UniteToExam {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(updatable = false,name="`createdAt`")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name="`updatedAt`")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatedAt;

	
	@ManyToOne
	@JoinColumn(name="`uniteId`", referencedColumnName = "`id`")
	private Unite unite;
	
	
	@ManyToOne
	@JoinColumn(name="`examTypeId`",referencedColumnName = "`id`")
	private Unite examType;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public Unite getUnite() {
		return unite;
	}


	public void setUnite(Unite unite) {
		this.unite = unite;
	}


	public Unite getExamType() {
		return examType;
	}


	public void setExamType(Unite examType) {
		this.examType = examType;
	}
	
	
}
