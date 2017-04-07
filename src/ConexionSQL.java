
import java.sql.*;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**Clase encargada de realizar la conexión con el servidor.
 */
public class ConexionSQL {
	private Connection con;
	

	/**Realiza conexión con el servidor.
	 */
	public void connect(){
		
		 try
		    {
			System.out.println("La conexión ha sido un exito");
		    // create a mysql database connection
		    String myDriver = "org.gjt.mm.mysql.Driver";
		    String myUrl = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10168005";
		    String user = "sql10168005";
		    String psswd = "jzpLmgzlcn";
		    Class.forName(myDriver);
		    con = DriverManager.getConnection(myUrl, user, psswd);		      
		    }
		    catch (Exception e)
		    {
		      System.err.println("Error al conectar la base de datos!");
		      System.err.println(e.getMessage());
		    }
	}
	
	void imprimi_administradores(){
		ResultSet rs = null;	Statement s = null;
		System.out.println("Imprimir Administradores\n");
		try {
			s = con.createStatement();
			rs = s.executeQuery ("select * from Administrador");
			while (rs.next()){
				System.out.println("Nombre: "+rs.getString(2)+"\nRut: "+rs.getInt(1)+"\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	
}