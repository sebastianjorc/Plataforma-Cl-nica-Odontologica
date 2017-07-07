package Model;
/*--------------------------------------------------------------------------------------------------------*/	
import java.sql.*;

import javax.swing.JOptionPane;
/*--------------------------------------------------------------------------------------------------------*/	
/**Clase encargada de realizar la conexión con el servidor.
 */
/**
 * @author Sebastian Joshua
 *
 */
public class ConexionSQL {
	public Connection con;
	
	/**Realiza conexión con el servidor.
	 */
	/**
	 * 
	 */
	public void connect(){

		 try
		    {
		    String myDriver	= "org.gjt.mm.mysql.Driver";
		    String myUrl	= "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10183690";
		    String user		= "sql10183690";
		    String psswd	= "t5M2ftrU4b";

		    Class.forName(myDriver);
		    con = DriverManager.getConnection(myUrl, user, psswd);
			System.out.println("La conexión ha sido un exito");
			
		    }
		    catch (Exception e){
			    JOptionPane.showMessageDialog(null, "Error al conectar la base de datos!\n"
			    			+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);		    	
		    }
	}
}
/*--------------------------------------------------------------------------------------------------------*/	