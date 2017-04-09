package View;

import Model.User;

@SuppressWarnings("serial")
public class Interfaz_Finanza extends Interfaz{
	public Interfaz_Finanza(User user){
		super("Administrador Financiero",user.getId(),user.getName());
	}

}
