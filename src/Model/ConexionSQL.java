package Model;
import java.sql.*;

/**Clase encargada de realizar la conexi�n con el servidor.
 */
public class ConexionSQL {
	public Connection con;

	/**Realiza conexi�n con el servidor.
	 */
	public void connect(){

		 try
		    {
		    String myDriver	= "org.gjt.mm.mysql.Driver";
		    String myUrl	= "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10170386";
		    String user		= "sql10170386";
		    String psswd	= "SVh8sr8xCd";

		    Class.forName(myDriver);
		    con = DriverManager.getConnection(myUrl, user, psswd);
			System.out.println("La conexi�n ha sido un exito");
			
		    }
		    catch (Exception e)
		    {
		      System.err.println("Error al conectar la base de datos!");
		      System.err.println(e.getMessage());
		    }
	}

	public void imprimir_tabla(String Tabla){
		ResultSet rs = null;	Statement s = null;
		try {
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