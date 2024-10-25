package tabla;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInserta;
	private JTable table;
	private JButton btnInserta;
	private JTextField txtNuevoNombre;
	private JTextField txtNuevoApellido;
	Controlador conexion = new Controlador();
	Connection cn =null;
	Statement stm=null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 469);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize(); //
		int height = pantalla.height; // pasa el alto de la pantalla
		int width = pantalla.width; // pasa el ancho de la pantalla
		setSize(445,478);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setResizable(false); // no puede redimensionar la pantalla
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInserta = new JTextField();
		txtInserta.setBounds(10, 11, 123, 20);
		contentPane.add(txtInserta);
		txtInserta.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre_actor = txtInserta.getText();
				System.out.println(nombre_actor);
				conexion.buscar_actor(nombre_actor);
				table.setModel(conexion.cargartabla(nombre_actor));
			}
		});
		btnBuscar.setBounds(161, 10, 89, 23);
		contentPane.add(btnBuscar);
		
		table = new JTable();
		table.setBounds(10, 42, 271, 192);
		contentPane.add(table);
		
	
		
		
		btnInserta = new JButton("Inserta");
		btnInserta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion.insertarnuevo(txtNuevoNombre,txtNuevoApellido);
			}
		});
		btnInserta.setBounds(230, 300, 89, 23);
		contentPane.add(btnInserta);
		
		txtNuevoNombre = new JTextField();
		txtNuevoNombre.setBounds(10, 288, 166, 20);
		contentPane.add(txtNuevoNombre);
		txtNuevoNombre.setColumns(10);
		
		txtNuevoApellido = new JTextField();
		txtNuevoApellido.setBounds(10, 319, 166, 20);
		contentPane.add(txtNuevoApellido);
		txtNuevoApellido.setColumns(10);
		
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 42, 271, 192);
		contentPane.add(scroll);
	}
}
