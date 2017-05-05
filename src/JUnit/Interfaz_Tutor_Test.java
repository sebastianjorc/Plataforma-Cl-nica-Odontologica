package JUnit;
/*--------------------------------------------------------------------------------------------------------*/	
import org.junit.Before;
import org.junit.Test;

import Controller.look;

import Model.User;

import View.Tutor.Interfaz_Tutor;
/*--------------------------------------------------------------------------------------------------------*/	
public class Interfaz_Tutor_Test {
	
	Interfaz_Tutor iTutor;
	User usr;
	
	int id = 1;
	String pass = "1", name = "2", tipoUsuario = "1";

	@Before
	public void before(){
		new look();		
		usr 	= new User(id,pass,name,tipoUsuario);
		iTutor	= new Interfaz_Tutor(usr);
	}
	
	@Test
	public void test() {
		iTutor.setVisible(true);
		try{
			Thread.sleep(50000);
		}catch(Exception e){}
	}
}
/*--------------------------------------------------------------------------------------------------------*/	
