package JUnit;
/*--------------------------------------------------------------------------------------------------------*/	
import org.junit.Before;
import org.junit.Test;

import Controller.look;

import Model.User;

import View.Recaudador.Interfaz_Recaudador;
/*--------------------------------------------------------------------------------------------------------*/	
public class Interfaz_Recaudador_Test {
	
	Interfaz_Recaudador iRecaudador;
	User usr;
	
	int id = 1;
	String pass = "1", name = "2", tipoUsuario = "1";

	@Before
	public void before(){
		new look();		
		usr 	= new User(id,pass,name,tipoUsuario);
		iRecaudador	= new Interfaz_Recaudador(usr);
	}
	
	@Test
	public void test() {
		iRecaudador.setVisible(true);
		try{
			Thread.sleep(50000);
		}catch(Exception e){}	
	}
}
/*--------------------------------------------------------------------------------------------------------*/	