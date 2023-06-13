package interfaz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import interfaz.UICalculadora;
import modelo.Calculadora;

public class TestsCalculadora {
	
	private final UICalculadora ui = new UICalculadora();
	private float resultado;
	
	private String resPrel;
	
	@Test
    public void testSuma() {
        

    	ui.unClick = false;
    	ui.valor1init = true;
    	ui.valor1 = 5;
    	ui.operacionPendiente = false;
    	ui.txtInput.setText("5");
    			
		ui.operar("btnSuma");	
		
    	resPrel = ui.txtInput.getText();
    	resultado = Float.parseFloat(resPrel);
    	
        Assertions.assertEquals(10.0, resultado);
        
    }

	@Test	
    public void testResta() {
    	
    	ui.unClick = false;
    	ui.valor1init = true;
    	ui.valor1 = 10;
    	ui.operacionPendiente = false;
    	ui.txtInput.setText("5");
    			
		ui.operar("btnResta");	
		
    	resPrel = ui.txtInput.getText();
    	resultado = Float.parseFloat(resPrel);
    	
        Assertions.assertEquals(5.0, resultado);
    	
    }
	
	@Test
    public void testMultipicacion() {
        
    	ui.unClick = false;
    	ui.valor1init = true;
    	ui.valor1 = 5;
    	ui.operacionPendiente = false;
    	ui.txtInput.setText("5");
    			
		ui.operar("btnMultiplicacion");	
		
    	resPrel = ui.txtInput.getText();
    	resultado = Float.parseFloat(resPrel);
    	
        Assertions.assertEquals(25.0, resultado);
        
    }

	@Test
    public void testDivision() {
        
    	ui.unClick = false;
    	ui.valor1init = true;
    	ui.valor1 = 5;
    	ui.operacionPendiente = false;
    	ui.txtInput.setText("5");
    			
		ui.operar("btnDivision");	
		
    	resPrel = ui.txtInput.getText();
    	resultado = Float.parseFloat(resPrel);
    	
        Assertions.assertEquals(1.0, resultado);
        
    }

	@Test
    public void testRaiz() {
        
		ui.txtInput.setText("16");

		ui.operar("btnRaiz");
    	
    	resPrel = ui.txtInput.getText();
    	resultado = Float.parseFloat(resPrel);
    	
    	Assertions.assertEquals(4.000, resultado);
        
    }

	@Test
    public void testExponencial() {
        
		ui.txtInput.setText("2");

		ui.operar("btnExponencial");
    	
    	resPrel = ui.txtInput.getText();
    	resultado = Float.parseFloat(resPrel);
    	
    	Assertions.assertEquals(7.388000011444092, resultado);
        
    }


}
