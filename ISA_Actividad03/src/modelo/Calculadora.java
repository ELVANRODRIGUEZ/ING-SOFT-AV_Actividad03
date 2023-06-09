package modelo;

import javax.swing.JButton;

import interfaz.UICalculadora;

public class Calculadora {
	
	private UICalculadora iu;
	private float resultado;

	
	// Constructor. Recibe una interface como parámetro
	public Calculadora(UICalculadora iu) {
		
		this.iu = iu;
		
	}

	
	public void suma(float num1, float num2) {
		
		
		resultado = num1 + num2;
		
		iu.setResultado(resultado, "btnSuma");
		
	}
	
	public void resta(float num1, float num2) {
		
		
		resultado = num1 - num2;
		
		iu.setResultado(resultado, "btnResta");
		
	}
	
	public void multiplicacion(float num1, float num2) {
		
		
		resultado = num1 * num2;
		
		iu.setResultado(resultado, "btnMultiplicacion");
		
	}
	
	public void division(float num1, float num2) {
		
		
		resultado = num1 / num2;
		
		iu.setResultado(resultado, "btnDivision");
		
	}
	
	public void raiz(float num1) {
		
		if (num1 < 0 ) {
			
			iu.setResultado(resultado, "NaN");
			
		}else {
			
			// Método babilónico
			double guess = num1 / 2;
			double error = 1e-3; // Desired precision
	        double squaredError = error * error;
	        double nextGuess = 0;

	        while (true) {
	        	
	            nextGuess = 0.5 * (guess + num1 / guess);
	            if ((nextGuess - guess) * (nextGuess - guess) < squaredError) {
	                break;
	            }
	            guess = nextGuess;
	            
	        };
	        
	        resultado = (float) nextGuess;
			
			iu.setResultado(resultado, "btnRaiz");	
			
		}

		
	}
	
	public void exponencial(float num1) {
		
		float e = (float) 2.718;
		
        if (num1 == 0) {
        	
        	resultado = (float) 1.0; // Anything raised to the power of 0 is 1
        	
        } else if (num1 < 0) {
            // For negative exponents, invert the base and change the exponent sign
            e = 1 / e;
            num1 = -num1;
        }

        double acumulado = 1.0;
        
        for (int i = 0; i < num1; i++) {
        	
        	acumulado *= (double) e;
            
        }

		
		resultado = (float) acumulado;
//		resultado = (float) Math.exp(num1);
		
		iu.setResultado(resultado, "btnExponencial");
		
	}

}
