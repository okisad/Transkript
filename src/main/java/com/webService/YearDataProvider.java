package com.webService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.entity.School.Year;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interfaces.WebServicesDatabaseService;
import com.model.WebServicesDatabaseServiceImp;



@Path("/getYearProvider")
public class YearDataProvider {

	@GET
	@Path("/{param}")
	public String get(@PathParam("param") String dep) throws JsonProcessingException{
		
		WebServicesDatabaseService dataService = new WebServicesDatabaseServiceImp();
		
		List<Year> years = dataService.getYearOfDepartmantFromDepartment(dep);
		
		ObjectMapper om = new ObjectMapper();
		
		String json = om.writeValueAsString(years);
		
		return json;
		
	}
	
}
