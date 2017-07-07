package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.ConexionSQL;

public class ClickAgregarServicio implements ActionListener {
	JComboBox<String> ccomboTiposA;
	JTextField nnIdA,nnPrecioA,nnNameA,nnNivel;
	ConexionSQL con;
	private PreparedStatement psInsertar;

	public ClickAgregarServicio(JComboBox<String> comboTiposA, JTextField nIdA, JTextField nPrecioA,
			JTextField nNameA) {
		this.ccomboTiposA = comboTiposA;
		this.nnIdA = nIdA;
		this.nnPrecioA = nPrecioA;
		this.nnNameA = nNameA;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String stringdelbox = (String) ccomboTiposA.getSelectedItem();
		con = new ConexionSQL();
		con.connect();
				
		try{
			psInsertar = con.con.prepareStatement(
				"INSERT INTO Servicios (ID_SERVICIO, TIPO_SERVICIO, NOMBRE_SERVICIO, PRECIO_TOTAL) VALUES (?,?,?,?)");
			psInsertar.setString(1, nnIdA.getText());
			psInsertar.setString(4, nnPrecioA.getText());
			psInsertar.setString(3, nnNameA.getText());
			psInsertar.setString(2, stringdelbox);
			//psInsertar.setString(4, precesos);
			psInsertar.executeUpdate();
			JOptionPane.showMessageDialog(null, "El servicio fue insertado exitosamente");
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, "No se pudo ingresar en tabla");
		}
	}

}
