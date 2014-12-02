package com.example.calculadora.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.calculadora.exception.EnteroInvalidoException;
import com.example.calculadora.service.CalculadoraService;
import com.example.calculadora.service.CalculadoraServiceImpl;

public class CalculadoraServiceTest {
	private CalculadoraService calculadoraService;
	
	public CalculadoraServiceTest() {
		this.calculadoraService = new CalculadoraServiceImpl();
	}

	@Test
	public void testSumar() {
		// Verificando que funciona con operaciones normales
		assertEquals(5, calculadoraService.sumar(2, 3));
	}
	
	@Test(expected = EnteroInvalidoException.class)
	public void testSumarBordes1() {
		calculadoraService.sumar(Integer.MAX_VALUE, 1);
	}
	
	@Test
	public void testSumarBordes2() {
		try {
			calculadoraService.sumar(1, Integer.MAX_VALUE);
			fail();
		} catch (EnteroInvalidoException e) { }
	}
}
