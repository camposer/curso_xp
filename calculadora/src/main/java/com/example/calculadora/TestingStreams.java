package com.example.calculadora;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TestingStreams {
	public static void main(String[] args) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);

		System.out.println("Hola");
		
		String result = baos.toString();
		
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		if (result.contains("Hola"))
			System.out.println("Contiene Hola");
		else
			System.out.println("No contiene Hola");
	}
}
