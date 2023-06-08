package interfaz;

import javax.swing.*;

import modelo.Calculadora;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DecimalFormat;


public class UICalculadora extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	//modelo asbtracto que manipula la IU
	private Calculadora calculadora;
	
	private JButton btnSuma;
	private JButton btnResta;
	private JButton btnMultiplicacion;	
	private JButton btnDivision;
	private JButton btnRaiz;
	private JButton btnExponencial;
	private JButton btnIgual;
	private JTextArea senBateria;
	private JPanel pnlPanel01;
	// Guarda la noción de que se use el módulo principal o el auxiliar
	public Boolean moduloPrincipal = true;
	
	// Constructor. Convoca inicializarControles() la creación de un objeto de esta clase
	public UICalculadora() {
		
		inicializarControles();
	}
	
	// Método que arranca automáticamente con la instanciación de un objeto de la clase UICalculadora
	private void inicializarControles() {
		
		// CREACIÓN DEL JFRAME O VENTANA PRINCIPAL ************************************************************************
		
		// Configurar el título y el tamaño de la ventana
		setTitle("CALCULADORA");
		// Configurar tamaño
		setBounds(0,0,268, 262);
		// Existencia de un botón de cerrado de ventana que termine ejecución de programa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// Configurar la disposición de elementos de la interfaz gráfica
		getContentPane().setLayout(null);
		
		// COMPONENTES DE LA INTERFAZ GRÁFICA *****************************************************************************
		
		// Pánel principal 01 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
		// Pánel 01- Crear botón suma
		btnSuma = new JButton("+");
		btnSuma.setName("btnSuma");
		btnSuma.setBackground(new Color(113, 132, 164));
		btnSuma.setForeground(new Color(255, 255, 255));
		btnSuma.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSuma.setBorder(null);
		btnSuma.setBounds(10, 61, 66, 42);
		
		// Pánel 01- Crear botón resta
		btnResta = new JButton("-");
		btnResta.setName("btnResta");
		btnResta.setBorderPainted(false);
		btnResta.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnResta.setBackground(new Color(113, 132, 164));
		btnResta.setForeground(new Color(255, 255, 255));
		btnResta.setBounds(80, 61, 66, 42);

		// Pánel 01- Crear botón multiplicación
		btnMultiplicacion = new JButton("x");
		btnMultiplicacion.setName("btnMultiplicacion");
		btnMultiplicacion.setBorderPainted(false);
		btnMultiplicacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMultiplicacion.setBackground(new Color(113, 132, 164));
		btnMultiplicacion.setForeground(new Color(255, 255, 255));
		btnMultiplicacion.setBounds(10, 106, 66, 42);
		
		// Pánel 01- Crear botón división
		btnDivision = new JButton("/");
		btnDivision.setName("btnDivision");
		btnDivision.setBorderPainted(false);
		btnDivision.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDivision.setBackground(new Color(113, 132, 164));
		btnDivision.setForeground(new Color(255, 255, 255));
		btnDivision.setBounds(80, 106, 66, 42);
		
		// Pánel 01- Crear botón raíz
		btnRaiz = new JButton("^1/2");
		btnRaiz.setName("btnRaiz");
		btnRaiz.setBorderPainted(false);
		btnRaiz.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRaiz.setBackground(new Color(113, 132, 164));
		btnRaiz.setForeground(new Color(255, 255, 255));
		btnRaiz.setBounds(10, 151, 66, 42);
		
		// Pánel 01- Crear botón exponencial
		btnExponencial = new JButton("e^");
		btnExponencial.setName("btnExponencial");
		btnExponencial.setBorderPainted(false);
		btnExponencial.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExponencial.setBackground(new Color(113, 132, 164));
		btnExponencial.setForeground(new Color(255, 255, 255));
		btnExponencial.setBounds(80, 151, 66, 42);
		
		// Pánel 01- Crear botón igual
		btnIgual = new JButton("=");
		btnIgual.setName("btnIgual");
		btnIgual.setBorderPainted(false);
		btnIgual.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIgual.setBackground(new Color(113, 132, 164));
		btnIgual.setForeground(new Color(255, 255, 255));
		btnIgual.setBounds(150, 61, 71, 132);
		
		// Pánel 01- Sensor de Bateria
		senBateria = new JTextArea();
		senBateria.setAlignmentY(Component.TOP_ALIGNMENT);
		senBateria.setFont(new Font("Tahoma", Font.BOLD, 14));
		senBateria.setMargin(new Insets(11, 10, 11, 10));
		senBateria.setBounds(10, 11, 211, 42);
		
		// Pánel principal 01
		pnlPanel01 = new JPanel();
		pnlPanel01.setBackground(new Color(0, 0, 0));
		pnlPanel01.setBounds(10, 11, 231, 202);
		pnlPanel01.setLayout(null);

		
		// Insertar elementos en su contenedor correspondiente +++++++++++++++++++++++++++++++++++
		
		// En el Jframe
		getContentPane().add(pnlPanel01);
		
		// En el Pánel 01
		pnlPanel01.add(btnSuma);
		pnlPanel01.add(btnResta);
		pnlPanel01.add(btnMultiplicacion);
		pnlPanel01.add(btnDivision);
		pnlPanel01.add(btnRaiz);
		pnlPanel01.add(btnExponencial);
		pnlPanel01.add(btnIgual);
		pnlPanel01.add(senBateria);



		// Mostrar la ventana
		setVisible(true);
		
		// CREACIÓN DEL MÓDULO LUNAR QUE ESTARÁ CONECTADO CON ESTA INTERFACE **********************************************

		// Instanciamos el modulo lunar y le pasamos la propia refrencia a esta interfaz (enlace bidireccional)
		// Esto es importante porque Módulo lunar tiene que invocar métodos de la interfaz
		calculadora = new Calculadora(this);
		
  
		// EVENTOS A REGISTRAR EN LA INTERFACE ****************************************************************************
		
		// Registrar el manejador de eventos para los 3 diferentes botones
		btnSuma.addActionListener(this);
		btnResta.addActionListener(this);
		btnMultiplicacion.addActionListener(this);
		btnDivision.addActionListener(this);
		btnRaiz.addActionListener(this);
		btnExponencial.addActionListener(this);
		btnIgual.addActionListener(this);
		
//		pnlPanel01.add(lblSensoresUVmat = new DecimalFormat("#.00");
//		
//		String temperatura = decFormat.format(temp);
//		
//		senTemperatura.setText(temperatura + "°");
		
	}


	
	// Muestra el porcentaje de carga de la batería a través de los páneles solares
	// y cambia de color de acuerdo a si se ha rebasado una carga de 50%.
	public void setBateria(Float carga) {
		
		DecimalFormat decFormat = new DecimalFormat("#.00");
		
		String bateria = decFormat.format(carga);
		
		senBateria.setText(bateria + "%");
		
		if (carga < 50) {
			
			senBateria.setBackground(Color.RED);
			
		}else {
			
			senBateria.setBackground(Color.GREEN);
			
		}
		
	}

	// MAIN DE LAL INTERFACE ******************************************************************************************
	
	// Crear y mostrar la interfaz gráfica en el hilo de eventos de Swing
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			
			new UICalculadora();
			
		});
	}
	

//	public void setTemperatura(double temp) {
//		
//		DecimalFormat decFormat = new DecimalFormat("#.00");
//		
//		String temperatura = decFormat.format(temp);
//		
//		senTemperatura.setText(temperatura + "°");
//		senPaneles.setBackground(Color.GREEN);
//		
//	}
	
}




