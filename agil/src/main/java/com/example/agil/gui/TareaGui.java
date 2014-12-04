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

public class TareaGui {
	private TareaService tareaService;
	private IteracionService iteracionService;
	private Scanner scanner;
	
	public static void main(String[] args) {
		new TareaGui().iniciar();
		new TareaGui().asignarEsfuerzo();
	}
	
	public TareaGui() {
		this.tareaService = new TareaServiceImpl();
		this.iteracionService = new IteracionServiceImpl();
		this.scanner = new Scanner(System.in);
	}

	public void iniciar() {
		Tarea t = new Tarea();

		System.out.println("INSERTAR TAREA\r\n");

		System.out.println("Titulo?");
		t.setNombre(scanner.nextLine());
		System.out.println("Descripcion?");
		t.setDescripcion(scanner.nextLine());
		System.out.println("Prioridad?");

		String prioridad = scanner.nextLine();
		Integer prio = null;
		try {
			prio = Integer.parseInt(prioridad);
		} catch (Exception e) {
			System.out.println(prioridad + " no es un número entero");
		}
		t.setPrioridad(prio);

		System.out.println("Esfuerzo?");

		String esfuerzo = scanner.nextLine();
		Integer esf = null;
		try {
			esf = Integer.parseInt(esfuerzo);
		} catch (Exception e) {
			System.out.println(esfuerzo + " no es un número entero");
		}
		t.setEsfuerzo(esf);

		t.setEstado(Tarea.Estado.TODO);
		t.setFecha(new Date());
		t.setRelease("");
		t.setValor(0);

		Iteracion ite = new Iteracion();
		ite.setId(1);
		t.setIteracion(ite);

		tareaService.agregarTarea(t);

		System.out.println("Se ha insertado correctamente");
		System.out.println("<Pulse para volver>");
		scanner.nextLine();
		
	}
	
	public void asignarEsfuerzo(){
		while (true){
			System.out.println("Menu - Release Planning");
			System.out.println("1 - Asignar Esfuerzo");
			System.out.println("2 - Eliminar Esfuerzo");
			System.out.println("3 - Salir");
			System.out.print("? ");
			
			String opcion = scanner.nextLine();

			List<Tarea> tareas = tareaService.obtenerTareas();
			if(opcion.equals("1")){
				if (tareas != null) for (Tarea t1 : tareas) 
					System.out.println(t1);		
				System.out.print("Id Tarea?");
				
				int idTarea = Integer.parseInt(scanner.nextLine());
				System.out.print("Esfuerzo? ");
				int esfuerzo = Integer.parseInt(scanner.nextLine());
				/** Modificamos la tarea en BD */
				Tarea t = new Tarea();
				t.setEsfuerzo(esfuerzo);
				t.setId(idTarea);
				Tarea res = tareaService.obtenerTarea(idTarea);
				if(res!=null)
					tareaService.modificarTareaEsfuerzo(t);
				else 
					System.out.println("El id introducido " + idTarea + " no existe en BD");
				
				tareas = tareaService.obtenerTareas();
				if (tareas != null) for (Tarea t1 : tareas) 
					System.out.println(t1);
			} else if(opcion.equals("3")){
				break;
			}
			
		
		}
	}
	
	
	public void cambiarEstado(){
		while (true){
			System.out.println("Menu - Cambiar Estado");
			System.out.println("1 - TODO");
			System.out.println("2 - IN_PROGRESS");
			System.out.println("3 - DONE");
			System.out.print("? ");
			
			String opcion = scanner.nextLine();

			System.out.print("Id Tarea?");
			int idTarea = Integer.parseInt(scanner.nextLine());
			
			Tarea tarea = tareaService.obtenerTarea(idTarea);
			
			System.out.print("Estado? ");
			int estado1 = Integer.parseInt(scanner.nextLine());
			
				
			Estado estado = null;
			
			if(estado1==1)
				
				estado=Estado.TODO;
			else if(estado1==2)
				estado=Estado.IN_PROGRESS;
			else if(estado1==3)
				estado=Estado.DONE;
			
		
			tareaService.modificarEstadoTarea(idTarea, estado);
			
				
		}
			
		
		}
	}

