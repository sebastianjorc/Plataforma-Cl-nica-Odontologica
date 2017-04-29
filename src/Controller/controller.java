package Controller;

import javax.swing.JFrame;
import javax.swing.UIManager;

import View.Colores;
import View.Login;

public class controller implements Colores {
		
	public static void main(String[] args) {
		new look();
		JFrame login = new Login();
		login.setVisible(true);
		
	}
}