package View.Finanza;
import java.awt.Font;
import java.sql.ResultSet;

/*---------------------------------------------------------------------------------------------------------*/
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.sql.Statement;

import Model.ConexionSQL;

import java.text.DecimalFormat;

import View.PanelBase;
/*---------------------------------------------------------------------------------------------------------*/
public class Tab_Ingresos extends PanelBase{
	private static final long serialVersionUID = 1L;
	
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	JLabel HistorialIngresos;
	
	JTable table,table_2;
	
	ConexionSQL con;
	
	JScrollPane scrollPane,scrollPane_2;
/*---------------------------------------------------------------------------------------------------------*/	
	public Tab_Ingresos(){
		super("../img/backgroundjtp.png");
		ResultSet rs = null;	Statement s = null;
		
		setBorder(BorderFactory.createTitledBorder(linea, "Historial de Ingresos"));
		setLayout(null);
		
		DecimalFormat f = new DecimalFormat("###,###.##");
		
		String[] columnas = {"Fecha","Ingreso"};
		Object[][] filas = new Object[200][2];
		
		try{
			con = new ConexionSQL();
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery("SELECT * FROM `Historial de ingresos` ORDER BY Mes,`Numero Dia`DESC");
			int ff=0,Ingreso;
			while(rs.next()){
				String Fecha=(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				Ingreso=rs.getInt(5);
				filas[ff][0]=Fecha;
				filas[ff][1]=f.format(Ingreso);
				ff++;
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
			
		table = new JTable(filas,columnas);
		table.setFillsViewportHeight(true);
		table.setBackground(blanco);
		table.setOpaque(false);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(navyblue);
		table.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		table.getTableHeader().setForeground(blanco);
		table.getColumnModel().getColumn(0).setPreferredWidth(140);	
		table.getColumnModel().getColumn(1).setPreferredWidth(50);	
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(40, 34, 380, 474);
		
		String[] columnass = {"Mes","Ingreso Total"};
		Object[][] filass = new Object[200][2];
		
		try{
			con = new ConexionSQL();
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery("SELECT * FROM `Historial de ingresos`");
			int ff=0,Ingreso=0,Ingresototal=0;
			boolean Mess=true;
			String MesAnterior=null,NuevoMes=null;
			while(rs.next()){
				if(Mess){
					MesAnterior=rs.getString(2);
					Mess=false;
				}
				NuevoMes=(rs.getString(2));
				if(NuevoMes.equals(MesAnterior)==false){
					filass[ff][0]=MesAnterior;
					filass[ff][1]=f.format(Ingresototal);
					MesAnterior=NuevoMes;
					Ingreso=0;Ingresototal=0;ff++;
				}
				Ingreso=rs.getInt(5);
				Ingresototal=Ingresototal+Ingreso;
			}
			filass[ff][0]=NuevoMes;
			filass[ff][1]=f.format(Ingresototal);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		table_2 = new JTable(filass,columnass);
		table_2.setFillsViewportHeight(true);
		table_2.setBackground(blanco);
		table_2.setOpaque(false);
		table_2.getTableHeader().setOpaque(false);
		table_2.getTableHeader().setBackground(navyblue);
		table_2.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		table_2.getTableHeader().setForeground(blanco);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(100);	
		table_2.getColumnModel().getColumn(1).setPreferredWidth(100);	
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportView(table_2);
		scrollPane_2.setOpaque(false);
		scrollPane_2.getViewport().setOpaque(false);
		scrollPane_2.setBounds(580, 34, 300, 474);
		
		add(scrollPane);
		add(scrollPane_2);
	}
}
/*---------------------------------------------------------------------------------------------------------*/
