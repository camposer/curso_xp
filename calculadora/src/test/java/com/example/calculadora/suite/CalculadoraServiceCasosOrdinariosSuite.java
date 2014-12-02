package com.example.calculadora.suite;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.example.calculadora.test.CalculadoraServiceTest;
import com.example.calculadora.test.category.CasosOrdinarios;

@RunWith(Categories.class)
@IncludeCategory(CasosOrdinarios.class)
@SuiteClasses(CalculadoraServiceTest.class)
public class CalculadoraServiceCasosOrdinariosSuite {

}
