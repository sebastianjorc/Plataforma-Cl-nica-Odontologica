package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Model.ConexionSQL;

public class CambioenBoxReserva implements ItemListener{
	JComboBox<String> cbTipoServicioo;
	JComboBox<String> cbServicioss=null;
	JComboBox<String> cbPracticantess;
	JComboBox<String> cbHorarioss;
	
	ConexionSQL con;
	ResultSet rs = null;	Statement s = null;
	
	public CambioenBoxReserva(JComboBox<String> cbTipoServicio, JComboBox<String> cbServicios, JComboBox<String> cbPracticantes, JComboBox<String> cbHorarios) {
		cbTipoServicioo=cbTipoServicio;
		cbServicioss=cbServicios;
		cbPracticantess=cbPracticantes;
		cbHorarioss=cbHorarios;
	}

	public void itemStateChanged(ItemEvent h) {
		if ( h.getStateChange() == ItemEvent.SELECTED ){
			String stringdelbox = (String) cbTipoServicioo.getSelectedItem();
			
			if(stringdelbox.equals("Estetica")){
				try{
					con = new ConexionSQL();
					con.connect();
					s = con.con.createStatement();	
					rs = s.executeQuery ("select * from Servicios where TIPO_SERVICIO = 'Estetica'");
					cbServicioss.removeAllItems();
					while(rs.next()){
						String id = rs.getString(1);
						cbServicioss.addItem(id); 
					}
					con.con.close();
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, f);
				}	
	//			cbServicioss.addItemListener(new CambioBoxReservaS(cbServicioss,cbPracticantess, cbHorarioss));
				try{
					con = new ConexionSQL();
					con.connect();
					s = con.con.createStatement();
					rs = s.executeQuery("SELECT * FROM `BloquesReserva`");
					cbHorarioss.removeAllItems();
					while(rs.next()){
						String hora = rs.getString(1);
						cbHorarioss.addItem(hora); ;
					}
					con.con.close();
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, f);
				}
			}
			if(stringdelbox.equals("Especialidad")){
				try{
					con = new ConexionSQL();
					con.connect();
					s = con.con.createStatement();
					rs = s.executeQuery(
"select * from Servicios where TIPO_SERVICIO = 'Endodoncia' or TIPO_SERVICIO = 'Ortodoncia' or TIPO_SERVICIO =  'Peridoncia'");
					cbServicioss.removeAllItems();
					while(rs.next()){
						String id = rs.getString(1);
						cbServicioss.addItem(id); 
					}
					con.con.close();
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, f);
				}
				try{
					con = new ConexionSQL();
					con.connect();
					s = con.con.createStatement();
					rs = s.executeQuery("SELECT * FROM `BloquesReserva`");
					cbHorarioss.removeAllItems();
					while(rs.next()){
						String hora = rs.getString(1);
						cbHorarioss.addItem(hora); ;
					}
					con.con.close();
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, f);
				}
			}
			if(stringdelbox.equals("General")){
				try{
					con = new ConexionSQL();
					con.connect();
					s = con.con.createStatement();
					rs = s.executeQuery("select * from Servicios where TIPO_SERVICIO = 'General'");
					cbServicioss.removeAllItems();
					while(rs.next()){
						String id = rs.getString(1);
						cbServicioss.addItem(id); 
					}
					con.con.close();
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, f);
				}
				try{
					con = new ConexionSQL();
					con.connect();
					s = con.con.createStatement();
					rs = s.executeQuery("SELECT * FROM `BloquesReserva`");
					cbHorarioss.removeAllItems();
					while(rs.next()){
						String hora = rs.getString(1);
						cbHorarioss.addItem(hora); ;
					}
					con.con.close();
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, f);
				} 
			}
		}
	}
}

	