package com.birouska.encontreme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.birouska.encontreme.model.User;
import com.birouska.encontreme.type.Gender;
import com.birouska.encontreme.utility.ConnectionFactory;

public class UserDAO {

	public User List(long id)
	{
		String filtro = " where id = " + id;
		
		User user = new User();
		
		List<User> lstUsers =  new ArrayList<User>();
		
		lstUsers = List(filtro);
		
		if(lstUsers.size() > 0)
			user = lstUsers.get(0);
		else
			user = null;
		
		return user;
		
	}
	
	public List<User> List()
	{
		return List("");
	}
	
	private List<User> List(String filtro) {

		String sql = "SELECT * FROM tb_user";

		if(filtro.length()!=0)
			sql += filtro;
			
		List<User> users = new ArrayList<User>();

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

				User user = new User();

				// Recupera o id do banco e atribui ele ao objeto
				user.setId(rset.getLong("id"));
				user.setUserName(rset.getString("username"));
				user.setEmailAdress(rset.getString("emailAdress"));
				user.setGender((rset.getBoolean("gender") ? Gender.Masculino : Gender.Feminino));
				user.setPassword(rset.getString("password"));
				user.setDtCreate(rset.getTimestamp("dtcreated"));

				// Adiciono o contato recuperado, a lista de contatos
				users.add(user);
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
		return users;
	}
	
	public void Create(User user)
	{
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.getConnection();
			
			String sql = "INSERT INTO tb_user(firstname, lastname, emailadress, gender, password, dtcreated) VALUES ( ?, ?, ?, ?, ?, ?)";
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getEmailAdress());
			pstm.setBoolean(3, Boolean.parseBoolean(String.valueOf(user.getGender().ordinal())));
			pstm.setString(4, user.getPassword());
			
			java.util.Date date = new java.util.Date();
			pstm.setTimestamp(5, new Timestamp(date.getTime()));
			
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
