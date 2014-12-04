package com.example.agil.service;

import java.util.List;

import com.example.agil.dao.TareaDao;
import com.example.agil.dao.TareaDaoImpl;
import com.example.agil.model.Tarea;

public class TareaServiceImpl implements TareaService {
	private TareaDao tareaDao;
	
	public TareaServiceImpl() {
		this.tareaDao = new TareaDaoImpl();
	}

	public Tarea agregarTarea(Tarea t) {
		return tareaDao.agregar(t);
	}

	public void modificarTarea(Tarea t) {
		tareaDao.modificar(t);
	}

	public void eliminarTarea(Integer id) {
		tareaDao.eliminar(id);
	}

	public Tarea obtenerTarea(Integer id) {
		return tareaDao.obtener(id);
	}

	public List<Tarea> obtenerTareas() {
		return tareaDao.obtenerTodos();
	}

}
