package Controller;

import javax.swing.JFrame;

import View.Interfaz;
import View.Login;

public class controller {
	public static void main(String[] args) {
	
		JFrame login = new Login(); //Frame principal
		JFrame intf = new Interfaz(); //Frame principal
		intf.setVisible(true);
		login.setVisible(true);
	}
}

