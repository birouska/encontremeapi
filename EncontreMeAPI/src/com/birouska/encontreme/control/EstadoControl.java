package com.birouska.encontreme.control;

import java.util.List;

import com.birouska.encontreme.dao.EstadoDAO;
import com.birouska.encontreme.model.Estado;

public class EstadoControl {

	EstadoDAO estDao = new EstadoDAO();

	public List<Estado> List() {
		return estDao.List();
	}

}
