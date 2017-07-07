package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*--------------------------------------------------------------------------------------------------------*/	
import javax.swing.JFrame;

import Model.ConexionSQL;
import Model.User;
import View.Colores;
import View.Login.Login;
/*--------------------------------------------------------------------------------------------------------*/	
public class controller implements Colores {
		
	public static void main(String[] args) {
		new look();
		SkipList sl = new SkipList(100000000); 
		consulta(sl);
		
		JFrame login = new Login(sl);
		login.setVisible(true);
	}
	private static void consulta(SkipList sl) {
		ResultSet rs = null;	Statement s = null;
		User user;
		try {
			String st; int in;
			ConexionSQL con = new ConexionSQL();
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery ("select * from Usuarios");
			while (rs.next()){
				st=rs.getString(1);
				in=Integer.parseInt(st);
				user = new User (in,rs.getString(2),rs.getString(3),rs.getString(4));
				sl.insert(in,user);
			}
			con.con.close();
				
		}catch (SQLException e) {
			System.out.println("Error al buscar crear skiplist\n"+ e);
			e.printStackTrace();
		}	
		System.out.println("salgo consulta ");
	}
}
/*--------------------------------------------------------------------------------------------------------*/	
