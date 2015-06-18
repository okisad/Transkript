package com.entity.School;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.abstracts.SchoolInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="yillar")
public class Year extends SchoolInfo{

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="yil_id")
	private int id;
	@ManyToOne
	@JoinColumn(name="bolum_id")
	private Department department;
	@Column(name="yil")
	private String year;
	@OneToMany(mappedBy="year")
	@Cascade({CascadeType.ALL})
	@JsonIgnore
	private List<Subject> subjects;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		return "Year [year=" + year + ", subjects=" + subjects + "]";
	}
	
	
	
	
}
