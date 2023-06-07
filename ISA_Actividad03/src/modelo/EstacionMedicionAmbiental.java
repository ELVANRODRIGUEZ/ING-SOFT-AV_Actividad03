package modelo;

public class EstacionMedicionAmbiental {

	double temperatura;
	double radiacion;
	int estado_mastil;
	int estado_sensor_ultrvioleta;

	public EstacionMedicionAmbiental() {
			
		 temperatura = 0;//Grados celsius -150 a 214		 
		 radiacion = 0.0f;//W/m2
		 estado_mastil = 0; //O NO DESPLEGLADO, 1 DESPLEGADO
		 estado_sensor_ultrvioleta = 0;//O NO OPERATIVO, 1 OPERATIVO
	}
	
	public void desplegarMastil() {
		//Simulamos que se recogen estos valores
		estado_mastil=1;
		estado_sensor_ultrvioleta=1;
		activarSensores();
	}

	public int getEstadoSensorUltra() {
		
		double rndNumber = Math.random();
		
		if (rndNumber < 0.85) {
			
			estado_sensor_ultrvioleta = 1;
			
		}else {
			
			estado_sensor_ultrvioleta = 0;
			
		}

		return estado_sensor_ultrvioleta;

	}

	public int getEstadoMastil() {
		return estado_sensor_ultrvioleta;

	}
	
	public double activarSensores() {
		
		if (temperatura != 0) {
			
			temperatura += (Math.random() - Math.random());
			
		}else {
			
			// Este método simula la activación y lectura de sensores
			temperatura = (-150 + (Math.random() * 364));
			
		}
		
		radiacion = 110; 
		
		return temperatura;

	}

}
