package tabla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Controlador {

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/sakila?useSSL=false";
	private static final String USUARIO = "root";
	private static final String CLAVE = "1234";
	
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;
	
	public Connection conexion_correcta() { // metodo para comprobar la conexion 
		try {
			cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
			stm= cn.createStatement();
			System.out.println("Conexion realizada correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error en la conexion");
		}
		return cn;
	}

	public ArrayList buscar_actor(String nombre_actor) {
		ArrayList dato = new ArrayList();
		this.conexion_correcta();
		
		try {
			resultado = stm.executeQuery("select * from actor where first_name='"+ nombre_actor +"'");
			while(resultado.next()) {
				String nombre_actor_BD = resultado.getString("first_name");
				String apellido_actor_BD = resultado.getString("last_name");
				dato.add(nombre_actor + ","+ apellido_actor_BD);
				System.out.println(nombre_actor + ","+ apellido_actor_BD);
			}
			stm.close();
			cn.close();
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dato;
		// TODO Auto-generated method stub
		
		
	}

	public DefaultTableModel cargartabla(String nombre_actor) {
		// TODO Auto-generated method stub
		String [] titulos = {"Nombre", "Apellidos"}; // crea los titulos de la tabla
		String [] registros = new String[2]; // crea los registros
		DefaultTableModel modelo= new DefaultTableModel(null, titulos); // creas el modelo de tabla con null que es el tipo de dato que va a recibir y titulos la primera linea de la tabla
		this.conexion_correcta();
		try {
			resultado= stm.executeQuery("select * from actor where first_name='"+ nombre_actor +"'");
			while(resultado.next()) {
				registros[0] = resultado.getString("first_name"); // en la primera columna le pasas el nombre
				System.out.println(registros[0]);
				registros[1] = resultado.getString("last_name"); // en la segunda columna le pasas el apellido
				modelo.addRow(registros); // al modelo le añade ambas filas
			}
			
			stm.close();
			cn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modelo;
	}
	
	public void insertarnuevo(JTextField txtNuevoNombre, JTextField txtNuevoApellido) {
		String nuevonombre = txtNuevoNombre.getText();
		String nuevoapellido = txtNuevoApellido.getText();
		
		this.conexion_correcta();
		
		if(!nuevonombre.isEmpty() && !nuevoapellido.isEmpty()) {
			try {
				stm.executeUpdate("insert into actor (first_name,last_name) values ('"+ nuevonombre + "','" + nuevoapellido+"')" );
				stm.close();
				cn.close();
				JOptionPane.showMessageDialog(txtNuevoApellido, "Usuario insertado correctamente");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(txtNuevoApellido, "Usuario no insertado correctamente");
			}
		}
	}
}
