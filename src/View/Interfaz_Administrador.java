package View;

import Model.User;

@SuppressWarnings("serial")
public class Interfaz_Administrador extends Interfaz {
	public Interfaz_Administrador(User user){
		super("Administrador",user.getId(),user.getName());
	}

}