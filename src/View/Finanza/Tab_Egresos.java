package View.Finanza;

import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Model.ConexionSQL;
import View.PanelBase;

/**
 * @author 
 *
 */
public class Tab_Egresos extends PanelBase {
	private static final long serialVersionUID = 1L;
		
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	ConexionSQL con;
	ResultSet rs = null;	Statement s = null;
	
	PanelBase panel_gastos,panel_egresos,impuestos_deudas,impuestos,deudas,mezcla_gasto_egresos;
	
	JTextField impuesto_1 = new JTextField();
	JTextField impuesto_2 = new JTextField();
	JTextField Deuda_1 = new JTextField();
	JTextField Deuda_2 = new JTextField();
	
	JLabel Impues_1 = new JLabel("Impuesto Total: ");
	JLabel Deud_1 = new JLabel("Deuda Total: ");
			
	JTable table,table_2;
	
	JScrollPane scrollPane,scrollPane_2;

	/**
	 * 
	 */
	public Tab_Egresos(){	
		super("../img/backgroundjtp.png");	
		setLayout(null);
		mezcla_gasto_egresos = new PanelBase();
		mezcla_gasto_egresos.setLayout(new GridLayout(2,0,0,0));
		mezcla_gasto_egresos.setBounds(6, 0, 918, 380);
		mezcla_gasto_egresos.add(panelegresos());
		mezcla_gasto_egresos.add(panelgastos());
		
		add(mezcla_gasto_egresos);
		add(panelPagos());
	}
/*--------------------------------------------------------------------------------------------------------*/		
	/**
	 * @return
	 */
	protected PanelBase panelegresos(){
		panel_egresos = new PanelBase();
		panel_egresos.setLayout(null);
		panel_egresos.setBorder(BorderFactory.createTitledBorder(linea, "Egresos por inversion"));

		DecimalFormat f = new DecimalFormat("###,###.##");
		
		String[] columnas = {"Fecha","Inversion en infraestructura","Inversion tecnologica","Inversion equipo medico","Total Egreso"};
		Object[][] filas = new Object[200][5];
		int fila=0;
		String fecha;
		
		try{
			con = new ConexionSQL();
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery("SELECT * FROM `Egresos Mensuales` ORDER BY ANO DESC,`Numero Mes`ASC");
			while(rs.next()){
				fecha=rs.getString(1)+" "+rs.getString(2);
				int II,IT,IE,TE=0;
				II=rs.getInt(4);
				IE=rs.getInt(5);
				IT=rs.getInt(6);
				TE=(TE+(II+IE+IT));
		
				filas[fila][0]=fecha;
				filas[fila][1]=f.format(II);
				filas[fila][2]=f.format(IT);
				filas[fila][3]=f.format(IE);
				
				filas[fila][4]=f.format(TE);
				fila++;
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
				
		table_2 = new JTable(filas,columnas);
		table_2.setFillsViewportHeight(true);
		table_2.setBackground(blanco);
		table_2.setOpaque(false);
		table_2.getTableHeader().setOpaque(false);
		table_2.getTableHeader().setBackground(navyblue);
		table_2.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		table_2.getTableHeader().setForeground(blanco);
	
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportView(table_2);
		scrollPane_2.setOpaque(false);
		scrollPane_2.getViewport().setOpaque(false);
		scrollPane_2.setBounds(2,20,914,170);
		panel_egresos.add(scrollPane_2);
		
		return (panel_egresos);
	}

	/**
	 * @return
	 */
	protected PanelBase panelgastos() {
		panel_gastos = new PanelBase();
		panel_gastos.setLayout(null);
		panel_gastos.setBorder(BorderFactory.createTitledBorder(linea, "Gastos"));
		DecimalFormat f = new DecimalFormat("###,###.##");

		String[] columnas = {"Fecha","Gastos Generales","Gastos de inventario","Gastos excepcionales","Total Gastos"};
		Object[][] filas = new Object[200][5];
		int fila=0;
		String fecha;
		
		try{
			con = new ConexionSQL();
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery("SELECT * FROM `Gastos Mensuales` ORDER BY ANO DESC,`Numero Mes`ASC");
			while(rs.next()){
				fecha=rs.getString(1)+" "+rs.getString(2);
				int GG,GI,GE,TG=0;
				GG=rs.getInt(4);
				GI=rs.getInt(5);
				GE=rs.getInt(6);
				TG=(TG+(GG+GI+GE));
		
				filas[fila][0]=fecha;
				filas[fila][1]=f.format(GG);
				filas[fila][2]=f.format(GI);
				filas[fila][3]=f.format(GE);
				
				filas[fila][4]=f.format(TG);
				fila++;
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
	
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(2,20,914,170);
		panel_gastos.add(scrollPane);
		
		return panel_gastos;
	}
	
	/**
	 * @return
	 */
	protected PanelBase panelPagos(){
		impuestos_deudas= new PanelBase();
		impuestos_deudas.setLayout(new GridLayout(0,2,0,0));
		impuestos_deudas.setBounds(5, 380, 918, 160);
		impuestos_deudas.setBorder(BorderFactory.createTitledBorder(linea, "Pagos"));
		
		impuestos= new PanelBase();
		impuestos.setLayout(null);
		impuestos.setBorder(BorderFactory.createTitledBorder(linea, "Impuestos"));
		DecimalFormat f = new DecimalFormat("###,###.##");
		int impuesto=0,deuda=0,impuestototal=0,deudatotal=0;
		try{
			con = new ConexionSQL();
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery("SELECT * FROM `Impuestos y Deudas`");
			while(rs.next()){
				impuesto=rs.getInt(2);//impuestos
				deuda=rs.getInt(3);//deudas
				
				impuestototal=impuestototal+impuesto;
				deudatotal=deudatotal+deuda;
			}
			impuesto_1.setText(f.format(impuestototal));
			Deuda_1.setText(f.format(deudatotal));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		Impues_1.setBounds(10,10, 120, 60);
	
		impuesto_1.setEditable(false);
		impuesto_1.setBounds(120,33,120,20);
		
		impuestos.add(Impues_1);
		impuestos.add(impuesto_1);
	
		impuestos_deudas.add(impuestos);
		
		deudas = new PanelBase();
		deudas.setLayout(null);
		deudas.setBorder(BorderFactory.createTitledBorder(linea, "Deudas"));

		Deud_1.setBounds(10, 10, 120, 60);
		Deuda_1.setBounds(120,30,120,20);
		Deuda_1.setEditable(false);

		
		deudas.add(Deud_1);
		deudas.add(Deuda_1);
	
		
		impuestos_deudas.add(deudas);
		
		return (impuestos_deudas);
	}
}


