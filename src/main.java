public class main {

	public static void main(String[] args) {
		ConexionSQL con = new ConexionSQL();
		con.connect();
		con.imprimi_administradores();		
	}

}
