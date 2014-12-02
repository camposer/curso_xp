package com.example.calculadora.exception;

public class DividendoInvalidoException extends RuntimeException {
	private static final long serialVersionUID = -1211731080785208666L;
	private int dividendo;
	
	public DividendoInvalidoException(int dividendo) {
		this.dividendo = dividendo;
	}

	public int getDividendo() {
		return dividendo;
	}

	public void setDividendo(int dividendo) {
		this.dividendo = dividendo;
	}
}
