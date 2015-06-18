package com.interfaces;

import java.util.List;

import com.abstracts.SchoolInfo;
import com.entity.School.Department;
import com.entity.School.Subject;
import com.entity.School.Year;

public interface WebServicesDatabaseService {

	public List<Department> getDepartmentFromFaculty(String faculty);

	public List<Year> getYearOfDepartmantFromDepartment(String Department);

	public List<Subject> getSubjectsOfYearFromYearAndDepartment(Department department, String Year);

}
