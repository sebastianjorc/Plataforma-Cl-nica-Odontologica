package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.ConexionSQL;

/**
 * @author
 *
 */
public class ClickEliminarUsuario implements ActionListener {
	JTextField idUser;
	private ConexionSQL con;
	private java.sql.PreparedStatement psEliminar;

	/**
	 * @param usuarioE
	 */
	public ClickEliminarUsuario(JTextField usuarioE) {
		idUser=usuarioE;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		con = new ConexionSQL();
		con.connect();
		try{
		psEliminar = con.con.prepareStatement(
			 "delete from Usuarios where ID=?"
			 );
	    System.out.println(idUser.getText());
	    
	    psEliminar.setString(1, idUser.getText());
	    psEliminar.execute();
	    con.con.close();

	    JOptionPane.showMessageDialog(null, "La eliminación ha sido un éxito");
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el elemento de la tabla");
		}		
	}
}
