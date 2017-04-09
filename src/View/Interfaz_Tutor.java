package View;

import Model.User;

@SuppressWarnings("serial")
public class Interfaz_Tutor extends Interfaz {
	public Interfaz_Tutor(User user){
		super("Tutor",user.getId(),user.getName());
	}
}