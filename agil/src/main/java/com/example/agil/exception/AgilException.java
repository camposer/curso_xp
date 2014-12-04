package com.example.agil.exception;

public class AgilException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AgilException(Throwable e) {
		super(e);
	}
}
