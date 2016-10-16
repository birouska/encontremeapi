package com.birouska.encontreme.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.birouska.encontreme.control.GPSLocationControl;
import com.birouska.encontreme.model.GPSLocation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/locations")
public class GPSLocationResource {

	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	
	@Path("/locations")
	@OPTIONS
	@Produces("application/json")
	public Response greetingOPT() {


	    return Response.status(200) //200
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS")
	            .header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia,Authorization")
	            .build();
	}
	

	
	@POST
    @Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
    public Response salvarPessoasJSONP(InputStream incomingData) {
		
		StringBuilder crunchifyBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				crunchifyBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		
		Gson gson = new Gson();
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSz").create();
		
		GPSLocation gpsLocation = new GPSLocation();
		
		gpsLocation = gson.fromJson(crunchifyBuilder.toString(), GPSLocation.class);
		
		GPSLocationControl gpsLocationControl = new GPSLocationControl();
		gpsLocationControl.Create(gpsLocation);
		
		System.out.println("Data Received: " + crunchifyBuilder.toString());
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(crunchifyBuilder.toString()).build();
		
    }
	
	@POST
	@Path("/postService")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postREST(InputStream incomingData) {
		StringBuilder crunchifyBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				crunchifyBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + crunchifyBuilder.toString());
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(crunchifyBuilder.toString()).build();
	}
 

	public Integer tryParse(Object obj) {
		Integer retVal;
		try {
			retVal = Integer.parseInt((String) obj);
		} catch (NumberFormatException nfe) {
			retVal = 0; // or null if that is your preference
		}
		return retVal;
	}

	@Path("{id_user}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id_user") String id_user) {

		String strLocations = new String();

		try {

			int ID_user = tryParse(id_user);

			Gson gson = new Gson();
			strLocations = gson.toJson(getGPSLocation(ID_user));

		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}

		// return HTTP response 200 in case of success
		return Response.status(200).entity(strLocations).build();
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUsers(InputStream incomingData) {
		String strUsers = new String();
		try {
			
			Gson gson = new Gson();
			strUsers = gson.toJson(getGPSLocation(0));
			
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}

		// return HTTP response 200 in case of success
		return Response.status(200).entity(strUsers).build();
	}
	
	private List<GPSLocation> getGPSLocation(int id){
		List<GPSLocation> lstGPSLocation = new ArrayList<GPSLocation>();
		
		GPSLocationControl gpsLocControl = new GPSLocationControl();

		if(id==0)
			lstGPSLocation = gpsLocControl.List();
		else
			lstGPSLocation = gpsLocControl.List(id);
		
		return lstGPSLocation;
	}
}
