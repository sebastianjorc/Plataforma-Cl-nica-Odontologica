package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import Model.Administrador;
import Model.AdministradorFinanza;
import Model.ConexionSQL;
import Model.Paciente;
import Model.Recaudador;
import Model.Secretaria;
import Model.Tutor;
import Model.User;
import View.BaseButton;
import View.BaseTextField;
import View.Administrador.Interfaz_Administrador;
import View.Finanza.Interfaz_Finanza;
import View.Login.Login;
import View.Paciente.Interfaz_Paciente;
import View.Practicante.Interfaz_Practicante;
import View.Recaudador.Interfaz_Recaudador;
import View.Secretaria.Interfaz_Secretaria;
import View.Tutor.Interfaz_Tutor;

public class ClickLogin implements ActionListener{
	private BaseTextField id;
	JPasswordField pass;
	ConexionSQL con;
	BaseButton btn;
	JFrame login;
	
	public ClickLogin(BaseTextField id, JPasswordField usuario_1, BaseButton botonIniciar, Login login){
		this.id=id;
		this.pass=usuario_1;
		btn = botonIniciar;
		this.login=login;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		con = new ConexionSQL();
		consultaLogin(id.getText(), pass.getText());
		btn.setSelected(false);
		
	}

	public void consultaLogin(String id, String pass){

		ResultSet rs = null;	Statement s = null; String tipoResultado;
		
		try {
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery ("select * from Usuario where id = '"+id+"' AND pass = '"+pass+"'");
			//MOVER, ORDENAR FUNCIÓN
			if (rs.next()){
				tipoResultado=rs.getString(4);	JFrame in;
				User user;
				
				if (tipoResultado.equals("Administrador")){
					user = new Administrador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					in = new Interfaz_Administrador(user);
				}
				else if (tipoResultado.equals("Secretaria")){
					user = new Secretaria(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					in = new Interfaz_Secretaria(user);
				}
				else if (tipoResultado.equals("Paciente")){
					user = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					in = new Interfaz_Paciente(user);
				}
				else if (tipoResultado.equals("Tutor")){
					user = new Tutor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					in = new Interfaz_Tutor(user);
				}
				else if (tipoResultado.equals("Practicante")){
					user = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					in = new Interfaz_Practicante(user);
				}
				else if (tipoResultado.equals("Recaudador")){
					user = new Recaudador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					in = new Interfaz_Recaudador(user);
				}
				else if (tipoResultado.equals("AdmFinanza")){
					user = new AdministradorFinanza(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					in = new Interfaz_Finanza(user);
				}else{in=null; user=null;}
				
				in.setVisible(true);
				login.dispose();
				
			}else JOptionPane.showMessageDialog(null, "Error. Ingrese un usuario valido \n", "Error Login", JOptionPane.ERROR_MESSAGE);			
			
			con.con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al buscar el usuario en la base de datos");
			e.printStackTrace();
		}
		
	}

}