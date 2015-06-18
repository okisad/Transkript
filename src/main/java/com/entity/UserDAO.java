package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@JsonIgnoreProperties({"id","password1","password2"})
public class UserDAO {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "email")
	private String email;
	@Column(name="password")
	private String password1;
	@Transient
	private String password2;
	@OneToMany(mappedBy = "userDAO",orphanRemoval=true,fetch=FetchType.EAGER)
	@Cascade({CascadeType.ALL})
	private List<CourseDAO> courses;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public List<CourseDAO> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseDAO> courses) {
		this.courses = courses;
	}

	
	
}
