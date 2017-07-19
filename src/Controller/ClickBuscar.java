package Controller;
/*--------------------------------------------------------------------------------------------------------*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.ConexionSQL;
/*--------------------------------------------------------------------------------------------------------*/
/**
 * @author Sebastian Joshua,Norton Irarrazabal
 *Permite la busqueda de un usuario
 */
public class ClickBuscar implements ActionListener{
	JComboBox<String> string_tipo, nTipo;
	JTextField jtfId,nId,nName,nPass; 
	JLabel tipo,id,name,pass;
	ConexionSQL con;
	JButton btn;
	JPanel jp;
/*--------------------------------------------------------------------------------------------------------*/	
	/**
	 * @param jp
	 * @param usuarioE
	 * @param comboTiposM
	 * @param rTipoM
	 * @param rIdM
	 * @param rNameM
	 * @param rPassM
	 * @param btn
	 * @param nTipoM
	 * @param nIdM
	 * @param nNameM
	 * @param nPassM
	 */
	public ClickBuscar (JPanel jp, JTextField usuarioE, JComboBox<String> comboTiposM, JLabel rTipoM, JLabel rIdM, 
			JLabel rNameM, JLabel rPassM, JButton btn, JComboBox<String> nTipoM, JTextField nIdM, JTextField nNameM, JTextField nPassM){
		this.jp		= jp;
		tipo		= rTipoM;
		id			= rIdM;
		name		= rNameM;
		pass		= rPassM;
		string_tipo = comboTiposM;
		jtfId		= usuarioE;
		this.btn	= btn;
		nId			= nIdM;
		nPass		= nPassM;
		nTipo		= nTipoM;
		nName		= nNameM;
	}

	/**
	 * @param jp
	 * @param idUsuario
	 * @param tipoUsuario
	 * @param Name
	 * @param Tipo
	 * @param btn
	 */
	public ClickBuscar(JPanel jp, JTextField idUsuario, JComboBox<String> tipoUsuario, JLabel Name, JLabel Tipo, JButton btn) {
		this.jp		= jp;
		tipo		= Tipo;
		name		= Name;		
		jtfId		= idUsuario;
		string_tipo	= tipoUsuario;
		this.btn	= btn;
	}
/*--------------------------------------------------------------------------------------------------------*/	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		con = new ConexionSQL();
		consulta(jtfId.getText(), string_tipo.getSelectedItem().toString());
		
		if (btn.getText().equals("Modificar")){
			nPass.setEnabled(true);
			nName.setEnabled(true);
			nTipo.setEnabled(true);
			nId.setEnabled(true);
			
			id.repaint();
			pass.repaint();		
		}
		name.repaint();
		btn.setEnabled(true);	
	}
/*--------------------------------------------------------------------------------------------------------*/	
	/**
	 * @param ID
	 * @param string_tipo
	 */
	private void consulta(String ID, String string_tipo) {
		ResultSet rs = null;	Statement s = null;
		
		try {
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery ("select * from Usuarios where id = '"+ID+"'");
			rs.next();
			String Pass = rs.getString(2), Name = rs.getString(3);
			if (pass!=null){		
				id.setText(ID);
				pass.setText(Pass);				
			}
			name.setText(Name);
			tipo.setText(string_tipo);	
			con.con.close();
			
		} catch (SQLException e) {
		    JOptionPane.showMessageDialog(null, "No se encuentra encuentra los datos al buscar\n Error: "
		    		+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);	
			e.printStackTrace();
		}
	}
}
/*--------------------------------------------------------------------------------------------------------*/	