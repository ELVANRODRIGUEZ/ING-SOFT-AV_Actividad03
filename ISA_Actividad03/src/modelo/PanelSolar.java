package modelo;

public class PanelSolar {
     float carga;
     
	
     public PanelSolar() {
		carga=0.0f;
	}
	public void desplegar() {
		
		carga = (float) (Math.random() * 100);
		
	}
	
	public float getCarga() {
		
		if (carga != 100) {
			
			carga += 0.25;
			
		}
		
		return carga;
		
	}

}
