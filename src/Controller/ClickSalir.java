package Controller;
/*--------------------------------------------------------------------------------------------------------*/	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

import Model.ConexionSQL;
import Model.User;
import View.Interfaz;
import View.Login.Login;
/*--------------------------------------------------------------------------------------------------------*/	
/**
 * @author Norton Irarrazabal - Sebastian Rojas
 * Devuelve al login cuando sales de una interfaz
 */
public class ClickSalir implements ActionListener {
	Interfaz in; JFrame login;
	public ClickSalir(Interfaz interfaz){
		in = interfaz; 
	}
/*--------------------------------------------------------------------------------------------------------*/	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		in.dispose();
		SkipList sl = new SkipList(100000000); 
		consulta(sl);
		
		login = new Login(sl);
		login.setVisible(true);
	}
/*--------------------------------------------------------------------------------------------------------*/	
/**
 * @param sl
 */
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