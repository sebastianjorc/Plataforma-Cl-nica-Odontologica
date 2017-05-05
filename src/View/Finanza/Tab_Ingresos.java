package View.Finanza;
import java.awt.Font;

/*---------------------------------------------------------------------------------------------------------*/
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.text.DecimalFormat;

import View.PanelBase;
/*---------------------------------------------------------------------------------------------------------*/
public class Tab_Ingresos extends PanelBase{
	private static final long serialVersionUID = 1L;
	
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	JLabel HistorialIngresos;
	
	JTable table;
	
	JScrollPane scrollPane;
/*---------------------------------------------------------------------------------------------------------*/	
	public Tab_Ingresos(){
		super("../img/backgroundjtp.png");	
		setBorder(BorderFactory.createTitledBorder(linea, "Historial de Ingresos"));
		setLayout(null);
		DecimalFormat f = new DecimalFormat("###,###.##");
		//aca se van a obtener estos datos de la base de datos financiera; 
		//Lo de abajo es para ver la interfaz solamente. Tambien las fechas se obtendran de la BDD;
		int il=1000,im=2000,imi=3000,ij=404040,iv=238218,is=2392184,id=12381283;
		int totali=(il+im+imi+ij+iv+is+id);
		
		String[] columnas = {"Fecha","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo","Total Semanal"};
		Object[][] filas = {{"Mayo 01-07"     ,f.format(il),f.format(im),f.format(imi),f.format(ij),f.format(iv),f.format(is),f.format(id),f.format(totali)},
							{"Abril 24-30"    ,f.format(il),f.format(im),f.format(imi),f.format(ij),f.format(iv),f.format(is),f.format(id),f.format(totali)},
							{"Abril 17-23"    ,f.format(il),f.format(im),f.format(imi),f.format(ij),f.format(iv),f.format(is),f.format(id),f.format(totali)},
							{"Abril 10-16"    ,f.format(il),f.format(im),f.format(imi),f.format(ij),f.format(iv),f.format(is),f.format(id),f.format(totali)},
							{"Abril 3-9"      ,f.format(il),f.format(im),f.format(imi),f.format(ij),f.format(iv),f.format(is),f.format(id),f.format(totali)},
							{"Marzo 27-Abril 2",f.format(il),f.format(im),f.format(imi),f.format(ij),f.format(iv),f.format(is),f.format(id),f.format(totali)},
							{"Marzo 20-26"    ,f.format(il),f.format(im),f.format(imi),f.format(ij),f.format(iv),f.format(is),f.format(id),f.format(totali)},
							{"Marzo 13-19"    ,f.format(il),f.format(im),f.format(imi),f.format(ij),f.format(iv),f.format(is),f.format(id),f.format(totali)}};
				
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
