package com.example.calculadora.exception;

public class DivisionInvalidaException extends RuntimeException {
	private static final long serialVersionUID = 5931840298159194552L;
	private int divisor;
	private int dividendo;
	
	public DivisionInvalidaException(int divisor, int dividendo) {
		this.dividendo = dividendo;
		this.divisor = divisor;
	}

	public int getDivisor() {
		return divisor;
	}

	public void setDivisor(int divisor) {
		this.divisor = divisor;
	}

	public int getDividendo() {
		return dividendo;
	}

	public void setDividendo(int dividendo) {
		this.dividendo = dividendo;
	}
}
