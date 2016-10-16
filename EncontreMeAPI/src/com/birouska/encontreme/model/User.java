package com.birouska.encontreme.model;

import com.birouska.encontreme.type.Gender;
import java.sql.Timestamp;

public class User {

	private long Id;
	private String userName;
	private String emailAdress;
	private Gender gender;
	private String password;
	private Timestamp dtcreated;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getDtCreate() {
		return dtcreated;
	}

	public void setDtCreate(Timestamp dtcreated) {
		this.dtcreated = dtcreated;
	}
	
	

}
