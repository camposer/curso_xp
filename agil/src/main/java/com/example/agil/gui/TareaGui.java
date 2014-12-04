package com.example.agil.gui;

import java.util.Date;
import java.util.List;

import com.example.agil.model.Iteracion;
import com.example.agil.model.Tarea;
import com.example.agil.service.IteracionService;
import com.example.agil.service.IteracionServiceImpl;
import com.example.agil.service.TareaService;
import com.example.agil.service.TareaServiceImpl;

public class TareaGui {
	private TareaService tareaService;
	private IteracionService iteracionService;
	
	public static void main(String[] args) {
		new TareaGui().iniciar();
	}
	
	public TareaGui() {
		this.tareaService = new TareaServiceImpl();
		this.iteracionService = new IteracionServiceImpl();
	}

	private void iniciar() {
		Iteracion i = new Iteracion();
		i.setNombre("i1");
		i.setDescripcion("i1");
		i.setFechaInicio(new Date());
		i.setFechaFin(new Date());
		i = iteracionService.agregarIteracion(i);
		
		Tarea t = new Tarea();
		t.setNombre("t1");
		t.setDescripcion("t1");
		t.setEsfuerzo(0);
		t.setEstado(Tarea.Estado.TODO);
		t.setFecha(new Date());
		t.setPrioridad(1);
		t.setRelease("");
		t.setValor(1);
		t.setIteracion(i);
		tareaService.agregarTarea(t);
		
		List<Tarea> tareas = tareaService.obtenerTareas();
		if (tareas != null) for (Tarea t1 : tareas) 
			System.out.println(t1);
		
	}
	
	
}
