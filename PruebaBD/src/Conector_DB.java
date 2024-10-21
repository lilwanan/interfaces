import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conector_DB {
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	//private static final String URL = "jdbc:mysql://localhost:3306/sakila?useSSL=false";
	//private static final String USUARIO = "root";
	//private static final String CLAVE = "1234";
	private static final String URL = "jdbc:mysql://bhwemhjpyjoihqtfgtxf-mysql.services.clever-cloud.com/bhwemhjpyjoihqtfgtxf?useSSL=false";
	private static final String USUARIO = "u4w3wca9w5eocilp";
	private static final String CLAVE = "wM5fhkau40pvMnLBahSm";
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;
	
	public Connection conexion_correcta() { // metodo para comprobar la conexion 
		try {
			cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexion realizada correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error en la conexion");
		}
		return cn;
	}
}
