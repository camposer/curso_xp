package com.example.agil.service;

import java.util.List;

import com.example.agil.model.Tarea;
import com.example.agil.model.Tarea.Estado;

public interface TareaService {
	public Tarea agregarTarea(Tarea t);
	public void modificarTarea(Tarea t);
	public void eliminarTarea(Integer id);
	public Tarea obtenerTarea(Integer id);
	public List<Tarea> obtenerTareas();

	/**Método que para una tarea dada modifica su estado**/
	public void modificarEstadoTarea(Integer id, Estado estado );
	public void modificarTareaEsfuerzo(Tarea t);
}
