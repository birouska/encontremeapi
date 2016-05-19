package com.encontreme.control;

import java.util.List;

import com.encontreme.dao.EstadoDAO;
import com.encontreme.model.Estado;

public class EstadoControl {

	EstadoDAO estDao = new EstadoDAO();

	public List<Estado> List() {
		return estDao.List();
	}

}
