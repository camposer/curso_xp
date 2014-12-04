package com.example.agil.service;

import com.example.agil.dao.IteracionDao;
import com.example.agil.dao.IteracionDaoImpl;
import com.example.agil.model.Iteracion;

public class IteracionServiceImpl implements IteracionService {
	private IteracionDao iteracionDao;
	
	public IteracionServiceImpl() {
		this.iteracionDao = new IteracionDaoImpl();
	}

	public Iteracion agregarIteracion(Iteracion i) {
		return iteracionDao.agregar(i);
	}

}
