package com.example.calculadora.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.example.calculadora.gui.PrincipalGui;
import com.example.calculadora.service.CalculadoraService;

public class PrincipalGuiTest {
	private PrincipalGui gui;
	private ByteArrayOutputStream baos;

	@Before
	public void before() {
		gui = new PrincipalGui();
		
		// Redirigiendo salida estándar
		baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
	}
	
	@Test
	public void test1() {
		// Pasando datos de entrada
		String input = "1" + System.getProperty("line.separator") + 
				"hola" + System.getProperty("line.separator") + 
				"7";
		ByteArrayInputStream bais = new ByteArrayInputStream(
				input.getBytes());
		Scanner scanner = new Scanner(bais);
		gui.setScanner(scanner);
		
		gui.iniciar(); // Ejecutando 
		
		String actual = baos.toString();
		String expected = "hola no es un número entero";
		Assert.assertTrue(actual.contains(expected));
	}
	
	@Test
	public void test2() {
		// Pasando datos de entrada
		String input = "4" + System.getProperty("line.separator") + 
				"2" + System.getProperty("line.separator") + 
				"0" + System.getProperty("line.separator") + 
				"7";
		ByteArrayInputStream bais = new ByteArrayInputStream(
				input.getBytes());
		Scanner scanner = new Scanner(bais);
		gui.setScanner(scanner);
		
		gui.iniciar(); // Ejecutando 
		
		String actual = baos.toString();
		String expected = "DivisorInvalidoException";
		Assert.assertTrue(actual.contains(expected));
		
	}
	
	@Test
	public void test3() {
		// Inyectando scanner
		String input = "5" + System.getProperty("line.separator") + 
				"2" + System.getProperty("line.separator") + 
				"2" + System.getProperty("line.separator") + 
				"7";
		ByteArrayInputStream bais = new ByteArrayInputStream(
				input.getBytes());
		Scanner scanner = new Scanner(bais);
		gui.setScanner(scanner);
		
		// Inyectando mockup
		CalculadoraService calculadoraService = Mockito.mock(CalculadoraService.class);
		Mockito.when(calculadoraService.potencia(2, 2)).thenReturn(4);
		gui.setCalculadoraService(calculadoraService);
		
		gui.iniciar(); // Ejecutando 
		
		String actual = baos.toString();
		String expected = "2 ^ 2 = 4";
		Assert.assertTrue(actual.contains(expected));
		
	}

	

	@After
	public void after()  {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		gui.setScanner(new Scanner(System.in));
	}
}
