package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import interfaz.IUModuloLunar;

public class ModuloLunar {
	
	// ruta de archivo donde se guardan las rocas reconocidas en la misión
	private String rutaArchivo = "filelunar.txt";
	// lista <clave,valor> donde clave es el tipo de roca y valor su código
	// las asociaciones
	private Map<String, String> mapaHashRocas;
	// enlace con el Modulo de visión
	private ModuloVisionAbstracto mV;	
	private ArrayList<RocaLunar> listaRocas;
	// enlace con el Modulo Lunar
	private IUModuloLunar iu;
	// enlace con Estacion Medio Ambiental
	private EstacionMedicionAmbiental estacionMedicion;
	// enlace con Pánel Solar
	private PanelSolar panel_izq,panel_drch;
	
	// Constructor. Recibe una interface como parámetro
	public ModuloLunar(IUModuloLunar iu) {
		
		this.iu=iu;
				
		iu.setMsgVentanaCtrl("INFO: Inicializando Modulo Visión....");
		mV = new ModuloVision();
		iu.setMsgVentanaCtrl("INFO: Módulo Visión inicializado....");
		
		iu.setMsgVentanaCtrl("INFO: Creando estructura de almacenamiento de rocas lunares detectadas....");
		listaRocas = new ArrayList<RocaLunar>();

		iu.setMsgVentanaCtrl("INFO: Creando mapa de códigos de tipos de roca lunar....");
		mapaHashRocas = new HashMap<String, String>();
		mapaHashRocas.put("basalt", "1");
		mapaHashRocas.put("breccia", "2");
		mapaHashRocas.put("highland", "3");
		mapaHashRocas.put("regolith", "4");
		mapaHashRocas.put("unknown", "5");
		iu.setMsgVentanaCtrl("INFO: Mapa de códigos de tipos de roca lunar creado....");
		
		estacionMedicion = new EstacionMedicionAmbiental();
		estacionMedicion.desplegarMastil();
		iu.setMsgVentanaCtrl("INFO:Estacion de Medición desplegada y opeartiva... ");
		
		panel_izq = new PanelSolar();
		panel_drch = new PanelSolar();
		panel_izq.desplegar();
		panel_drch.desplegar();
		iu.setMsgVentanaCtrl("INFO:Páneles Solares desplegados... ");
		
	}

	public void desarrollarMisionReconocimiento() {	
		
			mV.escanearSuperficie();			
			recuento();			
			mostrarResutados();
	
	}
	
	public void cambiarModuloVisionAuxiliar() {
		
		iu.setMsgVentanaCtrl("INFO: Módulo Visión cambiado escaneando con módulo auxiliar....");
		this.mV= new ModuloVisionAuxiliar();
	}
	
	public void cambiarModuloVisionPrincipal() {
		
		iu.setMsgVentanaCtrl("INFO: Módulo Visión cambiado escaneando con módulo principal....");
		this.mV= new ModuloVision();
	}
	
	public void mostrarCargaPaneles() {
		
		iu.setMsgVentanaCtrl("INFO: Requiriendo carga de páneles...");
		
		float cargaPaneles = (float) ((panel_izq.getCarga() + panel_drch.getCarga())/2);
		
		iu.setBateria(cargaPaneles);
		
	}

	public void mostrarTemperatura() {
		
		iu.setMsgVentanaCtrl("INFO: Requiriendo temperatura...");
		
		iu.setTemperatura(estacionMedicion.activarSensores());
		
	}

	public void mostrarSensoresUV() {
		
		iu.setMsgVentanaCtrl("INFO: Requiriendo estado de Sensores UV...");
		
		iu.setSensoresUV(estacionMedicion.getEstadoSensorUltra());
		
	}

	/**
	 * Método que hace el recuento de cada tipo de roca lunar detectada
	 * 
	 * 
	 */
	private void recuento() {

		File archivo = new File(this.rutaArchivo);
		FileReader fw = null;
		BufferedReader br = null;
		
		try {
			// acumuladores 
			int basalt = 0, brecia = 0, highland = 0, regolith = 0, unkhown = 0;

			fw = new FileReader(archivo);
			br = new BufferedReader(fw);
			String lectura = null;
			
			// leer cada línea del archivo y acumular el número de rocas lunares de cada tipo detectado
			while ((lectura = br.readLine()) != null) {

				if (lectura.equals(mapaHashRocas.get("basalt"))) {
					basalt++;

				} else if (lectura.equals(mapaHashRocas.get("breccia"))) {
					brecia++;

				} else if (lectura.equals(mapaHashRocas.get("highland"))) {
					highland++;

				} else if (lectura.equals(mapaHashRocas.get("regolith"))) {
					regolith++;

				} else if (lectura.equals(mapaHashRocas.get("unkhown"))) {
					unkhown++;

				}
			}

			// Crear un objeto por cada roca lunar reconocida y añadir el número de ellas detectadas
			iu.setMsgVentanaCtrl("INFO: Creando estructura de rocas reconocidas");
			//System.out.println("INFO: Creando estructura de rocas reconocidas");
			RocaLunar r1 = new RocaLunar(1, "basalt");
			r1.setRecuento(basalt);
			listaRocas.add(r1);
			RocaLunar r2 = new RocaLunar(2, "brecia");
			r2.setRecuento(brecia);
			listaRocas.add(r2);
			RocaLunar r3 = new RocaLunar(3, "highland");
			r3.setRecuento(highland);
			listaRocas.add(r3);
			RocaLunar r4 = new RocaLunar(4, "regolith");
			r4.setRecuento(regolith);
			listaRocas.add(r4);
			RocaLunar r5 = new RocaLunar(5, "unkhown");
			r5.setRecuento(unkhown);
			listaRocas.add(r5);
			

		} catch (FileNotFoundException e) {
			iu.setMsgVentanaCtrl("ERROR:archivo no encrontrado");
			System.out.println("ERROR:archivo no encrontrado");
			e.printStackTrace();
			
		} catch (IOException e) {
			iu.setMsgVentanaCtrl("ERROR:lectura de archivo");
			System.out.println("ERROR:lectura de archivo");
			e.printStackTrace();
			
		} finally {

			try {
				br.close();
				fw.close();
			} catch (IOException e) {
				iu.setMsgVentanaCtrl("ERROR:lectura de archivo");
				e.printStackTrace();
			}

		}

	}

	/**
	 * Imprime el resultado del recuento de rocas lunares detectadas en la misión
	 */
	private void mostrarResutados() {

		
		iu.setMsgVentanaMsin(" RESULTADO DE LA MISIÓN DE RECONOCIMIENTO ++++++++++++++++++");
		for (RocaLunar roca : listaRocas) {
			iu.setMsgVentanaMsin(roca.toString());
			
		}

	}

}
