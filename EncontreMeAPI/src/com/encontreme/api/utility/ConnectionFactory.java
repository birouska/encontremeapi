package com.encontreme.api.utility;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static String dataBase;
	private static String user;
	private static String pass;
	
	public static Connection getConnection() {
		
		Connection cn = null;
		
		String ServerName = getServerName();
		
		ServerName = "laranjinha";
		
		System.out.println("Server Name: " + ServerName);
		
				
		if(ServerName.equals("birouska-pc"))
		{
			user = "encontremeUser";
			pass = "3nc0ntr3m3Us3r";
			dataBase = "jdbc:postgresql://127.0.0.1:5432/db_encontreme";
			
		}
		else
		{
			user = "dewkrxxhiwahsb";
			pass = "1FnP3kGMUTrRmWYYHbuBLpgT7e";
			dataBase = "jdbc:postgresql://ec2-23-21-193-140.compute-1.amazonaws.com:5432/d8k73lim09eq0c?sslmode=require";
			
			//String url = "jdbc:postgresql://ec2-107-20-214-225.compute-1.amazonaws.com:5432/databasename?user=someusername&password=somepassword&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			
		}

		String url = dataBase;
		
		Properties props = new Properties();
		props.setProperty("user", user);
		props.setProperty("password", pass);

		try {
			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Nao foi possivel carregar o driver");
		}

		return cn;
	}

	private static String getServerName() {
		String hostname = "Unknown";

		try
		{
		    InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    hostname = addr.getHostName();
		}
		catch (UnknownHostException ex)
		{
		    System.out.println("Hostname can not be resolved");
		}
		
		return hostname;
	}

}