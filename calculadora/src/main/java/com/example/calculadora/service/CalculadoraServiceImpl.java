package com.example.calculadora.service;

import com.example.calculadora.exception.DivisorInvalidoException;
import com.example.calculadora.exception.DivisionInvalidaException;
import com.example.calculadora.exception.NaturalInvalidoException;

class CalculadoraServiceImpl implements CalculadoraService {
	
	public int sumar(int a, int b) { 
		if (!esNatural(a))
			throw new NaturalInvalidoException(a);
		if (!esNatural(b))
			throw new NaturalInvalidoException(b);
		long c = (long)a + b;
		if (c > Integer.MAX_VALUE)
			throw new NaturalInvalidoException(c);
		
		return (int)c; 
	}
	
	private boolean esNatural(int a) {
		return (a >= 0);
	}

	public int restar(int a, int b) { 
		if (!esNatural(a))
			throw new NaturalInvalidoException(a);
		if (!esNatural(b))
			throw new NaturalInvalidoException(b);
		int c = a - b;
		if (c < 0)
			throw new NaturalInvalidoException(c);
		
		return c; 
	}
	
	public int multiplicar(int a, int b) {
		if (!esNatural(a))
			throw new NaturalInvalidoException(a);
		if (!esNatural(b))
			throw new NaturalInvalidoException(b);
		long c = (long)a * b;
		if (c > Integer.MAX_VALUE)
			throw new NaturalInvalidoException(c);
		
		return (int)c; 
	}
	
	public int dividir(int a, int b) { 
		if (!esNatural(a))
			throw new NaturalInvalidoException(a);
		if (!esNatural(b))
			throw new NaturalInvalidoException(b);
		if (b == 0)
			throw new DivisorInvalidoException(b);
		if (a % b != 0)
			throw new DivisionInvalidaException(a, b);
		
		return a / b; 
	}

	public int potencia(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int raiz(int a) {
		// TODO Auto-generated method stub
		return 0;
	}
}

