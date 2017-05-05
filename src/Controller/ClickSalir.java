package Controller;
/*--------------------------------------------------------------------------------------------------------*/	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.Interfaz;
import View.Login.Login;
/*--------------------------------------------------------------------------------------------------------*/	
public class ClickSalir implements ActionListener {
	Interfaz in; JFrame login;
	public ClickSalir(Interfaz interfaz){
		in = interfaz;
	}
/*--------------------------------------------------------------------------------------------------------*/	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		in.dispose();
		login = new Login();
		login.setVisible(true);
	}
}
/*--------------------------------------------------------------------------------------------------------*/	
