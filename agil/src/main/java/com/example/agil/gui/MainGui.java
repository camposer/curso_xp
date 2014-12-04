package com.example.agil.gui;

import java.util.Scanner;

public class MainGui {

	private Scanner scanner;
	private TareaGui tareaGui;
	public static void main(String[] args) {
		
		new MainGui().iniciar();
	}
		
	public MainGui() {
		this.tareaGui = new TareaGui();
		this.scanner = new Scanner(System.in);
	}
	
	private void iniciar() {
		
		while (true) {
		
			System.out.println("ÁGIL APP\r\n");
			
			System.out.println("<1> Insertar tarea");
			System.out.println("<2> Insertar iteración");
			System.out.println("<3> Gestion Planning");
			System.out.println("<4> Salir");
			
			System.out.println("\r\noperacion? ");
			
			String opcion = scanner.nextLine();
			if (opcion.equals("4"))
				break;
			
			try {
				
				if (opcion.equals("1")) {
					tareaGui.iniciar();
				} else if(opcion.equals("3")){
					tareaGui.asignarEsfuerzo();
				}	
			} catch (Exception e) {

				System.out.println(String.format("Error al ejecutar la operación " + e));
			}
		}
		
		
	}
	
}
