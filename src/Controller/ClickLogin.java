package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.ConexionSQL;
import View.BaseButton;
import View.BaseTextField;

public class ClickLogin implements ActionListener{
	private BaseTextField id, pass;
	ConexionSQL con;
	BaseButton btn;
	
	public ClickLogin(BaseTextField id, BaseTextField pass, BaseButton botonIniciar){
		this.id=id;
		this.pass=pass;
		btn = botonIniciar;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		con = new ConexionSQL();
		
		con.consultaLogin(id.getText(), pass.getText());
		btn.setSelected(false);
		
		//Cerrar login
		//Abrir interfaz de usuario
		
	}

}
