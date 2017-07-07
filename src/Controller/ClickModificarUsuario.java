package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.ConexionSQL;

public class ClickModificarUsuario implements ActionListener{
	JComboBox<String> ccomboTiposA;
	JTextField nnIdA,nnPassA,nnNameA,nnNivel;
	ConexionSQL con;
	JLabel user,tipo,id,pass,name;
	private PreparedStatement psInsertar;

	public ClickModificarUsuario(JComboBox<String> comboTiposA, JTextField nIdA, JTextField nPassA, JTextField nNameA,
			JTextField nNivel, JLabel rTipoM, JLabel rIdM, JLabel rPassM, JLabel rNameM) {
		this.ccomboTiposA = comboTiposA;
		this.nnIdA = nIdA;
		this.nnPassA = nPassA;
		this.nnNameA = nNameA;
		this.nnNivel = nNivel;
		id=rIdM;
		pass=rPassM;
		tipo=rTipoM;
		name=rNameM;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		con = new ConexionSQL();
		con.connect();
		
		try{
			psInsertar = con.con.prepareStatement(
				"UPDATE Usuarios SET "
				+ " CONTRASENA=?,"
				+ " NOMBRE=?,"
				+ " ID=?,"
				+ " TIPO=?"
				+ " WHERE ID=?");
			
			if (nnPassA.getText().length()!=0){
				psInsertar.setString   (1, nnPassA.getText());
				System.out.println("Entro pass "+nnPassA.getText());
			}
			else {
				psInsertar.setString   (1, pass.getText());
				}
			
			if (nnNameA.getText().length()!=0){
				psInsertar.setString   (2, nnNameA.getText());
				System.out.println("Entro Name "+nnNameA.getText());
			}
			else{
				psInsertar.setString   (2, name.getText());
				}
			
			if (nnIdA.getText().length()!=0){
				psInsertar.setString   (3, nnIdA.getText());
				System.out.println("Entro ID " + nnIdA.getText());
			}
			else{
				psInsertar.setString   (3, id.getText());
			}
			
			psInsertar.setString   (4, ccomboTiposA.getSelectedItem().toString());
			System.out.println("Entro tipo "+ccomboTiposA.getSelectedItem().toString());
			
			psInsertar.setString   (5, id.getText());
			psInsertar.executeUpdate();
			con.con.close();

			JOptionPane.showMessageDialog(null, "La actualización ha sido un éxito");
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, "No se pudo ingresar en tabla");
		}
		
	}

}
