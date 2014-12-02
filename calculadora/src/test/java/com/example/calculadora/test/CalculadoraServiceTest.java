package com.example.calculadora.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.example.calculadora.exception.DivisionInvalidaException;
import com.example.calculadora.exception.DivisorInvalidoException;
import com.example.calculadora.exception.EnteroInvalidoException;
import com.example.calculadora.service.CalculadoraService;
import com.example.calculadora.service.CalculadoraServiceImpl;
import com.example.calculadora.test.category.CasosBorde;
import com.example.calculadora.test.category.CasosOrdinarios;

public class CalculadoraServiceTest {
	private CalculadoraService calculadoraService;
	
	public CalculadoraServiceTest() {
		this.calculadoraService = new CalculadoraServiceImpl();
	}

	/****** Pruebas de sumar *******/

	@Test
	@Category(CasosOrdinarios.class)
	public void testSumar() {
		assertEquals(5, calculadoraService.sumar(2, 3));
	}
	
	@Test(expected = EnteroInvalidoException.class)
	@Category(CasosBorde.class)
	public void testSumarBordes1() {
		
		calculadoraService.sumar(-1, 0);
	}
	
	@Test(expected = EnteroInvalidoException.class)
	@Category(CasosBorde.class)
	public void testSumarBordes2() {
		calculadoraService.sumar(0, -23);
	}

	@Test
	@Category(CasosBorde.class)
	public void testSumarResultado() {
		try {
			calculadoraService.sumar(1, Integer.MAX_VALUE);
			fail();
		} catch (EnteroInvalidoException e) { }
	}
	
	/****** Pruebas de restar *******/

	@Category(CasosOrdinarios.class)
	@Test
	public void testRestar() {
		assertEquals(1, calculadoraService.restar(3, 2));
	}
	
	@Test(expected = EnteroInvalidoException.class)
	@Category(CasosBorde.class)
	public void testRestarBordes1() {
		assertEquals(1, calculadoraService.restar(-1, 2));
	}
	
	@Test(expected = EnteroInvalidoException.class)
	@Category(CasosBorde.class)
	public void testRestarBordes2() {
		assertEquals(1, calculadoraService.restar(2, -1));
	}
	
	@Test(expected = EnteroInvalidoException.class)
	@Category(CasosBorde.class)
	public void testRestarResultado() {
		calculadoraService.restar(2, -3);
	}
	
	/****** Pruebas de multiplicar *******/
	
	@Test
	@Category(CasosOrdinarios.class)
	public void testMultiplicar() {
		assertEquals(6, calculadoraService.multiplicar(2, 3));
	}
	
	@Test(expected = EnteroInvalidoException.class)
	@Category(CasosBorde.class)
	public void testMultiplicarBordes1() {
		calculadoraService.multiplicar(-1, 2);
	}
	
	@Test(expected = EnteroInvalidoException.class)
	@Category(CasosBorde.class)
	public void testMultiplicarBordes2() {
		calculadoraService.multiplicar(2, -1);
	}
	
	@Test(expected = EnteroInvalidoException.class)
	@Category(CasosBorde.class)
	public void testMultiplicarResultado() {
		calculadoraService.multiplicar(Integer.MAX_VALUE, 2);
	}
	
	/****** Pruebas de dividir *******/
	
	@Test
	@Category(CasosOrdinarios.class)
	public void testDividir() {
		assertEquals(3, calculadoraService.dividir(6, 2));
	}
	
	@Test(expected = EnteroInvalidoException.class)
	@Category(CasosBorde.class)
	public void testDividirBordes1() {
		calculadoraService.dividir(-1, 2);
	}
	
	@Test(expected = EnteroInvalidoException.class)
	@Category(CasosBorde.class)
	public void testDividirBordes2() {
		calculadoraService.dividir(2, -1);
	}
	
	@Test(expected = DivisorInvalidoException.class)
	@Category(CasosBorde.class)
	public void testDividirBordes3() {
		calculadoraService.dividir(2, 0);
	}

	@Test(expected = DivisionInvalidaException.class)
	@Category(CasosBorde.class)
	public void testDividirResultado() {
		calculadoraService.dividir(3, 2);
	}
	
	
}






