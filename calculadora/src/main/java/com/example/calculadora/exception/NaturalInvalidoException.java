package com.example.calculadora.exception;

public class NaturalInvalidoException extends RuntimeException {
	private static final long serialVersionUID = -1579518490246527848L;
	private Object valor;
	
	public NaturalInvalidoException(Object valor) {
		this.valor = valor;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}	
}
