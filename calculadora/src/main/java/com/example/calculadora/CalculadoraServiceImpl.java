package com.example.calculadora;

public class CalculadoraServiceImpl implements CalculadoraService {
	
	public int sumar(int a, int b) { 
		if (!esNatural(a))
			throw new EnteroInvalidoException(a);
		if (!esNatural(b))
			throw new EnteroInvalidoException(b);
		long c = a + b;
		if (c > Integer.MAX_VALUE)
			throw new EnteroInvalidoException(c);
		
		return (int)c; 
	}
	
	private boolean esNatural(int a) {
		return (a >= 0);
	}

	public int restar(int a, int b) { return a - b; }
	public int multiplicar(int a, int b) { return a * b; }
	public int dividir(int a, int b) { return a / b; }
}

