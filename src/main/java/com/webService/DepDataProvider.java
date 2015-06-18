package com.webService;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.entity.School.Department;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.interfaces.WebServicesDatabaseService;
import com.model.WebServicesDatabaseServiceImp;



@Path("/getDepProvider")
public class DepDataProvider {

	@GET
	@Path("/{param}")
	public String get(@PathParam("param") String fak) throws JsonProcessingException{
		
		WebServicesDatabaseService dataService = new WebServicesDatabaseServiceImp();
		
		List<Department> deps = dataService.getDepartmentFromFaculty(fak);

		ObjectMapper om = new ObjectMapper();
		
		String donus = om.writeValueAsString(deps);
		
		return donus;
		
	}
	
}
