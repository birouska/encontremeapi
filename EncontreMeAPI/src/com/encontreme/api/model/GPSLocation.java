package com.encontreme.api.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class GPSLocation {
	
	private int id_user;
	private BigDecimal cel_number;
	private BigDecimal longitude;
	private BigDecimal latitude;
	private Timestamp  dt_captura;
	private Timestamp  dt_received;
	
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public BigDecimal getCel_number() {
		return cel_number;
	}
	public void setCel_number(BigDecimal cel_number) {
		this.cel_number = cel_number;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public Timestamp getDt_captura() {
		return dt_captura;
	}
	public void setDt_captura(Timestamp dt_captura) {
		this.dt_captura = dt_captura;
	}
	public Timestamp getDt_received() {
		return dt_received;
	}
	public void setDt_received(Timestamp dt_received) {
		this.dt_received = dt_received;
	}
  
}
