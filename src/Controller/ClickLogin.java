package Controller;
/*--------------------------------------------------------------------------------------------------------*/	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.Administrador;
import Model.AdministradorFinanza;
import Model.ConexionSQL;
import Model.Paciente;
import Model.Recaudador;
import Model.Secretaria;
import Model.Tutor;
import Model.User;

import View.Administrador.Interfaz_Administrador;
import View.Finanza.Interfaz_Finanza;
import View.Login.Login;
import View.Paciente.Interfaz_Paciente;
import View.Practicante.Interfaz_Practicante;
import View.Recaudador.Interfaz_Recaudador;
import View.Secretaria.Interfaz_Secretaria;
import View.Tutor.Interfaz_Tutor;
/*--------------------------------------------------------------------------------------------------------*/	
public class ClickLogin implements ActionListener{
	private JTextField id;
	JPasswordField pass;
	ConexionSQL con;
	JButton btn;
	JFrame login;
	SkipList skiplist;
/*--------------------------------------------------------------------------------------------------------*/	
	public ClickLogin(JTextField id, JPasswordField usuario_1, JButton botonIniciar, Login login, SkipList sl){
		this.id=id;
		this.pass=usuario_1;
		btn = botonIniciar;
		this.login=login;
		skiplist = sl;
		User usr;
	}
/*--------------------------------------------------------------------------------------------------------*/	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		con = new ConexionSQL();
		consultaLogin(id.getText(), pass.getText());
		btn.setSelected(false);
		
	}
/*--------------------------------------------------------------------------------------------------------*/	
	public void consultaLogin(String id, String pass){
		String tipoResultado; User usr = null;
		int ID = Integer.parseInt(id);
		System.out.println("ENTRO A IF 1 ");
		usr = skiplist.search(ID, pass);
		if (usr!=null){
			System.out.println(usr.getTipoUsuario());
			tipoResultado = usr.getTipoUsuario();	
			JFrame in;
			User user;

			System.out.println("RESULTADO : "+tipoResultado);
			if (tipoResultado.equals("Administrador")){
				user = usr;
				in = new Interfaz_Administrador(user);
			}
			else if (tipoResultado.equals("Secretaria")){
				user = usr;
				in = new Interfaz_Secretaria(user);
			}
			else if (tipoResultado.equals("Paciente")){
				user = usr;
				in = new Interfaz_Paciente(user);
			}
			else if (tipoResultado.equals("Tutor")){
				user = usr;
				in = new Interfaz_Tutor(user);
			}
			else if (tipoResultado.equals("Practicante")){
				user = usr;
				in = new Interfaz_Practicante(user);
			}
			else if (tipoResultado.equals("Recaudador")){
				user = usr;
				in = new Interfaz_Recaudador(user);
			}
			else if (tipoResultado.equals("AdmFinanza")){
				user = usr;
				in = new Interfaz_Finanza(user);
			}else{in=null; user=null;}

			in.setVisible(true);
			login.dispose();

		}else JOptionPane.showMessageDialog(null, "Error. Ingrese un usuario valido \n", "Error Login", JOptionPane.ERROR_MESSAGE);			
		
	}
}
/*--------------------------------------------------------------------------------------------------------*/	