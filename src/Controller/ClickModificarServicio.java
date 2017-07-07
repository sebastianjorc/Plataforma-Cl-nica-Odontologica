package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.ConexionSQL;

public class ClickModificarServicio  implements ActionListener{
	JComboBox<String> ccomboTiposA;
	JTextField nnIdA,nnPrecioA,nnNameA;
	ConexionSQL con;
	JLabel user,tipo,id,Precio,name;
	private PreparedStatement psInsertar;

	public ClickModificarServicio(JLabel rTipoM, JLabel rIdM, JLabel rNameM, JLabel rPrecioM,
			JComboBox<String> comboTiposMN, JTextField nIdM, JTextField nNameM, JTextField nPrecioM) {
		this.ccomboTiposA = comboTiposMN;
		this.nnIdA = nIdM;
		this.nnPrecioA = nPrecioM;
		this.nnNameA = nNameM;
		id=rIdM;
		Precio=rPrecioM;
		tipo=rTipoM;
		name=rNameM;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		con = new ConexionSQL();
		con.connect();
		
		try{
			psInsertar = con.con.prepareStatement(
				"UPDATE Servicios SET "
				+ " ID_SERVICIO=?,"
				+ " TIPO_SERVICIO=?,"
				+ " NOMBRE_SERVICIO=?,"
				+ " PRECIO_TOTAL=?"
				+ " WHERE NOMBRE_SERVICIO=?");
			
			if (nnPrecioA.getText().length()!=0){
				psInsertar.setString   (4, nnPrecioA.getText());
				System.out.println("Entro Precio "+nnPrecioA.getText());
			}
			else {
				psInsertar.setString   (4, Precio.getText());
				}
			
			if (nnNameA.getText().length()!=0){
				psInsertar.setString   (3, nnNameA.getText());
				System.out.println("Entro Name "+nnNameA.getText());
			}
			else{
				psInsertar.setString   (3, name.getText());
				}
			
			if (nnIdA.getText().length()!=0){
				psInsertar.setString   (1, nnIdA.getText());
				System.out.println("Entro ID " + nnIdA.getText());
			}
			else{
				psInsertar.setString   (1, id.getText());
			}
			
			psInsertar.setString   (2, ccomboTiposA.getSelectedItem().toString());
			System.out.println("Entro tipo "+ccomboTiposA.getSelectedItem().toString());
			
			psInsertar.setString   (5, id.getText());
			psInsertar.executeUpdate();
			con.con.close();

			JOptionPane.showMessageDialog(null, "La actualización ha sido un éxito");
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, "No se pudo ingresar en tabla\n"+e1);
		}
		
	}

}
