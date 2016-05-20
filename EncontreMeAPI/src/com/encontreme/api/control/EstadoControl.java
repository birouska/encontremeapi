package com.encontreme.api.control;

import java.util.List;

import com.encontreme.api.dao.EstadoDAO;
import com.encontreme.api.model.Estado;

public class EstadoControl {

	EstadoDAO estDao = new EstadoDAO();

	public List<Estado> List() {
		return estDao.List();
	}

}
