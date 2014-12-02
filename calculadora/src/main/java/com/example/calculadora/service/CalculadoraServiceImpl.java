package com.example.calculadora.service;

import com.example.calculadora.exception.DividendoInvalidoException;
import com.example.calculadora.exception.DivisionInvalidaException;
import com.example.calculadora.exception.EnteroInvalidoException;

public class CalculadoraServiceImpl implements CalculadoraService {
	
	public int sumar(int a, int b) { 
		if (!esNatural(a))
			throw new EnteroInvalidoException(a);
		if (!esNatural(b))
			throw new EnteroInvalidoException(b);
		long c = (long)a + b;
		if (c > Integer.MAX_VALUE)
			throw new EnteroInvalidoException(c);
		
		return (int)c; 
	}
	
	private boolean esNatural(int a) {
		return (a >= 0);
	}

	public int restar(int a, int b) { 
		if (!esNatural(a))
			throw new EnteroInvalidoException(a);
		if (!esNatural(b))
			throw new EnteroInvalidoException(b);
		int c = a - b;
		if (c < 0)
			throw new EnteroInvalidoException(c);
		
		return c; 
	}
	
	public int multiplicar(int a, int b) {
		if (!esNatural(a))
			throw new EnteroInvalidoException(a);
		if (!esNatural(b))
			throw new EnteroInvalidoException(b);
		long c = (long)a * b;
		if (c > Integer.MAX_VALUE)
			throw new EnteroInvalidoException(c);
		
		return (int)c; 
	}
	
	public int dividir(int a, int b) { 
		if (!esNatural(a))
			throw new EnteroInvalidoException(a);
		if (!esNatural(b))
			throw new EnteroInvalidoException(b);
		if (b == 0)
			throw new DividendoInvalidoException(b);
		if (a % b != 0)
			throw new DivisionInvalidaException(a, b);
		
		return a / b; 
	}
}

