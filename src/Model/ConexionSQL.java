package Model;
import java.sql.*;

import javax.swing.JFrame;

import View.Interfaz;
import View.Interfaz_Administrador;
import View.Interfaz_Paciente;
import View.Interfaz_Practicante;
import View.Interfaz_Recaudador;
import View.Interfaz_Secretaria;
import View.Interfaz_Tutor;

/**Clase encargada de realizar la conexión con el servidor.
 */
public class ConexionSQL {
	private Connection con;

	/**Realiza conexión con el servidor.
	 */
	public void connect(){

		 try
		    {
		    String myDriver	= "org.gjt.mm.mysql.Driver";
		    String myUrl	= "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10168005";
		    String user		= "sql10168005";
		    String psswd	= "jzpLmgzlcn";

		    Class.forName(myDriver);
		    con = DriverManager.getConnection(myUrl, user, psswd);
			System.out.println("La conexión ha sido un exito");
			
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
				System.out.println("\nid:\t"+rs.getInt(1)+"\n"+"Tipo Usuario:\t"+rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al imprimir administradores");
			e.printStackTrace();
		}
	}
	
	public void consultaLogin(String id, String pass){
		ResultSet rs = null;	Statement s = null; String tipoResultado;
		System.out.println(id+"\t"+pass);
		try {
			this.connect();
			s = con.createStatement();
			rs = s.executeQuery ("select * from Usuario where id = '"+id+"'");
			//MOVER, ORDENAR FUNCIÓN
			if (rs.next()){
				tipoResultado=rs.getString(4);
				JFrame in;
				System.out.println(tipoResultado);
				if (tipoResultado.equals("Administrador")){
					in = new Interfaz_Administrador();
				}
				else if (tipoResultado.equals("Secretaria")){
					in = new Interfaz_Secretaria();
				}
				else if (tipoResultado.equals("Paciente")){
					in = new Interfaz_Paciente();
				}
				else if (tipoResultado.equals("Tutor")){
					in = new Interfaz_Tutor();
				}
				else if (tipoResultado.equals("Practicante")){
					in = new Interfaz_Practicante();
				}
				else if (tipoResultado.equals("Recaudador")){
					in = new Interfaz_Recaudador();
				}
				else if (tipoResultado.equals("AdmFinanza")){
					in = new Interfaz_Administrador();
				}else{in=null;}
				
				in.setVisible(true);
				
			}else System.out.println("ERROR");
			
			
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se encuentra ID");
			e.printStackTrace();
		}
		
	}
	
}