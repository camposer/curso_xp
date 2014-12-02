package com.example.calculadora.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.example.calculadora.test.CalculadoraServiceTest;

@RunWith(Suite.class)
@SuiteClasses(CalculadoraServiceTest.class)
public class CalculadoraServiceSuite {

}
