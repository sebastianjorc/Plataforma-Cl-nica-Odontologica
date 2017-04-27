package JUnit;

import org.junit.*;

import Model.User;
import View.Interfaz_Administrador;

public class Interfaz_Administrador_Test {
	
	Interfaz_Administrador iAdm;
	User usr;
	int id = 1;
	String pass = "1";
	String name = "2";
	String tipoUsuario = "1";

	@Before
	public void before(){
		usr 	= new User(id,pass,name,tipoUsuario);
		iAdm	= new Interfaz_Administrador(usr);
	}
	
	@Test
	public void test() {
		iAdm.setVisible(true);
		try{
			Thread.sleep(20000);
		}catch(Exception e){
			
		}
		
	}

}
