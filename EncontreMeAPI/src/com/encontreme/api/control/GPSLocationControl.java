package com.encontreme.api.control;

import java.util.List;

import com.encontreme.api.dao.GPSLocationDAO;
import com.encontreme.api.model.GPSLocation;

public class GPSLocationControl {
	
	GPSLocationDAO gpsLocationDAO = new GPSLocationDAO();
	
	public List<GPSLocation> List()
	{
		return gpsLocationDAO.List();
	}
	
	public List<GPSLocation> List(int id_user)
	{
		return gpsLocationDAO.List(id_user);
	}
	
	public void Create(GPSLocation gpsLocation)
	{
		gpsLocationDAO.Create(gpsLocation);
	}
	
}
