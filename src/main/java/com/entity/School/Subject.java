package com.entity.School;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.abstracts.SchoolInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="dersler")
public class Subject extends SchoolInfo{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ders_id")
	private int id;
	@JoinColumn(name="yil_id")
	@ManyToOne
	private Year year;
	@Column(name="ders_kodu")
	private String courseCode;
	@Column(name="ders_adi")
	private String courseName;
	@Column(name="ders_kredi")
	private String courseCredit;
	@Column(name="ders_yariyil")
	private String courseTerm;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(String courseCredit) {
		this.courseCredit = courseCredit;
	}
	public String getCourseTerm() {
		return courseTerm;
	}
	public void setCourseTerm(String courseTerm) {
		this.courseTerm = courseTerm;
	}
	
	
	
	
	

}
