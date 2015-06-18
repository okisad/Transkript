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


@Entity(name="bolumler")
public class Department extends SchoolInfo{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bolum_id")
	private int dep_id;
	@ManyToOne
	@JoinColumn(name="fakulte_id")
	private Faculty faculty;
	@Column(name="bolum_adi")
	private String dep_name;
	@OneToMany(mappedBy="department")
	@Cascade({CascadeType.ALL})
	@JsonIgnore
	private List<Year> years;
	
	
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public List<Year> getYears() {
		return years;
	}
	public void setYears(List<Year> years) {
		this.years = years;
	}
	@Override
	public String toString() {
		return "Department [dep_name=" + dep_name + ", years=" + years + "]";
	}

	
	
	

}
