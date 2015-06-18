package com.entity.School;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.abstracts.SchoolInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="fakulte")
public class Faculty extends SchoolInfo{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fakulte_id")
	private int id;
	@Column(name="fakulte_adi")
	private String facultyName;
	@OneToMany(mappedBy="faculty")
	@Cascade({CascadeType.ALL})
	@JsonIgnore
	private List<Department> departments;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	@Override
	public String toString() {
		return "Faculty [facultyName=" + facultyName + ", departments="
				+ departments + "]";
	}
	
	
	
	
	
	
	
}
