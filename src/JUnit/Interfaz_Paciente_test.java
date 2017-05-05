package JUnit;

import org.junit.Before;
import org.junit.Test;

import Controller.look;

import Model.User;

import View.Paciente.Interfaz_Paciente;

public class Interfaz_Paciente_test {
	
	Interfaz_Paciente interfaz_paciente;
	User usuario;
	int identificador = 1;
	String contraseña = "1";
	String nombre = "Paciente";
	String tipoUsuario = "tipoPaciente";
	
	@Before
	public void before(){
		new look();		
		usuario 	= new User(identificador,contraseña,nombre,tipoUsuario);
		interfaz_paciente	= new Interfaz_Paciente(usuario);
	}
	
	@Test
	public void test() {
		interfaz_paciente.setVisible(true);
		try{
			Thread.sleep(50000);
		}catch(Exception e){}	
	}
}
