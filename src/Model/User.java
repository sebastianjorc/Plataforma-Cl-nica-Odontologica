package Model;

public class User {
	private int		id;
	private	String	name;
	private String	password;
	private String	tipoUsuario;
	
	public User (int id, String name, String password){
		this.id=id;
		this.name=name;
		this.password=password;
	}
	

	/*GETTERS Y SETTERS*/
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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