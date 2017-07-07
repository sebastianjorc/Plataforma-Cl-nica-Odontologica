package View.Tutor;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
/*--------------------------------------------------------------------------------------------------------*/	
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import Model.User;

import View.Interfaz;
import View.PanelBase;
/*--------------------------------------------------------------------------------------------------------*/	
/**
 * @author Sebastian Joshua
 *
 */
@SuppressWarnings("serial")
public class Interfaz_Tutor extends Interfaz {
	PanelBase	pb0, 
				pb1;
	User		user;
	String [] 	practicantes 	= {null};
	
	JButton		Ver 			= new JButton("Ver");
	
	JComboBox<String> cbPracticantes;
/*--------------------------------------------------------------------------------------------------------*/	
	/**
	 * @param user
	 */
	public Interfaz_Tutor(User user){ 
		super("Tutor",user.getId(),user.getName());
		this.user = user;
		inicializar_pb0(pb0,user);		inicializar_pb1();
	}
/*--------------------------------------------------------------------------------------------------------*/
	/**
	 * 
	 */
	void inicializar_pb1() { 
		String[] alumnos = {"Alumno 1", "Alumno 2", "Alumno 3", "Alumno 4"};
		cbPracticantes = new JComboBox<String>(alumnos);
		PanelBase pb = new PanelBase();
		pb1.setLayout(new BorderLayout());
		pb.add(new JLabel("Buscar Practicante"));	pb.add(cbPracticantes);
		pb.add(new JLabel());						pb.add(Ver);
		
		PanelBase pbb = new PanelBase();
		String[] columnas = {"Nombre"};
		Object[][] filas = {{"Alumno 1"},
							{"Alumno 2"},
							{"Alumno 3"}};
		JTable table = new JTable(filas,columnas);
		table.setFillsViewportHeight(true);
		table.setBackground(blanco);
		table.setOpaque(false);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(navyblue);
		table.getTableHeader().setForeground(blanco);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(40, 34, 850, 474);
		
		pbb.add(scrollPane);
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Buscar practicante"));
		pbb.setBorder(BorderFactory.createTitledBorder(linea, "Datos de practicante"));
		
		
		pb1.add(pb, BorderLayout.NORTH);					
		pb1.add(pbb, BorderLayout.CENTER);

	}
/*--------------------------------------------------------------------------------------------------------*/	
	/* (non-Javadoc)
	 * @see View.Interfaz#Paneles()
	 */
	@Override
	public JTabbedPane Paneles() {
		 
		 pb0 = new PanelBase("img/backgroundjtp.png");
		 pb1 = new PanelBase("img/backgroundjtp.png"); 
		 
		 jtp.addTab("Informaciones", null, pb0,"");
		 jtp.addTab("Alumnos del nivel", null, pb1,"");
		 
		 jtp.setBackgroundAt(0, gris);
		 jtp.setBackgroundAt(1, gris);

		return jtp;
	}
}
/*--------------------------------------------------------------------------------------------------------*/	
