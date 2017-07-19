package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Model.ConexionSQL;

/**
 * @author Sebastian -Norton
 *Combo box del servicio
 */
public class ComboBoxTipoServicioE implements ItemListener {
	JComboBox<String> jcbtipo,jcbservice;
	String tipo;
	ConexionSQL con;
	
	/**
	 * @param comboTiposE
	 * @param comboServiciosE
	 */
	public ComboBoxTipoServicioE(JComboBox<String> comboTiposE, JComboBox<String> comboServiciosE) {
		jcbtipo = comboTiposE;
		jcbservice=comboServiciosE;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if ( e.getStateChange() == ItemEvent.SELECTED ){
			tipo = (String) jcbtipo.getSelectedItem();
	        consulta(tipo);
		}
	}

/*--------------------------------------------------------------------------------------------------------*/	
	/**
	 * @param tipo
	 */
	public void consulta(String tipo){
		ResultSet rs= null;
		Statement s	= null;
		con = new ConexionSQL();
		
		try {
			jcbservice.removeAllItems();;
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery ("SELECT * FROM Servicios WHERE TIPO_SERVICIO='"+tipo+"'");
			System.out.println(tipo);
			while (rs.next())
				jcbservice.addItem(rs.getString(3));
			con.con.close();
			
		} catch (SQLException e) {
		    JOptionPane.showMessageDialog(null, "Error. No se encuentra el tipo de servicio\n "
		    		+ "en la base de datos\nError: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);	
			e.printStackTrace();
		}
	}
}
