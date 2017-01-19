package com.ordinap.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
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
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="`contactType`")
public class ContactType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="`contactName`")
	
	private String contactName;
	@Column(updatable = false,name="`createdAt`")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name="`updatedAt`")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatedAt;

	@OneToMany(mappedBy = "contactType",fetch=FetchType.EAGER ,cascade = CascadeType.ALL)
	private Set<Profile> userProfile=new HashSet<>();

}
