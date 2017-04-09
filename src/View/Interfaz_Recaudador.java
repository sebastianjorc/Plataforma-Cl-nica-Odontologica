package View;

import Model.User;

@SuppressWarnings("serial")
public class Interfaz_Recaudador extends Interfaz {
	public Interfaz_Recaudador(User user){
		super("Recaudador",user.getId(),user.getName());
	}

}
