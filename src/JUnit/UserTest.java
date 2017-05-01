package JUnit;

import static org.junit.Assert.*;

import org.junit.*;

import Controller.look;
import Model.User;

public class UserTest {
	
	User 	usr;
	int 	id = 1;
	String 	pass = "1";
	String 	name = "2";
	String 	tipoUsuario = "1";
	
	@Before
	public void Before(){
		new look();		
		System.out.println("Before");
		 usr = new User(id,pass,name,tipoUsuario);
	}
	
	@Test
	public void test() {
		int resultado = usr.getId();
		assertEquals(resultado,id);
		
		usr.getName();
		usr.getPassword();
		usr.getTipoUsuario();
	}

}
