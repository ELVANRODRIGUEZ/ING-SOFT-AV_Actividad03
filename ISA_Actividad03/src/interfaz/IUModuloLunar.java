package interfaz;

import javax.swing.*;

import modelo.ModuloLunar;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.text.DecimalFormat;

/**
 * IUModuloLunar representa una interfaz gráfica de usuario para el módulo Lunar
 * @author 
 *
 */

public class IUModuloLunar extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	//modelo asbtracto que manipula la IU
	private ModuloLunar moduloLunar;
	
	// Controles gráficos de la IU
	private JTextArea txtInfoControl;
	private JTextArea txtInfoMision;
	private JButton btnInicioMision;	
	private JButton btnVerInstrumentacion;
	private JRadioButton rdbArranqueAlterno;
	private JLabel moonLabel;
	private JPanel pnlPanel01;
	private JPanel pnlPanel02;
	private ImageIcon moonImage;
	private JTextField lblInfoControl;
	private JTextField lblInfoMision;
	private JTextField lblPaneles;
	private JTextField lblTemperatura;
	private JTextField lblSensoresUV;
	private JTextField lblBateria;
	private JTextArea senPaneles;
	private JTextArea senTemperatura;
	private JTextArea senBateria;
	private JTextArea senSenUV;
	private JScrollPane scrInfoControl;
	private JScrollPane scrInfoMision;
	
	// Guarda la noción de que se use el módulo principal o el auxiliar
	public Boolean moduloPrincipal = true;
	
	// Constructor. Convoca inicializarControles() la creación de un objeto de esta clase
	public IUModuloLunar() {
		
		inicializarControles();
	}
	
	// Método que arranca automáticamente con la instanciación de un objeto de la clase UIModuloLunar
	private void inicializarControles() {
		
		// CREACIÓN DEL JFRAME O VENTANA PRINCIPAL ************************************************************************
		
		// Configurar el título y el tamaño de la ventana
		setTitle("MÓDULO LUNAR");
		// Configurar tamaño
		setBounds(0,0,960, 540);
		// Existencia de un botón de cerrado de ventana que termine ejecución de programa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		// Configurar la disposición de elementos de la interfaz gráfica
		getContentPane().setLayout(null);

		
		// COMPONENTES DE LA INTERFAZ GRÁFICA *****************************************************************************
		
		// Pánel principal 01 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// Pánel 01- Crear imagen de la luna
		String imgLocation = "MoonGif.gif";
		moonImage = new ImageIcon(imgLocation);
		moonLabel = new JLabel(moonImage);
		moonLabel.setSize(224, 185);
		moonLabel.setLocation(277, 24);
		
	
		// Pánel 01- Crear botón para ver instrumentación
		btnVerInstrumentacion = new JButton("Estado Instrumentación");
		btnVerInstrumentacion.setName("btnVerInstrumentacion");
		btnVerInstrumentacion.setBackground(new Color(0, 128, 192));
		btnVerInstrumentacion.setForeground(new Color(255, 255, 255));
		btnVerInstrumentacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVerInstrumentacion.setBorder(null);
		btnVerInstrumentacion.setBounds(10, 24, 198, 41);
		
		// Pánel 01- Sensor de Páneles
		senPaneles = new JTextArea();
		senPaneles.setAlignmentY(0.0f);
		senPaneles.setEditable(false);
		senPaneles.setFont(new Font("Monospaced", Font.PLAIN, 9));
		senPaneles.setBounds(637, 24, 46, 27);
		
		// Pánel 01- Sensor de Temperatura
		senTemperatura = new JTextArea();
		senTemperatura.setAlignmentY(0.0f);
		senTemperatura.setEditable(false);
		senTemperatura.setFont(new Font("Monospaced", Font.PLAIN, 9));
		senTemperatura.setBounds(637, 75, 46, 27);
		
		// Pánel 01- Sensor de Sensores UV
		senSenUV = new JTextArea();
		senSenUV.setAlignmentY(0.0f);
		senSenUV.setEditable(false);
		senSenUV.setFont(new Font("Monospaced", Font.PLAIN, 9));
		senSenUV.setBounds(637, 131, 46, 27);
		
		// Pánel 01- Sensor de Bateria
		senBateria = new JTextArea();
		senBateria.setAlignmentY(0.0f);
		senBateria.setEditable(false);
		senBateria.setFont(new Font("Monospaced", Font.PLAIN, 9));
		senBateria.setBounds(637, 182, 46, 27);
		
		// Pánel 01- Etiqueta de Páneles
		lblPaneles = new JTextField();
		lblPaneles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPaneles.setText("Páneles");
		lblPaneles.setBorder(null);
		lblPaneles.setBackground(new Color(0, 0, 0));
		lblPaneles.setForeground(new Color(255, 255, 255));
		lblPaneles.setBounds(724, 31, 190, 20);
		lblPaneles.setColumns(10);
		
		// Pánel 01- Etiqueta de Temperatura
		lblTemperatura = new JTextField();
		lblTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTemperatura.setText("Temperatura");
		lblTemperatura.setBorder(null);
		lblTemperatura.setBackground(new Color(0, 0, 0));
		lblTemperatura.setForeground(new Color(255, 255, 255));
		lblTemperatura.setBounds(724, 82, 190, 20);
		lblTemperatura.setColumns(10);
		
		// Pánel 01- Etiqueta de Sensores UV
		lblSensoresUV = new JTextField();
		lblSensoresUV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSensoresUV.setText("Sensores UV");
		lblSensoresUV.setBorder(null);
		lblSensoresUV.setBackground(new Color(0, 0, 0));
		lblSensoresUV.setForeground(new Color(255, 255, 255));
		lblSensoresUV.setBounds(724, 133, 190, 20);
		lblSensoresUV.setColumns(10);
		
		// Pánel 01- Etiqueta de Bateria
		lblBateria = new JTextField();
		lblBateria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBateria.setText("Batería");
		lblBateria.setBorder(null);
		lblBateria.setBackground(new Color(0, 0, 0));
		lblBateria.setForeground(new Color(255, 255, 255));
		lblBateria.setBounds(724, 184, 190, 20);
		lblBateria.setColumns(10);
		
		// Pánel principal 01
		pnlPanel01 = new JPanel();
		pnlPanel01.setBackground(new Color(0, 0, 0));
		pnlPanel01.setBounds(10, 11, 924, 235);
		pnlPanel01.setLayout(null);

		
		// Pánel principal 02 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 

		// Pánel 02- Crear botón de inicio de misión
		btnInicioMision = new JButton("Activar Módulo Auxiliar");
		btnInicioMision.setName("btnInicioMision");
		btnInicioMision.setBorderPainted(false);
		btnInicioMision.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnInicioMision.setBackground(new Color(0, 128, 64));
		btnInicioMision.setForeground(new Color(255, 255, 255));
		btnInicioMision.setBounds(10, 40, 198, 41);
		
		// Pánel 02- Radio botón de activación de Módulo Auxiliar
		rdbArranqueAlterno = new JRadioButton("Activar Módulo Lunar Auxiliar");
		rdbArranqueAlterno.setName("rdbArranqueAlterno");
		rdbArranqueAlterno.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbArranqueAlterno.setBackground(new Color(255, 255, 255));
		rdbArranqueAlterno.setBorder(null);
		rdbArranqueAlterno.setBounds(28, 101, 163, 23);
		
		// Pánel 02- Etiqueta área de control
		lblInfoControl = new JTextField();
		lblInfoControl.setBorder(null);
		lblInfoControl.setOpaque(false);
		lblInfoControl.setText("Información de control");
		lblInfoControl.setBounds(218, 18, 339, 20);
		lblInfoControl.setColumns(10);		


		// Pánel 02- Etiqueta área de misión.
		lblInfoMision = new JTextField();
		lblInfoMision.setText("Información de misión");
		lblInfoMision.setBorder(null);
		lblInfoMision.setBounds(567, 18, 339, 20);
		lblInfoMision.setColumns(10);
				
		// Pánel 02- Crear scrollbar de área de información de control
		scrInfoControl = new JScrollPane();
		scrInfoControl.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrInfoControl.setAutoscrolls(true);
		scrInfoControl.setViewportBorder(null);
		scrInfoControl.setBorder(null);
		scrInfoControl.setBounds(218, 40, 339, 172);
		scrInfoControl.getVerticalScrollBar().setValue(0);
		
		// Pánel 02- Crear área de información de control de misión
		txtInfoControl = new JTextArea(50, 50);
		txtInfoControl.setEditable(false);
		txtInfoControl.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtInfoControl.setForeground(new Color(34, 139, 34));
		txtInfoControl.setBackground(new Color(0, 0, 0));
		txtInfoControl.setMargin(new Insets(10, 10, 10, 10));
		txtInfoControl.setLineWrap(true);
		txtInfoControl.setWrapStyleWord(true);
		
		
		// Pánel 02- Crear scrollbar de área de información de misión
		scrInfoMision = new JScrollPane();
		scrInfoMision.setRequestFocusEnabled(false);
		scrInfoMision.setFocusTraversalKeysEnabled(false);
		scrInfoMision.setAutoscrolls(true);
		scrInfoMision.setViewportBorder(null);
		scrInfoMision.setBorder(null);
		scrInfoMision.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrInfoMision.setBounds(567, 40, 339, 172);
		scrInfoMision.getVerticalScrollBar().setValue(0);
		
		// Pánel 02- Crear área de información de misión
		txtInfoMision = new JTextArea(50, 50);
		txtInfoMision.setEditable(false);
		txtInfoMision.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtInfoMision.setForeground(new Color(0, 0, 0));
		txtInfoMision.setBackground(new Color(192, 192, 192));
		txtInfoMision.setMargin(new Insets(10, 10, 10, 10));
		txtInfoMision.setLineWrap(true);
		txtInfoMision.setWrapStyleWord(true);

		// Pánel principal 02
		pnlPanel02 = new JPanel();
		pnlPanel02.setBackground(new Color(255, 255, 255));
		pnlPanel02.setBounds(10, 255, 924, 235);
		pnlPanel02.setLayout(null);
		
		
		// Insertar elementos en su contenedor correspondiente +++++++++++++++++++++++++++++++++++
		
		// En el Jframe
		getContentPane().add(pnlPanel01);
		getContentPane().add(pnlPanel02);
		
		// En el Pánel 01
		pnlPanel01.add(moonLabel);
		pnlPanel01.add(btnVerInstrumentacion);
		
		pnlPanel01.add(senPaneles);
		pnlPanel01.add(senTemperatura);
		pnlPanel01.add(senSenUV);
		pnlPanel01.add(senBateria);
		
		pnlPanel01.add(lblPaneles);
		pnlPanel01.add(lblTemperatura);
		pnlPanel01.add(lblSensoresUV);
		pnlPanel01.add(lblBateria);

		
		// En el Pánel 02
		pnlPanel02.add(btnInicioMision);
		pnlPanel02.add(rdbArranqueAlterno);
		pnlPanel02.add(lblInfoControl);
		pnlPanel02.add(lblInfoMision);
		pnlPanel02.add(scrInfoControl);
		pnlPanel02.add(scrInfoMision);
		
		// Envolver las áreas de información en pánel tipo scroll bars
		scrInfoControl.setViewportView(txtInfoControl);
		scrInfoMision.setViewportView(txtInfoMision);
		
		// Mostrar la ventana
		setVisible(true);
		
		// CREACIÓN DEL MÓDULO LUNAR QUE ESTARÁ CONECTADO CON ESTA INTERFACE **********************************************

		// Instanciamos el modulo lunar y le pasamos la propia refrencia a esta interfaz (enlace bidireccional)
		// Esto es importante porque Módulo lunar tiene que invocar métodos de la interfaz
		moduloLunar = new ModuloLunar(this);
		
  
		// EVENTOS A REGISTRAR EN LA INTERFACE ****************************************************************************
		
		// Registrar el manejador de eventos para los 3 diferentes botones
		btnVerInstrumentacion.addActionListener(this);
		btnInicioMision.addActionListener(this);
		rdbArranqueAlterno.addActionListener(this);	
		
	}

	
	// GESTOR DE EVENTOS **********************************************************************************************
	
	public void actionPerformed(ActionEvent e) {
		
		// Crear e inicializar la variable que guarda el nombre de variable del objeto presionado
		
//NOTA: Aún no logro entender por qué debe estar inicializada esta variable. Quizá porque su definición
		// está enmarcada dentro de una sentencia "if", y el compilador no puede asegurarse que vaya a 
		// estar disponible a partir de ahí.
		String pressedButtonName = "";
		
		// Variable para validar el estado del botón radial.
		Boolean radButtonEstatus = false;
		
		// Validación diferenciada de si el evento se disparó por presionar cualquiera de los dos botones
		// o el botón radial.
		if (e.getSource() instanceof JButton) {
			
			JButton pressedButton = (JButton) e.getSource();
			pressedButtonName = pressedButton.getName();
			
			
		}else if (e.getSource() instanceof JRadioButton) {
			
			JRadioButton pressedButton = (JRadioButton) e.getSource();
			pressedButtonName = pressedButton.getName();
			radButtonEstatus = pressedButton.isSelected();
			
		};
		
		// Acciones dependiendo del origen disparador del evento (de cualquiera de los 3 botones)
		switch (pressedButtonName) {
		
		case "btnInicioMision":
			
			// Si el botón radial no está seleccionado, se inicializa la misión con módulo principal
			if (moduloPrincipal == true) {
				
				// Funciones dentro de la clase ModuloLunar. Se cambia a Módulo lunar principal y 
				// se ejecuta el reconocimiento de rocas.
				moduloLunar.cambiarModuloVisionPrincipal();
				moduloLunar.desarrollarMisionReconocimiento();
				
			// Si el botón radial está seleccionado, se inicializa la misión con módulo auxiliar
			}else {
				
				// Funciones dentro de la clase ModuloLunar. Se cambia a Módulo lunar auxiliar y 
				// se ejecuta el reconocimiento de rocas.
				moduloLunar.cambiarModuloVisionAuxiliar();
				moduloLunar.desarrollarMisionReconocimiento();
				
			};
			
			
			break;
		
		case "btnVerInstrumentacion":
			
			// Funciones dentro de la clase ModuloLunar que permiten genera
			// la información que será mostrada en la interface
			moduloLunar.mostrarCargaPaneles();
			moduloLunar.mostrarTemperatura();
			moduloLunar.mostrarSensoresUV();
			
			break;
			
		case "rdbArranqueAlterno":
		
			if (radButtonEstatus == true) {
				
				// Funciones dentro de esta clase para visualizar información en pantalla
				// de interface en área de información de control.
				this.setMsgVentanaCtrl("++++++++++++++ADVERTENCIA++++++++++++++");
				this.setMsgVentanaCtrl("+++SE USARÁ MÓDULO DE VISIÓN AUXILIAR++");
				
				// Actualización del estado para usar Módulo Lunar auxiliar
				moduloPrincipal = false;
				
			}else {
				
				// Funciones dentro de esta clase para visualizar información en pantalla
				// de interface en área de información de control.
				this.setMsgVentanaCtrl("++++++++++++++ADVERTENCIA++++++++++++++");
				this.setMsgVentanaCtrl("++SE USARÁ MÓDULO DE VISIÓN PRINCIPAL++");
				
				// Actualización del estado para usar Módulo Lunar principal
				moduloPrincipal = true;
			
		};
		
		
		}

	}

	
	// FUNCIONES DE LA INTERFACE **************************************************************************************
	
	// Publica mensajes en la pantalla de información de control de la interface del módulo lunar
	public void setMsgVentanaCtrl(String msg) {
		
		String newline = "\n";
		txtInfoControl.append(msg + newline);
		
	}

	// Publica mensajes en la pantalla de información de misión de la interface del módulo lunar
	public void setMsgVentanaMsin(String msg) {
		
		String newline = "\n";
		txtInfoMision.append(msg + newline);
		
	}
	
	// Muestra la temperatura en el componente correspondiente. La temperatura viene de un objeto
	// de clase ModuloLunar
	public void setTemperatura(double temp) {
		
		DecimalFormat decFormat = new DecimalFormat("#.00");
		
		String temperatura = decFormat.format(temp);
		
		senTemperatura.setText(temperatura + "°");
		senPaneles.setBackground(Color.GREEN);
		
	}

	// Cambia el color del componente correspondiete de acuerdo a si los sensores UV se 
	// han desplegado exitosamente.
	public void setSensoresUV(int es) {
		
		if (es == 0) {
			
			senSenUV.setBackground(Color.RED);
			
		}else {
			
			senSenUV.setBackground(Color.GREEN);
			
		}

		
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
			
			new IUModuloLunar();
			
		});
	}
}




