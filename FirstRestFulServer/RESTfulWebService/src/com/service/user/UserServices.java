package com.service.user;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/user/service")
public class UserServices {

	@PUT
	@Path("/create")
	public void createUser() {
		System.out.println("Inside createUser Method");
	}

	@GET
	@Path("/get/{userid}")
	public void getUser(@PathParam("userid") String userId, @QueryParam("fname")String firstName, @HeaderParam("Host")String clientName) {
		System.out.println("Inside getUser Method");
		System.out.println("User ID :" + userId);
		System.out.println("First Name :" + firstName);
		System.out.println("Client Name :" + clientName);
	}

	@POST
	@Path("/post")
	public void updateUser(@FormParam("username")String userName, @FormParam("email")String email, @CookieParam("phone")String phoneNum) {
		System.out.println("Inside updateUser Method");
		System.out.println("User Name :" + userName);
		System.out.println("Email Address :" + email);
		System.out.println("Mobile :" + phoneNum);
	}

	@DELETE
	public void deleteUser() {
		System.out.println("Inside deleteUser Method");
	}

	@Path("/special")

	public SpecialUser getSpecialUser() {
		return new SpecialUser();
	}
	
	@GET
	@Path("/getURIParams/{uriparam1}/{uriparam2}")
	
	public void getURIParams(@Context UriInfo ui){
		System.out.println("Multiple URI Parameters are: ");
		MultivaluedMap<String, String> multiMap = ui.getPathParameters();
		extractKeyValueFromMap(multiMap);
		
		System.out.println("Multiple URI Parameters are: ");
		MultivaluedMap<String, String> queryMap = ui.getQueryParameters();
		extractKeyValueFromMap(queryMap);
		
	}

	@GET
	@Path("/getHeaderParam")
	public void getHeaderParam(@Context HttpHeaders hh){
		System.out.println("Multiple Http Header Parameters are: ");
		MultivaluedMap<String, String> headerMap = hh.getRequestHeaders();
		extractKeyValueFromMap(headerMap);
		
		System.out.println("Multiple Cookie Parameters are: ");
		Map<String, Cookie> cookieMap = hh.getCookies();
		
		Set<String> keySet = cookieMap.keySet();
		
		for(String key : keySet){
			System.out.println("Key is " + key + " and Cookie value is " + cookieMap.get(key).getValue());
		}
	}
	
	@POST
	@Path("/getMultipleFormParams")
	public void getMultipleFormParams(MultivaluedMap<String, String> formParams){
		System.out.println("\n\n\nMultiple Form Parameters are: ");
		extractKeyValueFromMap(formParams);
	}
	
	@GET
	@Path("/getUserId/{userid}/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserId(@PathParam("userid") String userId, @PathParam("email") String email){
		System.out.println("Inside getUserId userid is " + userId);
		User user = new User();
		user.setUserId(userId);
		user.setEmail(email);
		return user;
	}
	
	@GET
	@Path("/getUserId/{userid}/{email}")
	@Produces(MediaType.APPLICATION_XML)
	public User getUserId1(@PathParam("userid") String userId, @PathParam("email") String email){
		System.out.println("Inside getUserId1 userid is " + userId);
		User user = new User();
		user.setUserId(userId);
		user.setEmail(email);
		return user;
	}
	
	@POST
	@Path("/processInput")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String processInput(String input){
		return "Processed " + input;
	}
	
/*	@POST
	@Path("/uploadFile")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadFile(@FormDataParam("file") InputStream is, @FormDataParam("file") FormDataContentDisposition attachmentInfo){
		System.out.println("Inside uploadFile Method");
		String uploadToFile = "C:\\share\\" + attachmentInfo.getFileName();
		try {
			FileOutputStream outStream = new FileOutputStream(new File(uploadToFile));
			byte [] bytes = new byte[1024];
			int bytesRead = 0;
			while((bytesRead= is.read(bytes)) != -1){
				outStream.write(bytes, 0, bytesRead);
			}
			outStream.flush();
			outStream.close();
		} catch (Exception e) {
		e.getMessage();
		}
	}*/
	
	@GET
	@Path("/sendResponse")
	@Produces(MediaType.TEXT_PLAIN)
	
	public Response sendResponse(){
		File file = new File("C:\\share\\JDBC.pdf");
		List<String> stringList = new ArrayList<String>();
		GenericEntity<List<String>> genericEntity = new GenericEntity<List<String>>(stringList){};
		//return Response.ok().entity(genericEntity).header("Content-Disposition", "attachment; filename=\"JdbcExSuresh.pdf\"").build();
		return Response.ok().entity(file).header("Content-Disposition", "attachment; filename=\"JdbcExSuresh.pdf\"").build();
	}
	
	@POST
	@Path("receiveUser")
	@Consumes(MediaType.TEXT_PLAIN)
	
	public Response receiveUser(User user) {
		System.out.println("userid : " + user.getUserId() + " and Email is " + user.getEmail());
		return Response.ok().build();
	}
	
	@GET
	@Path("/getUserInfo")
	@Produces(MediaType.TEXT_PLAIN)
	public User getUserInfo(){
		User user = new User();
		user.setUserId("Suresh");
		user.setEmail("suresh84mca@gmail.com");
		return user;
	}
	
	private void extractKeyValueFromMap(MultivaluedMap<String, String> multiMap) {
		
		Set<String> keySet = multiMap.keySet();
		for(String key: keySet){
			System.out.println("Key : " + key + "  Value :" + multiMap.get(key));
		}
		
	}
}
