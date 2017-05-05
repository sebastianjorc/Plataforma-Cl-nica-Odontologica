package JUnit;
/*--------------------------------------------------------------------------------------------------------*/	
import org.junit.*;

import Controller.look;

import Model.User;

import View.Colores;
import View.Administrador.Interfaz_Administrador;
/*--------------------------------------------------------------------------------------------------------*/	
public class Interfaz_Administrador_Test implements Colores{
	Interfaz_Administrador iAdm;
	User usr;
	int id = 1;
	String pass = "1";
	String name = "2";
	String tipoUsuario = "1";

	@Before
	public void before(){
		new look();		
		usr 	= new User(id,pass,name,tipoUsuario);
		iAdm	= new Interfaz_Administrador(usr);
	}
	
	@Test
	public void test() {
		iAdm.setVisible(true);
		try{
			Thread.sleep(50000);
		}catch(Exception e){}	
	}
}
/*--------------------------------------------------------------------------------------------------------*/	