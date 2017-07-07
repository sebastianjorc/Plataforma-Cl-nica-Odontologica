package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Model.ConexionSQL;

/**
 * @author
 *
 */
public class ClickEliminarServicio implements ActionListener {
	JComboBox<String> idService;
	private ConexionSQL con;
	private java.sql.PreparedStatement psEliminar;

	/**
	 * @param comboServiciosE
	 */
	public ClickEliminarServicio(JComboBox<String> comboServiciosE) {
		idService=comboServiciosE;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		con = new ConexionSQL();
		con.connect();
		try{
		psEliminar = con.con.prepareStatement(
			 "delete from Servicios where ID_SERVICIO=?"
			 );
	    System.out.println(idService.getSelectedItem().toString());
	    
	    psEliminar.setString(1, idService.getSelectedItem().toString());
	    psEliminar.execute();
	    con.con.close();

	    JOptionPane.showMessageDialog(null, "La eliminación ha sido un éxito");
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el elemento de la tabla\n"+e1);
		}		
	}

}
