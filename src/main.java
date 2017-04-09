import Controller.controller;
import Model.ConexionSQL;

public class main {

	public static void main(String[] args) {		
		ConexionSQL con = new ConexionSQL();
		con.connect();
		con.imprimir_tabla("Paciente");
		
		new controller();

	}

}
