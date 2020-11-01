package com.client;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.client.urlconnection.HTTPSProperties;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
		    try {
		    	SSLContext sslContext = SSLContext.getInstance("SSL");
		    	ServerTrustManager serverTrustManager = new ServerTrustManager();
		    	try {
					sslContext.init(null, new TrustManager[] {serverTrustManager}, null);
				} catch (KeyManagementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				defaultClientConfig.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new HTTPSProperties(null,sslContext));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			Client client = Client.create(defaultClientConfig);
			client.addFilter(new HTTPBasicAuthFilter("suresh","suresh"));
			String userName = (String)request.getParameter("username");
			String email = (String)request.getParameter("email");
//			String phoneNum = (String)request.getParameter("phone");
//			String lastName = (String)request.getParameter("lastname");
			
//			Form form = new Form();
//			form.add("username", userName);
//			form.add("email", email);
			
/*			Cookie cookie1 = new Cookie("phone", phoneNum);
			Cookie cookie2 = new Cookie("lastname", lastName);*/
			//WebResource webResource = client.resource("http://localhost:8080/RESTfulWebService/backend/user/service/getUserInfo");
			WebResource webResource = client.resource("https://localhost:8443/RESTfulWebService/backend/user/service/getUserInfo");
			//WebResource webResource = client.resource("http://localhost:8080/RESTfulWebService/backend/user/service/receiveUser");
			//WebResource webResource = client.resource("http://localhost:8080/RESTfulWebService/backend/user/service/processInput");
			//WebResource webResource = client.resource("http://localhost:8080/RESTfulWebService/backend/user/service/getUserId/" + userName + "/" + email);
			//WebResource webResource = client.resource("http://localhost:8080/RESTfulWebService/backend/user/service/getHeaderParam");
			//WebResource webResource = client.resource("http://localhost:8080/RESTfulWebService/backend/user/service/post");
			//ClientResponse resp = webResource.accept("text/html").cookie(cookie1).cookie(cookie2).post(ClientResponse.class, form);
			//ClientResponse resp = webResource.accept("text/html").cookie(cookie1).cookie(cookie2).get(ClientResponse.class);
			//ClientResponse resp = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			
			/*User user = new User();
			user.setUserId(request.getParameter("username"));
			user.setEmail(request.getParameter("email"));
			*/
			//String input = request.getParameter("username") + "&" + request.getParameter("email");
			
			ClientResponse resp = webResource.get(ClientResponse.class);
			//ClientResponse resp = webResource.accept(MediaType.TEXT_PLAIN).entity(user, MediaType.APPLICATION_JSON).post(ClientResponse.class);
			if(resp.getStatus() == 200){
				String output = resp.getEntity(String.class);
				System.out.println("Output :" + output);
			}
		
	}

}
