import Controller.controller;
import Model.ConexionSQL;

public class main {

	public static void main(String[] args) {		
		ConexionSQL con = new ConexionSQL();
		con.connect();
		con.imprimi_tabla("Alumno");
		
		new controller();

	}

}
