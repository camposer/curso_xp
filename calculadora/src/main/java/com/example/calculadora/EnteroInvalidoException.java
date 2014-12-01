package com.example.calculadora;

public class EnteroInvalidoException extends RuntimeException {
	private Object valor;
	
	public EnteroInvalidoException(Object valor) {
		this.valor = valor;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}	
}
