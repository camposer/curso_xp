package com.example.calculadora.suite;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.example.calculadora.test.CalculadoraServiceTest;
import com.example.calculadora.test.category.CasosBorde;

@RunWith(Categories.class)
@IncludeCategory(CasosBorde.class)
@SuiteClasses(CalculadoraServiceTest.class)
public class CalculadoraServiceCasosBordeSuite {

}
