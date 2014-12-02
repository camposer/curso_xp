package com.example.calculadora.service;


public abstract class CalculadoraServiceFactory {
	public static CalculadoraService createCalculadoraService() {
		return new CalculadoraServiceImpl();
	}
}
