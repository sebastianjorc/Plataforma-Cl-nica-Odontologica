package JUnit;


import org.junit.Before;
import org.junit.Test;

import Controller.look;
import Model.User;
import View.Colores;
import View.Interfaz_Secretaria;

public class Interfaz_Secretaria_Test  implements Colores{
	
	Interfaz_Secretaria iSecreataria;
	User usr;
	int id = 1;
	String pass = "1";
	String name = "2";
	String tipoUsuario = "1";

	@Before
	public void before(){
		new look();		
		usr 	= new User(id,pass,name,tipoUsuario);
		iSecreataria	= new Interfaz_Secretaria(usr);
	}
	
	@Test
	public void test() {
		iSecreataria.setVisible(true);
		try{
			Thread.sleep(50000);
		}catch(Exception e){
			
		}
		
	}

}
