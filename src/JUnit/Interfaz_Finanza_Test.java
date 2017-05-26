package JUnit;
/*--------------------------------------------------------------------------------------------------------*/
import org.junit.Before;
import org.junit.Test;

import Controller.look;

import Model.User;

import View.Finanza.Interfaz_Finanza;
/*--------------------------------------------------------------------------------------------------------*/
public class Interfaz_Finanza_Test {

	Interfaz_Finanza interfaz_finanza;
	User usuario;
	int identificador = 30;
	String contraseña = "1";
	String nombre = "Administrador financiero";
	String tipoUsuario = "tipoAdmFinanza";
	
	@Before
	public void before(){
		new look();		
		usuario 	= new User(identificador,contraseña,nombre,tipoUsuario);
		interfaz_finanza	= new Interfaz_Finanza(usuario);
	}
	
	@Test
	public void test() {
		interfaz_finanza.setVisible(true);
		try{
			Thread.sleep(90000);
		}catch(Exception e){}	
	}
}
/*--------------------------------------------------------------------------------------------------------*/