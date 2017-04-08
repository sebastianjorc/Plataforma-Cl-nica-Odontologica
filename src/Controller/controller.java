package Controller;

import javax.swing.JFrame;

import View.Interfaz;
import View.Login;

public class controller {
	public static void main(String[] args) {
	
		JFrame login = new Login();
		JFrame intf = new Interfaz();
		intf.setVisible(true);
		login.setVisible(true);
		
	}
}