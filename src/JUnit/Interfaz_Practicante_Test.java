package JUnit;

import org.junit.Before;
import org.junit.Test;

import Controller.look;

import Model.User;

import View.Practicante.Interfaz_Practicante;

public class Interfaz_Practicante_Test {

	Interfaz_Practicante interfaz_practicante;
	User usuario;
	int identificador = 10;
	String contraseña = "1";
	String nombre = "Practicante 1";
	String tipoUsuario = "tipoPracticante";
	
	@Before
	public void before(){
		new look();		
		usuario = new User(identificador,contraseña,nombre,tipoUsuario);
		interfaz_practicante = new Interfaz_Practicante(usuario);
	}
	
	@Test
	public void test() {
		interfaz_practicante.setVisible(true);
		try{
			Thread.sleep(50000);
		}catch(Exception e){}	
	}
}
