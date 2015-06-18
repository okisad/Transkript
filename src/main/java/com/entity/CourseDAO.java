package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CourseDAO {

	@Id
	@Column(name="course_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int courseId;
	@Column
	private String courseCode;
	@Column
	private String courseDescription;
	@Column
	private String credit;
	@Column
	private String courseGrade;
	@Column
	private int term;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id")
	@JsonIgnore
	private UserDAO userDAO;
	
	public CourseDAO() {
		// TODO Auto-generated constructor stub
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public CourseDAO(String courseCode, String courseDescription,
			String credit, String courseGrade, int term, UserDAO userDAO) {
		super();
		this.courseCode = courseCode;
		this.courseDescription = courseDescription;
		this.credit = credit;
		this.courseGrade = courseGrade;
		this.term = term;
		this.userDAO = userDAO;
	}
	
	
	
}
