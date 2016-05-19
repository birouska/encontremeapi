package com.encontreme.control;

import java.util.List;

import com.encontreme.dao.UserDAO;
import com.encontreme.model.User;

public class UserControl {
	
	UserDAO userDAO = new UserDAO();
	
	public List<User> List()
	{
		return userDAO.List();
	}
	
	public User List(int id)
	{
		return userDAO.List(id);
	}
	
	public void Create(User user)
	{
		userDAO.Create(user);
	}
	
}
