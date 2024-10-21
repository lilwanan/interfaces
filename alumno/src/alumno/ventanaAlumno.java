package alumno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.AbstractListModel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ventanaAlumno extends JFrame implements ActionListener{ // implementa action listener general para toda la clase

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtinsertanombre;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup(); // crea el grupo de botones 
	private JButton btnHabilitar;
	private JCheckBox chckbxusuario;
	private JButton btnNewButton;
	private ButtonGroup chkGroup = new ButtonGroup(); // crea el grupo para los checkbox
	private JButton btnAdios;
	private JButton btnHola;
	private JTextArea txtAreacom;
	private JList list;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnBorrar;
	private JTextField txtAgregar;
	private DefaultListModel modelo; // crea el array dentro de la lista

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaAlumno frame = new ventanaAlumno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventanaAlumno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ventana Principal"); // establece un nombre a la ventana principal
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/evento-virtual.png")).getImage()); // introduce una imagen al titulo ( el getClass referencia a SRC)
		setBounds(100, 100, 902, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize(); // con esto para ajustar la dimension de la pantalla
		int height = pantalla.height; // pasa el alto de la pantalla
		int width = pantalla.width; // pasa el ancho de la pantalla
		setDefaultCloseOperation(EXIT_ON_CLOSE); // al darle a la x de la esquina
		setResizable(false); // no puede redimensionar la pantalla
		setSize(width/2,height/2); // ocupa la mitad de la pantalla
		setLocationRelativeTo(null); // para dejarla en el medio
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setBounds(23, 11, 46, 14);
		contentPane.add(lblnombre);
		
		txtinsertanombre = new JTextField();
		txtinsertanombre.setToolTipText("Introduce el nombre");
		txtinsertanombre.setBounds(10, 36, 86, 20);
		contentPane.add(txtinsertanombre);
		txtinsertanombre.setColumns(10);
		
		JComboBox cbgrado = new JComboBox();
		cbgrado.setModel(new DefaultComboBoxModel(new String[] {"DAM", "DAW", "ASIR"})); // carga un modelo de datos en un array de string
		cbgrado.setSelectedIndex(2); // selecciona de manera default el indice del array 2
		cbgrado.setBounds(10, 95, 86, 22);
		contentPane.add(cbgrado);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(this); // le pasamos el metodo creado
		
		btnNewButton.setBounds(10, 128, 89, 23);
		contentPane.add(btnNewButton);
		
		chckbxusuario = new JCheckBox("Usuario Seleccionado");
		chckbxusuario.setBounds(-1, 158, 127, 23);
		contentPane.add(chckbxusuario);
		
		JRadioButton rdbtnaprob = new JRadioButton("Aprobado");
		buttonGroup.add(rdbtnaprob); // añade al grupo el radio buton aprobado
		rdbtnaprob.setBounds(10, 184, 109, 23);
		contentPane.add(rdbtnaprob);
		
		JRadioButton rdbtnsus = new JRadioButton("Suspenso");
		buttonGroup.add(rdbtnsus); // añade al grupo el radio buton suspenso
		rdbtnsus.setBounds(10, 210, 109, 23);
		contentPane.add(rdbtnsus);
		
		JCheckBox chckbxaccdat = new JCheckBox("Acceso a Datos");
		chckbxaccdat.setBounds(10, 267, 116, 23);
		chkGroup.add(chckbxaccdat);
		contentPane.add(chckbxaccdat);
		
		JCheckBox chckbxproc = new JCheckBox("Procesos");
		chckbxproc.setBounds(10, 293, 116, 23);
		contentPane.add(chckbxproc);
		
		JCheckBox chckbxdesint = new JCheckBox("Desarrollo Interfaces");
		chckbxdesint.setBounds(10, 319, 136, 23);
		chkGroup.add(chckbxdesint);
		contentPane.add(chckbxdesint);
		
		txtAreacom = new JTextArea();
		txtAreacom.setBounds(382, 11, 324, 216);
		txtAreacom.setBorder(new LineBorder(new Color(255,0,0))); // crea un borde con una nueva linea del borde con un color nuevo que es el rojo
		contentPane.add(txtAreacom); // el scroll pane se crea despues del text area
		JScrollPane scroll = new JScrollPane(txtAreacom); // crea un scroll y se le asocia o crea al textarea
		scroll.setBounds(382,11,324,216); // establece los valores del scroll que son los mismos que lo del text area para que tenga logica
		contentPane.add(scroll); // añade al pane el scroll
		
		textField_1 = new JTextField();
		textField_1.setBounds(490, 330, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // la forma en la que selecciona los elementos
		modelo = new DefaultListModel(); // crea el modelo en el que vamos a crear la lista
		list.setBounds(480, 361, 109, 105);
		contentPane.add(list);
		JScrollPane scroll2 = new JScrollPane(list);
		scroll2.setBounds(480,361,109,105);
		contentPane.add(scroll2);
		modelo.addElement("Empresa 1"); // añade elementos al modelo
		modelo.addElement("Empresa 2");
		modelo.addElement("Empresa 3");
		modelo.addElement("Empresa 4");
		modelo.addElement("Empresa 5");
		
		list.setModel(modelo); // le añade el modelo que hemos establecido a la lista
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(40);
		progressBar.setBounds(232, 361, 146, 14);
		contentPane.add(progressBar);
		
		btnHabilitar = new JButton("Habilitar"); // si lo defines arriba en atributos se puede quitar la primera definicion
		buttonGroup.add(btnHabilitar);
		btnHabilitar.addActionListener(this); // le pasamos el this para implementar el metodo general de la clase
		btnHabilitar.setBounds(124, 128, 89, 23);
		btnHabilitar.setVisible(false); // deshabilita el boton
		contentPane.add(btnHabilitar);
		
		JLabel lblNewLabel = new JLabel("Ciclo que está cursando");
		lblNewLabel.setBounds(10, 67, 136, 14);
		contentPane.add(lblNewLabel);
		
		btnHola = new JButton("buscar hola");
		btnHola.setBounds(394, 249, 89, 23);
		btnHola.addActionListener(this); // añade el action con el metodo
		contentPane.add(btnHola);
		
		btnAdios = new JButton("buscar adios");
		btnAdios.setBounds(580, 249, 109, 23);
		btnAdios.addActionListener(this); // añade el action listener con el metodo
		contentPane.add(btnAdios);
		
		btnAgregar = new JButton("agregar");
		btnAgregar.setBounds(599, 370, 89, 23);
		btnAgregar.addActionListener(this);
		contentPane.add(btnAgregar);
		
		btnEliminar = new JButton("eliminar");
		btnEliminar.setBounds(599, 404, 89, 23);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		btnBorrar = new JButton("borrar");
		btnBorrar.setBounds(600, 438, 89, 23);
		btnBorrar.addActionListener(this);
		contentPane.add(btnBorrar);
		
		txtAgregar = new JTextField();
		txtAgregar.setBounds(603, 339, 86, 20);
		contentPane.add(txtAgregar);
		txtAgregar.setColumns(10);
		
	}
	
	private void validar_usuario(String nombre_usuario) {
		Pattern patron_nombre_usuario = Pattern.compile("[a-zA-Z ]{2}"); // comprueba el patron si es minuscula, mayuscula o tiene un espacio y el 2 son los caracteres minimos
		Matcher mat = patron_nombre_usuario.matcher(nombre_usuario); // compara lo que has introducido en nombre de usuario con el patron anterior
		if(mat.find()) { 
			JOptionPane.showMessageDialog(chckbxusuario, "El usuario ha sido encontrado"); // muestra un mensaje en la posicion del primer argumento y en el segundo un mensaje
			btnHabilitar.setVisible(true); // pone el boton habilitar visible
			chckbxusuario.setSelected(true); // y marca como seleccionado
			chckbxusuario.setEnabled(false); // desahibilita checkbox
			btnNewButton.setVisible(false); // oculta boton buscar
			txtinsertanombre.setEnabled(false); // desactiva busqueda
		} else {
			JOptionPane.showMessageDialog(chckbxusuario, "El usuario no es correcto"); // muestra un mensaje en la posicion del primer argumento y en el segundo un mensaje
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) { // crea un metodo para un action performed general
		String texto = txtAreacom.getText(); // le pasas el contenido del texto
		// TODO Auto-generated method stub
		if (e.getSource()== btnNewButton) { // coge el source del boton buscar
			if(txtinsertanombre.getText().isEmpty()) { // mira si el boton esta vacio
				JOptionPane.showMessageDialog(chckbxusuario, "Usuario Incorrecto"); // muestra un mensaje en la posicion del primer argumento y en el segundo un mensaje
				
			} else {
				String nombre_usuario = txtinsertanombre.getText(); // coge el texto  del usuario introducido
				validar_usuario(nombre_usuario); // comprueba el metodo validar usuario con el nombre introducido
				
			}
			
			
		}
		
		else if (e.getSource()== btnHabilitar){ // coge el source del boton habilitar
			btnHabilitar.setVisible(false); // oculta habilitar
			chckbxusuario.setSelected(false); // deselecciona checkbox
			chckbxusuario.setEnabled(true); // activa checkbox previamente desactivada
			btnNewButton.setVisible(true); // boton buscar visible
			txtinsertanombre.setEnabled(true); // habilita buscador o inserta nombre
			txtinsertanombre.setText(""); // borra el texto edittext y
			
		}
		
		else if(e.getSource()== btnHola) { //coge el source del boton hola
			
			if(texto.toUpperCase().contains("HOLA")) { // le pasas un texto en mayuscula y compara que contenga en mayuscula con uppercase HOLA
				JOptionPane.showMessageDialog(txtAreacom,"El texto contiene hola"); // te muestra un mensaje emergente donde tu indiques y el mensaje que quiera
			} else {
				JOptionPane.showMessageDialog(txtAreacom,"El texto no contiene hola"); // te muestra un mensaje emergente donde tu indiques y el mensaje que quiera
			}
		}
		
		else if(e.getSource()== btnAdios) { //coge el source del boton adios
			
			if(texto.toLowerCase().indexOf("adios")!=-1) { // le pasas en minusucla el texto y lo compara con el index adios y si es distinto de menos 1 te dice que lo ha encontrado
				JOptionPane.showMessageDialog(txtAreacom,"El texto contiene adios"); // te muestra un mensaje emergente donde tu indiques y el mensaje que quiera
			} else {
				JOptionPane.showMessageDialog(txtAreacom,"El texto no contiene adios"); // te muestra un mensaje emergente donde tu indiques y el mensaje que quiera
			}
		}
		else if(e.getSource()==btnAgregar) {
			agregarempresa();
		}
		
		else if(e.getSource()==btnEliminar) {
			eliminarempresa(list.getSelectedIndex());
		}
		
		else if(e.getSource()==btnBorrar) {
			modelo.removeAllElements();
		}
		
	}

	private void eliminarempresa(int selectedIndex) {
		// TODO Auto-generated method stub
		if(selectedIndex>=0) { // comprueba si hay indice disponible
			Icon icono = new ImageIcon(getClass().getResource("../imagenes/evento-virtual.png")); // imagene icono de advertencia
			int opcion= JOptionPane.showConfirmDialog(this, "Confirma que sea eliminar la empresa?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, icono); // 
			// muestra la opcion si o no y el tipo de mensaje que es warning
			if(opcion==0) { // si la salida es correcta
				modelo.remove(selectedIndex); // borra en el indice seleccionado
			}
			} else {
				JOptionPane.showMessageDialog(this, "No hay empresa señalada");
			}
		}

	private void agregarempresa() {
		// TODO Auto-generated method stub
		String nombre_empresa = txtAgregar.getText();
		String patron_base ="[a-zA-Z0-9 ]+"; // CREA EL PATRON y con el mas indicar que minimo tiene un caracter
		Pattern patron_empresa = Pattern.compile(patron_base); // compila el patron que hemos introducido
		Matcher mat = patron_empresa.matcher(nombre_empresa); // compara el patron con lo que has introducido
		if(mat.matches()) { // si coincide patron y texto
			String patron_base2 = ".*oo.*"; // con el asterisco indica que tiene 0 o muchas, para indicar que no es un metacaracter le pasas el punto antes del asterisco
			Pattern patron2 = Pattern.compile(patron_base2);
			Matcher mat2 = patron2.matcher(nombre_empresa.toLowerCase());
			if(mat2.matches()) {
				txtAgregar.setText("");
				JOptionPane.showMessageDialog(list, "El nombre introducido no es compatible con el patron");
			} else {
				if(modelo.contains(nombre_empresa)) { // comprueba que la empresa esté ya introducida
					txtAgregar.setText("");
					JOptionPane.showMessageDialog(list, "Empresa ya insertada");
				} else {
					modelo.addElement(nombre_empresa);
					list.setModel(modelo); // hay que actualizar siempre el model
					txtAgregar.setText(""); // vacia el texto 
				}
				
				
					
				
				
			}
		} else {
			txtAgregar.setText("");
			JOptionPane.showMessageDialog(list, "El nombre introducido no es compatible con el patron");
		
		}
	}
}
