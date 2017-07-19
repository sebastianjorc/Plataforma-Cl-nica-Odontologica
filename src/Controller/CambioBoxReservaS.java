package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Model.ConexionSQL;

public class CambioBoxReservaS implements ItemListener{
	JComboBox<String> cbServicioss;
	JComboBox<String> cbPracticantess;
	
	ConexionSQL con;
	ResultSet rs = null;	Statement s = null;
	
	public CambioBoxReservaS(JComboBox<String> cbServicios, JComboBox<String> cbPracticantes) {
		cbServicioss=cbServicios;
		cbPracticantess=cbPracticantes;
	}

	public void itemStateChanged(ItemEvent h) {
		if ( h.getStateChange() == ItemEvent.SELECTED ){
			String stringdelbox2 = (String) cbServicioss.getSelectedItem();//corona de porcelana etc
			
			if((stringdelbox2.equals("Corona de porcelana"))||
				(stringdelbox2.equals("Corona de Zirconio"))||
				(stringdelbox2.equals("Blanqueamiento"))	)
			{
				try{
					con = new ConexionSQL();
					con.connect();
					s = con.con.createStatement();					
					rs = s.executeQuery ("select * from Practicantes where NIVEL = '9'");
					cbPracticantess.removeAllItems();
					while(rs.next()){
						String practicante = rs.getString(2);
						cbPracticantess.addItem(practicante);
					}
				con.con.close();
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, f);
				}
			}
			if(stringdelbox2.equals("Implantologia + porcelana atornillada")||
		       stringdelbox2.equals("Implantologia + zirconio atornillada"))
			{
				try{
					con = new ConexionSQL();
					con.connect();
					s = con.con.createStatement();		
					rs = s.executeQuery ("select * from Practicantes where NIVEL = '10'");
					cbPracticantess.removeAllItems();
					while(rs.next()){
						String practicante = rs.getString(2);
						cbPracticantess.addItem(practicante);
					}
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, f);
				}
			}	
			if(stringdelbox2.equals("Extracción dental")||
			   stringdelbox2.equals("Obsturacion dental")||
			   stringdelbox2.equals("Sellante de fosetas y fisuras"))
			{
				try{
					con = new ConexionSQL();
					con.connect();
					s = con.con.createStatement();		
					rs = s.executeQuery ("select * from Practicantes where NIVEL = '8'");
					cbPracticantess.removeAllItems();
					while(rs.next()){
						String practicante = rs.getString(2);
						cbPracticantess.addItem(practicante);
					}
					}catch(Exception f){
						JOptionPane.showMessageDialog(null, f);
					}
			}	
		if(stringdelbox2.equals("Higiene Oral")||
		   stringdelbox2.equals("Diagnostico general"))
		   {
				try{
					con = new ConexionSQL();
					con.connect();
					s = con.con.createStatement();		
					rs = s.executeQuery ("select * from Practicantes where NIVEL = '7'");
					cbPracticantess.removeAllItems();
					while(rs.next()){
						String practicante = rs.getString(2);
						cbPracticantess.addItem(practicante);
					}
					}catch(Exception f){
						JOptionPane.showMessageDialog(null, f);
					}
			}
		if(stringdelbox2.equals("Brackets (una arcada)")||
		   stringdelbox2.equals("Tratamiento de brackets"))
		   {
				try{
					con = new ConexionSQL();
					con.connect();
					s = con.con.createStatement();		
					rs = s.executeQuery ("select * from Practicantes where NIVEL = '11'");
					cbPracticantess.removeAllItems();
					while(rs.next()){
						String practicante = rs.getString(2);
						cbPracticantess.addItem(practicante);
					}
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, f);
				}
			}
		if(stringdelbox2.equals("Tratamiento conductos premolares")||
		   stringdelbox2.equals("Tratamiento conductos molares vitales")||
		   stringdelbox2.equals("Tratamiento gengivitis por sesion")||
		   stringdelbox2.equals("Tratamiento hipersensibilidad dentinaria")||
		   stringdelbox2.equals("Tratamiento de absceso periodontal"))
		   {
				try{
						con = new ConexionSQL();
						con.connect();
						s = con.con.createStatement();		
						rs = s.executeQuery ("select * from Practicantes where NIVEL = '12'");
						cbPracticantess.removeAllItems();
						while(rs.next()){
							String practicante = rs.getString(2);
							cbPracticantess.addItem(practicante);
						}
				}catch(Exception f){
					JOptionPane.showMessageDialog(null, f);
				}
			}
		}
	}		
}
