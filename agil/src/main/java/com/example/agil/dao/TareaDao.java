package com.example.agil.dao;

import java.util.List;

import com.example.agil.model.Tarea;

public interface TareaDao {
	public Tarea agregar(Tarea t);
	public void modificar(Tarea t);
	public void eliminar(Integer id);
	public Tarea obtener(Integer id);
	public List<Tarea> obtenerTodos();
	public void modificarEsfuerzo(Tarea t);
}
