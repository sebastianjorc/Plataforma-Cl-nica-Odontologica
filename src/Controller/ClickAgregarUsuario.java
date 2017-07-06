package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.ConexionSQL;

public class ClickAgregarUsuario implements ActionListener {
	JComboBox<String> ccomboTiposA;
	JTextField nnIdA,nnPassA,nnNameA,nnNivel;
	ConexionSQL con;
	private PreparedStatement psInsertar;
	
	public ClickAgregarUsuario(JComboBox<String> comboTiposA,JTextField nIdA,JTextField nPassA,JTextField nNameA, JTextField nNivel){
		this.ccomboTiposA = comboTiposA;
		this.nnIdA = nIdA;
		this.nnPassA = nPassA;
		this.nnNameA = nNameA;
		this.nnNivel = nNivel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String imagen = "foto"+nnIdA.getText()+".jpg";
		String stringdelbox = (String) ccomboTiposA.getSelectedItem();
		String ServiciosPosibles = null;
		con = new ConexionSQL();
		con.connect();
		
		
		if(stringdelbox.equals("Practicante")){//con el nivel calculo los servicios posibles
			int numero = Integer.parseInt( nnNivel.getText());
			if(numero<7){
				JOptionPane.showMessageDialog(null, "Ingrese Nivel válido");
			}
			else{
				if(numero == 7){ ServiciosPosibles = "0-1";}
				if(numero == 8){ ServiciosPosibles = "2-3-4";}
				if(numero == 9){ ServiciosPosibles = "5-6-9";}
				if(numero == 10){ ServiciosPosibles = "7-8";}
				if(numero == 11){ ServiciosPosibles = "12-13";}
				if(numero == 12){ServiciosPosibles = "10-11-14-15";}
				try{
					psInsertar = con.con.prepareStatement(
							"INSERT INTO Usuarios (ID, CONTRASENA, NOMBRE, TIPO, IMAGEN) VALUES (?,?,?,?,?)");
					psInsertar.setString(1, nnIdA.getText());
					psInsertar.setString(2, nnPassA.getText());
					psInsertar.setString(3, nnNameA.getText());
					psInsertar.setString(4, stringdelbox);
					psInsertar.setString(5,imagen);
					psInsertar.executeUpdate();
					
					psInsertar = con.con.prepareStatement(
						"INSERT INTO `Practicantes`(`ID`, `PROFESIONAL`, `NIVEL`, `SERVICIOS POSIBLES`) VALUES (?,?,?,?)");
					psInsertar.setString(1, nnIdA.getText());
					psInsertar.setString(2, nnNameA.getText());
					psInsertar.setInt(3, numero);
					psInsertar.setString(4, ServiciosPosibles);	
					
					psInsertar.executeUpdate();
				}
				catch (Exception e1){
					JOptionPane.showMessageDialog(null, "No se pudo ingresar en tabla");
				}
			}
		}
		else{
			try{
				psInsertar = con.con.prepareStatement(
					"INSERT INTO Usuarios (ID, CONTRASENA, NOMBRE, TIPO, IMAGEN) VALUES (?,?,?,?,?)");
				psInsertar.setString(1, nnIdA.getText());
				psInsertar.setString(2, nnPassA.getText());
				psInsertar.setString(3, nnNameA.getText());
				psInsertar.setString(4, stringdelbox);
				psInsertar.setString(5,imagen);
				psInsertar.executeUpdate();
			}
			catch (Exception e1){
				JOptionPane.showMessageDialog(null, "No se pudo ingresar en tabla");
			}
		}
	}
}	
