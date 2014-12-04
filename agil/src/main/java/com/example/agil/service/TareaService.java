package com.example.agil.service;

import java.util.List;

import com.example.agil.model.Tarea;

public interface TareaService {
	public Tarea agregarTarea(Tarea t);
	public void modificarTarea(Tarea t);
	public void eliminarTarea(Integer id);
	public Tarea obtenerTarea(Integer id);
	public List<Tarea> obtenerTareas();

}
