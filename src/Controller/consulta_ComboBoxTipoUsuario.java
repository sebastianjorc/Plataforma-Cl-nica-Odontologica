package Controller;
/*--------------------------------------------------------------------------------------------------------*/	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mxrck.autocompleter.TextAutoCompleter;

import Model.ConexionSQL;
/*--------------------------------------------------------------------------------------------------------*/	
public class consulta_ComboBoxTipoUsuario implements ActionListener{
	JComboBox<?>cbTipo;
	String		tipo;
	TextAutoCompleter	tField;
	JTextField tfUsuario;
	ConexionSQL con;
	JButton btn;
/*--------------------------------------------------------------------------------------------------------*/	
	public consulta_ComboBoxTipoUsuario(JComboBox<String> cbtipo, TextAutoCompleter autoCompleterIdM, JTextField usuarioM, JButton buscar){		
		cbTipo		=cbtipo;
		tField		=autoCompleterIdM;
		tfUsuario	=usuarioM;
		btn			=buscar;
	}
/*--------------------------------------------------------------------------------------------------------*/	
	public void actionPerformed(ActionEvent e) {
		cbTipo	= (JComboBox<?>)e.getSource();
        tipo	= (String)cbTipo.getSelectedItem();
        consulta(tipo);
        tfUsuario.setEnabled(true);
        btn.setEnabled(true);
	}
/*--------------------------------------------------------------------------------------------------------*/	
	public void consulta(String tipo){
		ResultSet rs= null;
		Statement s	= null;
		con = new ConexionSQL();
		
		try {
			tField.removeAllItems();
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery ("select *from Usuarios where TIPO='"+tipo+"'");
			System.out.println(tipo);
			while (rs.next())
				tField.addItem(rs.getString(1));
			con.con.close();
			
		} catch (SQLException e) {
		    JOptionPane.showMessageDialog(null, "Error. No se encuentra el tipo de usuario\n "
		    		+ "en la base de datos\nError: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);	
			e.printStackTrace();
		}
	}
}
/*--------------------------------------------------------------------------------------------------------*/	