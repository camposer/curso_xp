package com.example.agil.gui;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.example.agil.model.Iteracion;
import com.example.agil.model.Tarea;
import com.example.agil.model.Tarea.Estado;
import com.example.agil.service.IteracionService;
import com.example.agil.service.IteracionServiceImpl;
import com.example.agil.service.TareaService;
import com.example.agil.service.TareaServiceImpl;

public class IteracionGui {
	private TareaService tareaService;
	private IteracionService iteracionService;
	private Scanner scanner;
	
	public static void main(String[] args) {
		new IteracionGui().iniciar();
	}
	
	public IteracionGui() {
		this.scanner = new Scanner(System.in);
		this.tareaService = new TareaServiceImpl();
		this.iteracionService = new IteracionServiceImpl();
	}

	private void iniciar() {
		
		boolean crearIteracion = true;
		boolean agregarTarea = true;
		while (crearIteracion) {
			Iteracion it = new Iteracion();
			System.out.println("Introduzca el nombre de la iteración: ");
			String nombre = (String) scanner.nextLine();
			it.setNombre(nombre);
			System.out.println("Introduzca la descripción de la iteración: ");
			String descripcion = (String) scanner.nextLine();
			it.setDescripcion(descripcion);
			it.setFechaInicio(new Date());
			it.setFechaFin(new Date());
			it = iteracionService.agregarIteracion(it);
			if (it != null) {
				System.out.println("Se ha creado correctamente la iteración: " + it.getNombre());
			} else {
				System.out.println("No se ha podido crear la iteración");
			}
			
			while (agregarTarea){
				System.out.println("Lista de posibles tareas a agregar:");
				List<Tarea> tareas = tareaService.obtenerTareas();
				if (tareas != null) {
					boolean tareaTodo = false;
					for (Tarea tarea : tareas) {
						if (tarea.getEstado().equals(Estado.TODO)) {
							if (tareaTodo == false) {
								tareaTodo = true;
							}
							System.out.println("Id: "+ tarea.getId() +" Nombre: "+ tarea.getNombre());
						}
					}
					if (tareaTodo == false) {
						System.out.println("No existen tareas en estado TODO");
					}
				} else {
					System.out.println("No existen tareas");
				}
				
				System.out.println("Introduzca el id de la tarea a agregar: ");
				Integer idTarea = new Integer((String) scanner.nextLine());
				
				Tarea modTarea = tareaService.obtenerTarea(idTarea);
				modTarea.setIteracion(it);
				tareaService.modificarTarea(modTarea);
				
				System.out.println("Se ha agregado correctamente la tarea a la iteración: " + it.getNombre());
				System.out.println("Desea agregar una nueva tarea? Y/N");
				String addTarea = (String) scanner.nextLine();
				if (addTarea != null && addTarea.equals("N")) {
					agregarTarea = false;
				}
			}
		}
	}
	
	
}
