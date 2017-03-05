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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "unites")
public class Unite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "`name`")
	private String name;

	@Column(name = "`course_id`" ,insertable=false, updatable=false)
	private int courseId;

	@JsonIgnore
	@Column(updatable = false, name = "`created_at`")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdAt;
	@JsonIgnore
	@Column(name = "`updated_at`")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatedAt;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "`course_id`", referencedColumnName = "`id`")
	private Course course;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "`unite_to_exam`", 
	joinColumns = { @JoinColumn(name = "`unite_id`") },
	inverseJoinColumns = { @JoinColumn(name = "`exam_type_id`") })
	private List<ExamType> examTypes = new ArrayList<ExamType>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "unite",fetch=FetchType.LAZY ,cascade = CascadeType.ALL)
	private List<Post> unitePosts=new ArrayList<Post>();
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public List<ExamType> getExamTypes() {
		return examTypes;
	}

	public void setExamTypes(List<ExamType> examTypes) {
		this.examTypes = examTypes;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}


 
}
