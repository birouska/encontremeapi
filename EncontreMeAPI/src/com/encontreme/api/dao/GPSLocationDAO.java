package com.encontreme.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.encontreme.api.model.GPSLocation;
import com.encontreme.api.utility.ConnectionFactory;

public class GPSLocationDAO {

	public List<GPSLocation> List(long id_user)
	{
		String filtro = " where id_user = " + id_user;
		
		List<GPSLocation> lstGPS =  new ArrayList<GPSLocation>();
		
		lstGPS = List(filtro);
		
		return lstGPS;
	}
	
	public List<GPSLocation> List()
	{
		return List("");
	}
	
	private List<GPSLocation> List(String filtro) {

		String sql = "SELECT * FROM tb_localizacao";

		if(filtro.length()!=0)
			sql += filtro;
			
		List<GPSLocation> lstGPSLocation = new ArrayList<GPSLocation>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.getConnection();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				GPSLocation gpsLocation = new GPSLocation();

				// Recupera o id do banco e atribui ele ao objeto
				gpsLocation.setId_user(rset.getInt("id_user"));
				gpsLocation.setCel_number( rset.getBigDecimal("cel_number"));
				gpsLocation.setLatitude(rset.getBigDecimal("latitude"));
				gpsLocation.setLongitude(rset.getBigDecimal("longitude"));
				gpsLocation.setDt_captura(rset.getTimestamp("dt_captura"));
				gpsLocation.setDt_received(rset.getTimestamp("dt_received"));

				// Adiciono a localização recuperada, a lista de localizações
				lstGPSLocation.add(gpsLocation);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		// TODO Auto-generated method stub
		return lstGPSLocation;
	}
	
	public void Create(GPSLocation gpsLocation)
	{
	
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.getConnection();
			
			String sql = "INSERT INTO tb_localizacao(id_user, cel_number, longitude, latitude, dt_captura, dt_received) VALUES (?, ?, ?, ?, ?, ?)";
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, gpsLocation.getId_user());
			pstm.setBigDecimal(2, gpsLocation.getCel_number());
			pstm.setBigDecimal(3, gpsLocation.getLongitude());
			pstm.setBigDecimal(4, gpsLocation.getLatitude());
			pstm.setTimestamp(5, gpsLocation.getDt_captura());
			
			java.util.Date date= new java.util.Date();
			pstm.setTimestamp(6, new Timestamp(date.getTime()));

			pstm.executeUpdate();
					
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

}
