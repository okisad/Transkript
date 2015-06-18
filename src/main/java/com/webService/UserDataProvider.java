package com.webService;

import java.io.IOException;
import java.io.StringWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entity.UserDAO;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.interfaces.UserDatabaseService;
import com.model.UserDatabaseServiceImp;


@Path("/getPerson")
public class UserDataProvider {

	@GET
	@Path("/{param}")
	public String get(@PathParam("param") String email) throws JsonGenerationException, JsonMappingException, IOException{
		
		UserDatabaseService dataService = new UserDatabaseServiceImp();
		
		ObjectMapper om = new ObjectMapper();
		
		//Gson gson = new Gson();
		
		UserDAO p = dataService.getPersonFromEmail(email);
		
		//String a = ow.writeValueAsString(p);
		
		String personJson = om.writeValueAsString(p);
		
		return personJson;
		
	}
}