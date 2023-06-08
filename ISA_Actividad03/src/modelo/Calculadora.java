package modelo;

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
		
		iu.setResultado(resultado);
		
	}
	
	public void resta(float num1, float num2) {
		
		
		resultado = num1 - num2;
		
		iu.setResultado(resultado);
		
	}
	
	public void multiplicacion(float num1, float num2) {
		
		
		resultado = num1 / num2;
		
		iu.setResultado(resultado);
		
	}
	
	public void division(float num1, float num2) {
		
		
		resultado = num1 / num2;
		
		iu.setResultado(resultado);
		
	}
	
	public void raiz(float num1) {
		
		
		resultado = (float) Math.sqrt(num1);
		
		iu.setResultado(resultado);
		
	}
	
	public void exponencial(float num1) {
		
		
		resultado = (float) Math.exp(num1);
		
		iu.setResultado(resultado);
		
	}
	
	

}
