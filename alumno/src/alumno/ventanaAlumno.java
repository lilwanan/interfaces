package alumno;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class ventanaAlumno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtinsertanombre;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnHabilitar;
	private JCheckBox chckbxusuario;

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
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(txtinsertanombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(chckbxusuario, "Usuario Incorrecto"); // muestra un mensaje en la posicion del primer argumento y en el segundo un mensaje
				} else {
					String nombre_usuario = txtinsertanombre.getText();
					validar_usuario(nombre_usuario);
					
				}
			}

			
		});
		btnNewButton.setBounds(10, 128, 89, 23);
		contentPane.add(btnNewButton);
		
		chckbxusuario = new JCheckBox("Usuario Seleccionado");
		chckbxusuario.setBounds(-1, 158, 127, 23);
		contentPane.add(chckbxusuario);
		
		JRadioButton rdbtnaprob = new JRadioButton("Aprobado");
		buttonGroup.add(rdbtnaprob);
		rdbtnaprob.setBounds(10, 184, 109, 23);
		contentPane.add(rdbtnaprob);
		
		JRadioButton rdbtnsus = new JRadioButton("Suspenso");
		buttonGroup.add(rdbtnsus);
		rdbtnsus.setBounds(10, 210, 109, 23);
		contentPane.add(rdbtnsus);
		
		JCheckBox chckbxaccdat = new JCheckBox("Acceso a Datos");
		chckbxaccdat.setBounds(10, 267, 116, 23);
		contentPane.add(chckbxaccdat);
		
		JCheckBox chckbxproc = new JCheckBox("Procesos");
		chckbxproc.setBounds(10, 293, 116, 23);
		contentPane.add(chckbxproc);
		
		JCheckBox chckbxdesint = new JCheckBox("Desarrollo Interfaces");
		chckbxdesint.setBounds(10, 319, 136, 23);
		contentPane.add(chckbxdesint);
		
		JTextArea txtAreacom = new JTextArea();
		txtAreacom.setBounds(382, 11, 324, 216);
		contentPane.add(txtAreacom);
		
		textField_1 = new JTextField();
		textField_1.setBounds(492, 238, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"EMPRESA1", "EMPRESA2", "EMPRESA3", "EMPRESA4", "EMPRESA5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("");
		list.setBounds(481, 270, 109, 105);
		contentPane.add(list);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(40);
		progressBar.setBounds(232, 361, 146, 14);
		contentPane.add(progressBar);
		
		btnHabilitar = new JButton("Habilitar"); // si lo defines arriba en atributos se puede quitar la primera definicion
		buttonGroup.add(btnHabilitar);
		btnHabilitar.setBounds(124, 128, 89, 23);
		btnHabilitar.setVisible(false); // deshabilita el boton
		contentPane.add(btnHabilitar);
		
		JLabel lblNewLabel = new JLabel("Ciclo que está cursando");
		lblNewLabel.setBounds(10, 67, 136, 14);
		contentPane.add(lblNewLabel);
		
	}
	
	private void validar_usuario(String nombre_usuario) {
		Pattern patron_nombre_usuario = Pattern.compile("[a-zA-Z ]{2}"); // comprueba el patron si es minuscula, mayuscula o tiene un espacio y el 2 son los caracteres minimos
		Matcher mat = patron_nombre_usuario.matcher(nombre_usuario); // compara lo que has introducido en nombre de usuario con el patron anterior
		if(mat.find()) { 
			JOptionPane.showMessageDialog(chckbxusuario, "El usuario ha sido encontrado"); // muestra un mensaje en la posicion del primer argumento y en el segundo un mensaje
		} else {
			JOptionPane.showMessageDialog(chckbxusuario, "El usuario no es correcto"); // muestra un mensaje en la posicion del primer argumento y en el segundo un mensaje
		}
		
	}
}
