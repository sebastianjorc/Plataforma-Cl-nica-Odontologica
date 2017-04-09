package View;

import Model.User;

@SuppressWarnings("serial")
public class Interfaz_Paciente extends Interfaz {
	public Interfaz_Paciente(User user){
		super("Paciente",user.getId(),user.getName());
	}

}