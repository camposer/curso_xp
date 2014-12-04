package com.example.agil.dao;

import java.util.List;

import com.example.agil.model.Iteracion;

public interface IteracionDao {
	public void agregar(Iteracion i);
	public void modificar(Iteracion i);
	public void eliminar(Integer id);
	public Iteracion obtener(Integer id);
	public List<Iteracion> obtenerTodos();
}
