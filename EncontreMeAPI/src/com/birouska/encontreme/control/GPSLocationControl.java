package com.birouska.encontreme.control;

import java.util.List;

import com.birouska.encontreme.dao.GPSLocationDAO;
import com.birouska.encontreme.model.GPSLocation;

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
