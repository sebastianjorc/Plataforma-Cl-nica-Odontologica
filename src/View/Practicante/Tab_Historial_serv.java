package View.Practicante;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import View.PanelBase;

public class Tab_Historial_serv extends PanelBase {
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

	public Tab_Historial_serv(){	
		super("../img/backgroundjtp.png");	
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder(linea, "Historial"));
		
		DecimalFormat f = new DecimalFormat("###,###.##");
		
		String[] columnas = {"Fecha","Tipo de servicio","Servicio","Calificacion"};
		Object[][] filas = {{"Mayo 05"   ,"Estetica","Servicio de estetica 1",f.format(7.0)},
							{"Abril 13"  ,"Especialidad","Servicio de especialidad 1",f.format(6.3)},
							{"Marzo 20"  ,"Especialidad","Servicio de especialidad 2",f.format(7.0)},
							{"Febrero 2"  ,"Salud dental","Servicio de salud 1",f.format(7.0)},
							{"Enero 10"  ,"Especialidad","Servicio de especialidad 2",f.format(6.2)},
							{"Diciembre 24"  ,"Especialidad","Servicio de especialidad 2",f.format(6.1)}};
				
		table_2 = new JTable(filas,columnas);
		table_2.setFillsViewportHeight(true);
		table_2.setBackground(blanco);
		table_2.setOpaque(false);
		table_2.getTableHeader().setOpaque(false);
		table_2.getTableHeader().setBackground(navyblue);
		table_2.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		table_2.getTableHeader().setForeground(blanco);
		
		table_2.getColumnModel().getColumn(0).setPreferredWidth(10);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(5);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(5);

	
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportView(table_2);
		scrollPane_2.setOpaque(false);
		scrollPane_2.getViewport().setOpaque(false);
		scrollPane_2.setBounds(150,20,600,498);
		add(scrollPane_2);

	}
}
