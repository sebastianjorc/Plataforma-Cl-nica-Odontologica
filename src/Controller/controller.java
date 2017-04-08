package Controller;

import javax.swing.JFrame;
import View.Login;

public class controller {
	public static void main(String[] args) {
		
		ConexionSQL con = new ConexionSQL();
		con.connect();
		con.imprimi_administradores();
	
		JFrame login = new Login(); //Frame principal
		login.setVisible(true);
	}
}

