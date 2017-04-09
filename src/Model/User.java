package Model;

public class User {
	private int		id;
	private	String	name;
	private String	pass;
	private String	tipoUsuario;
	
	public User (int id, String pass, String name, String tipo){
		this.id=id;
		this.pass=pass;
		this.name=name;
		this.tipoUsuario=tipo;
	}
	

	/*GETTERS Y SETTERS*/
	public String getPassword() {
		return pass;
	}
	
	public void setPassword(String password) {
		this.pass = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}