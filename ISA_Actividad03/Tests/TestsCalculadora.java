package tdd_Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsCalculadora {
	
	private final Calculator calculator = new Calculator();
	private double resultado;
	
    public void testSuma() {
        
    	resultado = calculator.suma(5.0, 5.0);
        Assertions.assertEquals(10.0, resultado);
        
    }

    public void testResta() {
    	
    	resultado = calculator.resta(5.0, 5.0);
    	Assertions.assertEquals(0.0, resultado);
    	
    }

    public void testMultipicacion() {
        
    	resultado = calculator.multiply(5.0, 5.0);
        Assertions.assertEquals(25.0, resultado);
        
    }


    public void testDivision() {
        
    	resultado = calculator.divide(10.0, 5.0);
        Assertions.assertEquals(2.0, resultado);
        
    }

    public void testRaiz() {
        
    	resultado = calculator.squareRoot(25.0);
        Assertions.assertEquals(5.0, resultado);
        
    }

    public void testExponencial() {
        
    	resultado = calculator.exponential(5);
        Assertions.assertEquals(148.413, resultado);
        
    }

}
