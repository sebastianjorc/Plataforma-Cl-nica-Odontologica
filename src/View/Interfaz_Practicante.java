package View;

import Model.User;

@SuppressWarnings("serial")
public class Interfaz_Practicante extends Interfaz {
	
	public Interfaz_Practicante(User user){
		super("Practicante",user.getId(),user.getName());
	}
}