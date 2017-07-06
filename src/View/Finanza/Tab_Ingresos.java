package View.Finanza;
import java.awt.Font;

/*---------------------------------------------------------------------------------------------------------*/
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Model.ConexionSQL;

import java.text.DecimalFormat;

import View.PanelBase;
/*---------------------------------------------------------------------------------------------------------*/
public class Tab_Ingresos extends PanelBase{
	private static final long serialVersionUID = 1L;
	
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	JLabel HistorialIngresos;
	
	JTable table;
	
	ConexionSQL con;
	
	JScrollPane scrollPane;
/*---------------------------------------------------------------------------------------------------------*/	
	public Tab_Ingresos(){
		super("../img/backgroundjtp.png");	
		setBorder(BorderFactory.createTitledBorder(linea, "Historial de Ingresos"));
		setLayout(null);
		DecimalFormat f = new DecimalFormat("###,###.##");
		
		String AÑO,MES,DIA,NUMERO_DIA;
		int INGRESO;
//		System.out.println(AÑO+MES+DIA+NUMERO_DIA+INGRESO);
		
		con = new ConexionSQL();
		con.connect(); 
		
		
		
		
//		String[] columnas = {"Fecha","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo","Total Semanal"};
//		Object[][] filas = {{"2017 Junio 26 - 2" ,f.format(il),f.format(im),f.format(imi),f.format(ij),f.format(iv),f.format(is),f.format(id),f.format(totali)},
//							{"2017 Junio 19 - 25",f.format(il),f.format(im),f.format(imi),f.format(ij),f.format(iv),f.format(is),f.format(id),f.format(totali)}};
				
		String[] columnas = {"Fecha","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo","Total Semanal"};
		Object[][] filas = {{"2017 Junio 26 - 2" ,10,10,10,10,10,10,10,10},
							{"2017 Junio 19 - 25",10,10,10,10,10,10,10,10}};
		
		
		table = new JTable(filas,columnas);
		table.setFillsViewportHeight(true);
		table.setBackground(blanco);
		table.setOpaque(false);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(navyblue);
		table.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		table.getTableHeader().setForeground(blanco);
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(8).setPreferredWidth(78);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(40, 34, 850, 474);
		
		add(scrollPane);
	}
}
/*---------------------------------------------------------------------------------------------------------*/
