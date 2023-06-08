package interfaz;

import javax.swing.*;

import modelo.Calculadora;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DecimalFormat;


public class UICalculadora extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// Modelo que manipula la IU
	private Calculadora calculadora;
	
	private JButton btnSuma;
	private JButton btnResta;
	private JButton btnMultiplicacion;	
	private JButton btnDivision;
	private JButton btnRaiz;
	private JButton btnExponencial;
	private JButton btnClear;
	private JButton btnIgual;
	private JTextArea txtInput;
	private JPanel pnlPanel01;
	
	private float valor1;
	private float valor2;
	private String operacion;
	
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
		btnSuma.setFocusable(false);
		btnSuma.setName("btnSuma");
		btnSuma.setBackground(new Color(113, 132, 164));
		btnSuma.setForeground(new Color(255, 255, 255));
		btnSuma.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSuma.setBorder(null);
		btnSuma.setBounds(10, 61, 66, 42);
		
		// Pánel 01- Crear botón resta
		btnResta = new JButton("-");
		btnResta.setFocusable(false);
		btnResta.setName("btnResta");
		btnResta.setBorderPainted(false);
		btnResta.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnResta.setBackground(new Color(113, 132, 164));
		btnResta.setForeground(new Color(255, 255, 255));
		btnResta.setBounds(80, 61, 66, 42);

		// Pánel 01- Crear botón multiplicación
		btnMultiplicacion = new JButton("x");
		btnMultiplicacion.setFocusable(false);
		btnMultiplicacion.setName("btnMultiplicacion");
		btnMultiplicacion.setBorderPainted(false);
		btnMultiplicacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMultiplicacion.setBackground(new Color(113, 132, 164));
		btnMultiplicacion.setForeground(new Color(255, 255, 255));
		btnMultiplicacion.setBounds(10, 106, 66, 42);
		
		// Pánel 01- Crear botón división
		btnDivision = new JButton("/");
		btnDivision.setFocusable(false);
		btnDivision.setName("btnDivision");
		btnDivision.setBorderPainted(false);
		btnDivision.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDivision.setBackground(new Color(113, 132, 164));
		btnDivision.setForeground(new Color(255, 255, 255));
		btnDivision.setBounds(80, 106, 66, 42);
		
		// Pánel 01- Crear botón raíz
		btnRaiz = new JButton("^1/2");
		btnRaiz.setFocusable(false);
		btnRaiz.setName("btnRaiz");
		btnRaiz.setBorderPainted(false);
		btnRaiz.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRaiz.setBackground(new Color(113, 132, 164));
		btnRaiz.setForeground(new Color(255, 255, 255));
		btnRaiz.setBounds(10, 151, 66, 42);
		
		// Pánel 01- Crear botón exponencial
		btnExponencial = new JButton("e^");
		btnExponencial.setFocusable(false);
		btnExponencial.setName("btnExponencial");
		btnExponencial.setBorderPainted(false);
		btnExponencial.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExponencial.setBackground(new Color(113, 132, 164));
		btnExponencial.setForeground(new Color(255, 255, 255));
		btnExponencial.setBounds(80, 151, 66, 42);
		
		// Pánel 01- Crear botón "clear"
		btnClear = new JButton("CE");
		btnClear.setFocusable(false);
		btnClear.setName("btnClear");
		btnClear.setBorderPainted(false);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBackground(new Color(113, 132, 164));
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBounds(150, 61, 71, 42);
		
		// Pánel 01- Crear botón igual
		btnIgual = new JButton("=");
		btnIgual.setFocusable(false);
		btnIgual.setName("btnIgual");
		btnIgual.setBorderPainted(false);
		btnIgual.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIgual.setBackground(new Color(113, 132, 164));
		btnIgual.setForeground(new Color(255, 255, 255));
		btnIgual.setBounds(150, 106, 71, 87);
		
		// Pánel 01- Sensor de Bateria
		txtInput = new JTextArea();
		txtInput.setAlignmentY(Component.TOP_ALIGNMENT);
		txtInput.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtInput.setMargin(new Insets(11, 10, 11, 10));
		txtInput.setBounds(10, 11, 211, 42);
		
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
		pnlPanel01.add(btnClear);
		pnlPanel01.add(btnIgual);
		pnlPanel01.add(txtInput);



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
		btnClear.addActionListener(this);
		
	}

public void actionPerformed(ActionEvent e) {
		
		// Crear e inicializar la variable que guarda el nombre de variable del objeto presionado
		JButton pressedButton = (JButton) e.getSource();
		String pressedButtonName = pressedButton.getName();
		
		String input = "";
		
		// Acciones dependiendo del origen disparador del evento (de cualquiera de los botones)
		switch (pressedButtonName) {

		
		case "btnSuma":
			
			input = txtInput.getText();
			valor1 = Float.parseFloat(input);
			
			operacion = "suma";
			txtInput.setText("");
//			calculadora.suma(valor1,valor2);
			
			break;
		
		case "btnResta":
			
			input = txtInput.getText();
			valor1 = Float.parseFloat(input);
			
			operacion = "resta";
			txtInput.setText("");
			
			break;
			
		case "btnMultiplicacion":
		
			input = txtInput.getText();
			valor1 = Float.parseFloat(input);
			
			operacion = "multiplicacion";
			txtInput.setText("");
		
			break;
			
		case "btnDivision":
		
			input = txtInput.getText();
			valor1 = Float.parseFloat(input);
			
			operacion = "division";
			txtInput.setText("");
		
			break;	
			
		case "btnRaiz":
			
			input = txtInput.getText();
			valor1 = Float.parseFloat(input);
			
			operacion = "raiz";
			calculadora.raiz(valor1);
			
			break;	
			
		case "btnExponencial":
			
			input = txtInput.getText();
			valor1 = Float.parseFloat(input);
			
			operacion = "exponencial";
			calculadora.exponencial(valor1);
			
			break;	
			
			
		case "btnClear":
			
			txtInput.setText("");
			valor1 = 0;
			valor2 = 0;
			
			operacion = "";
			
			break;	
			
			
		case "btnIgual":
			
			input = txtInput.getText();
			valor2 = Float.parseFloat(input);
			
			switch (operacion) {
			
			case "suma":
				
				calculadora.suma(valor1,valor2);
				
				break;
			
			case "resta":
				
				calculadora.resta(valor1,valor2);				
				
				break;
				
			case "multiplicacion":
			
				calculadora.multiplicacion(valor1,valor2);				
			
				break;
				
			case "division":
			
				calculadora.division(valor1,valor2);				
			
				break;	
				
			case "raiz":
				
//				calculadora.raiz(valor2);				
				
				break;	
				
			case "exponencial":
				
//				calculadora.exponencial(valor2);				
				
				break;	
				
			}
			
			valor1 = 0;
			valor2 = 0;
			
			break;	
			
		}

	}
	
	// Muestra el porcentaje de carga de la batería a través de los páneles solares
	// y cambia de color de acuerdo a si se ha rebasado una carga de 50%.
	public void setResultado(Float res) {
		
		DecimalFormat decFormat = new DecimalFormat("#.000");
		
		String resEnPantalla = decFormat.format(res);
		
		txtInput.setText(resEnPantalla);
		
		
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




