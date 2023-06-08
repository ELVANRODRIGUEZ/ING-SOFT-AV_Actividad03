package tdd_Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsCalculadora {
	
	private final Calculadora calc = new Calculadora();
	private double resultado;
	
    public void testSuma() {
        
    	resultado = calc.suma(5.0, 5.0);
        Assertions.assertEquals(10.0, resultado);
        
    }

    public void testResta() {
    	
    	resultado = calc.resta(5.0, 5.0);
    	Assertions.assertEquals(0.0, resultado);
    	
    }

    public void testMultipicacion() {
        
    	resultado = calc.multiplicacion(5.0, 5.0);
        Assertions.assertEquals(25.0, resultado);
        
    }


    public void testDivision() {
        
    	resultado = calc.division(10.0, 5.0);
        Assertions.assertEquals(2.0, resultado);
        
    }

    public void testRaiz() {
        
    	resultado = calc.raiz(25.0);
        Assertions.assertEquals(5.0, resultado);
        
    }

    public void testExponencial() {
        
    	resultado = calc.exponencial(5);
        Assertions.assertEquals(148.413, resultado);
        
    }

}
