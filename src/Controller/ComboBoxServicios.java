package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Model.ConexionSQL;

/**
 * @author
 *
 */
public class ComboBoxServicios implements ItemListener{
	
	JLabel ResE1,ResE2,tipoM,idM,nameM,precioM;
	JComboBox<String> cbService;
	String service,hacer;
	private ConexionSQL con;

	/**
	 * @param comboServiciosM
	 * @param rTipoM
	 * @param rIdM
	 * @param rNameM
	 * @param rPrecioM
	 * @param Hacer
	 */
	public ComboBoxServicios(JComboBox<String> comboServiciosM, JLabel rTipoM, JLabel rIdM, JLabel rNameM,
			JLabel rPrecioM, String Hacer){
		precioM		=rPrecioM;
		nameM		=rNameM;
		idM			=rIdM;
		tipoM		=rTipoM;
		cbService 	= comboServiciosM;
		hacer=Hacer;
	}

	/**
	 * @param comboServiciosE
	 * @param resultadoE1
	 * @param resultadoE2
	 * @param Hacer
	 */
	public ComboBoxServicios(JComboBox<String> comboServiciosE, JLabel resultadoE1, JLabel resultadoE2, String Hacer) {
		cbService 	= comboServiciosE;
		ResE1 		= resultadoE1;
		ResE2 		= resultadoE2;
		hacer		= Hacer;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	public void itemStateChanged(ItemEvent e) {
		if ( e.getStateChange() == ItemEvent.SELECTED ){
			service = (String) cbService.getSelectedItem();
	        consulta(service);
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
		System.out.println(tipo+" ESTOY EN SERVICIO");
		
		try {
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery ("SELECT * FROM Servicios WHERE NOMBRE_SERVICIO='"+tipo+"'");
			rs.next();
			if (hacer=="eliminar"){
				ResE1.setText(rs.getString(3));
				ResE2.setText("$"+rs.getString(5));
			}
			else{
				tipoM.setText(rs.getString(2));
				precioM.setText("$"+rs.getString(5));
				nameM.setText(rs.getString(3));
				idM.setText(rs.getString(1));
			}
			
		} catch (SQLException e) {
		    JOptionPane.showMessageDialog(null, "Error. No se encuentra el tipo de servicio\n "
		    		+ "en la base de datos\nError: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);	
			e.printStackTrace();
		}
	}
}
