package com.client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RESTEasyClientGet {

	public static void main(String[] args) {
		try {

			ClientRequest request = new ClientRequest(
					"http://localhost:8080/RESTfulWebService/json/product/get");
			request.accept("application/json");
			ClientResponse<String> response = request.get(String.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					new ByteArrayInputStream(response.getEntity().getBytes())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
				System.out.println("Extracting json format : ");
				JSONParser parser=new JSONParser();
			      
			         Object obj = parser.parse(output);
			         JSONObject array = (JSONObject)obj;
			        
			         System.out.println(array.get("qty"));
			         System.out.println(array.get("name"));
				 
			}

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}