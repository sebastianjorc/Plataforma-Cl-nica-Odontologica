package View;

import Model.User;

@SuppressWarnings("serial")
public class Interfaz_Secretaria extends Interfaz {
	public Interfaz_Secretaria(User user){
		super("Secretaria",user.getId(),user.getName());
		
	}

}
