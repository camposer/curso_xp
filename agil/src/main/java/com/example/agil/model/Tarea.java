package com.example.agil.model;

import java.util.Date;

public class Tarea {
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer prioridad;
	private Integer esfuerzo;
	private String release;
	private Date fecha;
	private Integer valor;
	private Estado estado;
	private Iteracion iteracion;
	
	public static enum Estado {
		TODO, IN_PROGRESS, DONE;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public Integer getEsfuerzo() {
		return esfuerzo;
	}

	public void setEsfuerzo(Integer esfuerzo) {
		this.esfuerzo = esfuerzo;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Iteracion getIteracion() {
		return iteracion;
	}

	public void setIteracion(Iteracion iteracion) {
		this.iteracion = iteracion;
	}
}
