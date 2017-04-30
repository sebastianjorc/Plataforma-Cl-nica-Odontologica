package Model;
import java.sql.*;

import javax.swing.JOptionPane;

/**Clase encargada de realizar la conexión con el servidor.
 */
public class ConexionSQL {
	public Connection con;

	/**Realiza conexión con el servidor.
	 */
	public void connect(){

		 try
		    {
		    String myDriver	= "org.gjt.mm.mysql.Driver";
		    String myUrl	= "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10171990";
		    String user		= "sql10171990";
		    String psswd	= "mETVBAWrV4";

		    Class.forName(myDriver);
		    con = DriverManager.getConnection(myUrl, user, psswd);
			System.out.println("La conexión ha sido un exito");
			
		    }
		    catch (Exception e){
			    JOptionPane.showMessageDialog(null, "Error al conectar la base de datos!\n"
			    			+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);		    	
		    }
	}

	public void imprimir_tabla(String Tabla){
		ResultSet rs = null;	Statement s = null;
		try {
			con = (Connection) new ConexionSQL();
			s = con.createStatement();
			rs = s.executeQuery ("select * from "+Tabla);
			System.out.println("Imprimir "+Tabla+"\n");
			while (rs.next()){
				System.out.println("id:"+rs.getInt(1)+"-Pass:"+rs.getString(2)+
						"-nombre:"+rs.getString(3)+"-tipo"+rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al imprimir administradores");
			e.printStackTrace();
		}
	}		
}