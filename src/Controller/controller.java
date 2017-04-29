package Controller;

import javax.swing.JFrame;
import javax.swing.UIManager;

import View.Colores;
import View.Login;

public class controller implements Colores {
		
	public static void main(String[] args) {
		lyf_TabbedPane();
		JFrame login = new Login();
		login.setVisible(true);
		
	}
	
	static void lyf_TabbedPane(){
		UIManager.put("TabbedPane.borderHightlightColor", navyblue);
		UIManager.put("TabbedPane.selected", blanco);
		UIManager.put("TabbedPane.focus", blanco);
		UIManager.put("TabbedPane.contentAreaColor", blanco);
		
	}
}