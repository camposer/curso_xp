package com.example.calculadora.exception;

public class DivisorInvalidoException extends RuntimeException {
	private static final long serialVersionUID = -1211731080785208666L;
	private int dividendo;
	
	public DivisorInvalidoException(int dividendo) {
		this.dividendo = dividendo;
	}

	public int getDividendo() {
		return dividendo;
	}

	public void setDividendo(int dividendo) {
		this.dividendo = dividendo;
	}
}
