package View.Finanza;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import View.PanelBase;

public class Tab_Egresos extends PanelBase {
	private static final long serialVersionUID = 1L;
		
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	PanelBase panel_gastos,panel_egresos,impuestos_deudas,impuestos,deudas,mezcla_gasto_egresos;
	
	JTextField impuesto_1 = new JTextField();
	JTextField impuesto_2 = new JTextField();
	JTextField Deuda_1 = new JTextField();
	JTextField Deuda_2 = new JTextField();
	
	JLabel Impues_1 = new JLabel("Impuesto 1:");
	JLabel Impues_2= new JLabel("Impuesto 2:");
	JLabel Deud_1 = new JLabel("Deuda 1:");
	JLabel Deud_2 = new JLabel("Deuda 2:");
			
	JTable table,table_2;
	
	JScrollPane scrollPane,scrollPane_2;

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
	protected PanelBase panelegresos(){
		panel_egresos = new PanelBase();
		panel_egresos.setLayout(null);
		panel_egresos.setBorder(BorderFactory.createTitledBorder(linea, "Egresos por inversion"));

		DecimalFormat f = new DecimalFormat("###,###.##");
		
		int ii=1000,it=2000,iem=3000;
		int te=(ii+it+iem);
		
		String[] columnas = {"Fecha","Inversion en infraestructura","Inversion tecnologica","Inversion equipo medico","Total Egreso"};
		Object[][] filas = {{"Mayo"     ,f.format(ii),f.format(it),f.format(iem),f.format(te)},
							{"Abril"    ,f.format(ii),f.format(it),f.format(iem),f.format(te)},
							{"Marzo"    ,f.format(ii),f.format(it),f.format(iem),f.format(te)},};
				
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

	protected PanelBase panelgastos() {
		panel_gastos = new PanelBase();
		panel_gastos.setLayout(null);
		panel_gastos.setBorder(BorderFactory.createTitledBorder(linea, "Gastos"));
		DecimalFormat f = new DecimalFormat("###,###.##");
		
		int gh=1000,gg=2000,gi=3000,ge=404040;
		int totalg=(gh+gg+gi+ge);
		
		String[] columnas = {"Fecha","Gastos por recurso humano","Gastos Generales","Gastos de inventario","Gastos excepcionales","Total Gastos"};
		Object[][] filas = {{"Mayo"     ,f.format(gh),f.format(gg),f.format(gi),f.format(ge),f.format(totalg)},
							{"Abril"    ,f.format(gh),f.format(gg),f.format(gi),f.format(ge),f.format(totalg)},
							{"Marzo"    ,f.format(gh),f.format(gg),f.format(gi),f.format(ge),f.format(totalg)},};
				
		table = new JTable(filas,columnas);
		table.setFillsViewportHeight(true);
		table.setBackground(blanco);
		table.setOpaque(false);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(navyblue);
		table.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		table.getTableHeader().setForeground(blanco);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setPreferredWidth(18);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);
	
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(2,20,914,170);
		panel_gastos.add(scrollPane);
		
		return panel_gastos;
	}
	
	protected PanelBase panelPagos(){
		impuestos_deudas= new PanelBase();
		impuestos_deudas.setLayout(new GridLayout(0,2,0,0));
		impuestos_deudas.setBounds(5, 380, 918, 160);
		impuestos_deudas.setBorder(BorderFactory.createTitledBorder(linea, "Pagos"));
		
		impuestos= new PanelBase();
		impuestos.setLayout(null);
		impuestos.setBorder(BorderFactory.createTitledBorder(linea, "Impuestos"));
		
		Impues_1.setBounds(10,10, 80, 60);
		Impues_2.setBounds(10,60, 80, 60);
		impuesto_1.setEditable(false);
		impuesto_1.setBounds(100,33,120,20);
		impuesto_2.setEditable(false);
		impuesto_2.setBounds(100,81,120,20);
		
		impuestos.add(Impues_1);
		impuestos.add(Impues_2);
		impuestos.add(impuesto_1);
		impuestos.add(impuesto_2);
	
		impuestos_deudas.add(impuestos);
		
		deudas = new PanelBase();
		deudas.setLayout(null);
		deudas.setBorder(BorderFactory.createTitledBorder(linea, "Deudas"));
		
		
		Deud_1.setBounds(10, 10, 60, 60);
		Deud_2.setBounds(10, 60, 60, 60);
		Deuda_1.setBounds(80,30,120,20);
		Deuda_1.setEditable(false);
		Deuda_2.setBounds(80,81,120,20);
		Deuda_2.setEditable(false);
		
		deudas.add(Deud_1);
		deudas.add(Deud_2);
		deudas.add(Deuda_1);
		deudas.add(Deuda_2);
		
		impuestos_deudas.add(deudas);
		
		return (impuestos_deudas);
	}
}

