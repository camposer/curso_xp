package com.example.calculadora.gui;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import com.example.calculadora.service.CalculadoraService;
import com.example.calculadora.service.CalculadoraServiceFactory;

public class Principal {
	private Scanner scanner;
	private CalculadoraService calculadoraService;

	public Principal() {
		//this.scanner = new Scanner(System.in);
		try {
			this.scanner = new Scanner(new FileInputStream("input/calculadora.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.calculadoraService = CalculadoraServiceFactory
				.createCalculadoraService();
	}

	public void iniciar() {
		while (true) {
			System.out.println();
			System.out.println("1. Sumar");
			System.out.println("2. Restar");
			System.out.println("3. Multiplicar");
			System.out.println("4. Dividir");
			System.out.println("5. Salir");
			System.out.print("? ");
			
			String opcion = scanner.nextLine();
			if (opcion.equals("5")) // Termina el bucle
				break;
			
			System.out.print("a? ");
			String sa = scanner.nextLine();
			Integer a = null;
			try {
				a = Integer.parseInt(sa);
			} catch(Exception e) {
				System.out.println(sa + " no es un número entero");
				continue;
			}
			
			System.out.print("b? ");
			String sb = scanner.nextLine();
			Integer b = null;
			try {
				b = Integer.parseInt(sb);
			} catch(Exception e) {
				System.out.println(sb + " no es un número entero");
				continue;
			}
			
			try {
				if (opcion.equals("1"))
					System.out.println(a + " + " + b + " = " + 
							calculadoraService.sumar(a, b));
				else if (opcion.equals("2"))
					System.out.println(a + " - " + b + " = " + 
							calculadoraService.restar(a, b));
				else if (opcion.equals("3"))
					System.out.println(a + " * " + b + " = " + 
							calculadoraService.multiplicar(a, b));
				else if (opcion.equals("4"))
					System.out.println(a + " / " + b + " = " + 
							calculadoraService.dividir(a, b));
			} catch (Exception e) {
				System.out.println("Error al ejecutar la operación indicada " + e);
			}
			
		}

	}
	
	public static void main(String[] args) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		new Principal().iniciar();
		String result = baos.toString();
		if (result.contains("hola no es un número entero"))
			System.err.println("Todo bien!!!");
		else
			System.err.println("Todo mal!!!");
		
	}
}
