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
		assertEquals(5, calculadoraService.sumar(2, 3));
	}
	
	@Test(expected = EnteroInvalidoException.class)
	public void testSumarBordes1() {
		calculadoraService.sumar(-1, 0);
	}
	
	@Test(expected = EnteroInvalidoException.class)
	public void testSumarBordes2() {
		calculadoraService.sumar(0, -23);
	}

	@Test
	public void testSumarResultado() {
		try {
			calculadoraService.sumar(1, Integer.MAX_VALUE);
			fail();
		} catch (EnteroInvalidoException e) { }
	}
}
