package com.webService;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.entity.School.Department;
import com.entity.School.Subject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interfaces.WebServicesDatabaseService;
import com.model.WebServicesDatabaseServiceImp;


@Path("/getCourseProvider")
public class CourseDataProvider {

	@GET
	@Path("/{year}/{dep}/{fac}")
	public String get(@PathParam("year") String year,@PathParam("dep") String dep,@PathParam("fac") String fac) throws JsonProcessingException{
		
		WebServicesDatabaseService dataService = new WebServicesDatabaseServiceImp();
		
		List<Department> deps = dataService.getDepartmentFromFaculty(fac);
		
		Iterator<Department> it = deps.listIterator();
		
		Department d=null;
		
		while(it.hasNext()){
			
			Department d1 =it.next();
			
			if(d1.getDep_name().equals(dep)){
				
				d=d1;
				
			}
			
		}
		
		List<Subject> subs = dataService.getSubjectsOfYearFromYearAndDepartment(d, year);
		
		ObjectMapper om = new ObjectMapper();
		
		String json = om.writeValueAsString(subs);
		
		return json;
		
	}
	
}
