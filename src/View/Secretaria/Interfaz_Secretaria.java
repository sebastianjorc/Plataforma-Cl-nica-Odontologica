package View.Secretaria;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
/*--------------------------------------------------------------------------------------------------------*/	
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import com.toedter.calendar.JCalendar;

import Model.User;

import View.Interfaz;
import View.PanelBase;
import View.ScrollPaneBase;
import View.Toma_de_hora;
/*--------------------------------------------------------------------------------------------------------*/	
@SuppressWarnings("serial")
public class Interfaz_Secretaria extends Interfaz {
	PanelBase 	pb0,pb1,pb2;
	
	User 		user;
	
	String [] 	tiposUsuarios= {"Paciente","Practicante","Tutor"}; 
	String [] 	Usuarios	= {null}; 
	
	JButton		Ver			= new JButton("Ver calendario");
	
	Toma_de_hora tdh		= new Toma_de_hora();
	
	JComboBox<String> 	cbTipo		= new JComboBox<String>(tiposUsuarios),
 						cbUsuarios	= new JComboBox<String>(Usuarios);
/*--------------------------------------------------------------------------------------------------------*/	
	public Interfaz_Secretaria(User user){ 
		super("Secretaria",user.getId(),user.getName());
		this.user = user;	
		inicializar_pb0(pb0,user);
		inicializar_pb1();	
		inicializar_pb2();
	}
/*--------------------------------------------------------------------------------------------------------*/		
	private void inicializar_pb1() { 
		pb1.setLayout(null);
		tdh.setBounds(140,40,600,440);
		pb1.add(tdh);
	}
	private void inicializar_pb2() { 
		PanelBase pb = new PanelBase();
		pb2.setLayout(new BorderLayout());
		
		pb.add(new JLabel ("Tipo de usuario"));	pb.add(cbTipo);
		pb.add(new JLabel());
		pb.add(new JLabel("Usuario"));			pb.add(cbUsuarios);
		pb.add(new JLabel());					pb.add(Ver);
		
		ScrollPaneBase scpane = new ScrollPaneBase();		
		JCalendar calendar = new JCalendar();
		calendar.setForeground(blanco);
		calendar.setBounds(28, 33, 700, 500);		
		scpane.setViewportView(calendar);
		
		
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Buscar calendario"));
		scpane.setBorder(BorderFactory.createTitledBorder(linea, "Calendario"));
		
		pb2.add(pb,BorderLayout.NORTH);
		pb2.add(scpane,BorderLayout.CENTER);
		
		
		
	}
/*--------------------------------------------------------------------------------------------------------*/	
	public JTabbedPane Paneles() { 
		 
		 pb0 = new PanelBase("img/backgroundjtp.png");
		 pb1 = new PanelBase("img/backgroundjtp.png");
		 pb2 = new PanelBase("img/backgroundjtp.png");
		 
		 jtp.addTab("Informaciones", null, pb0,"");
		 jtp.addTab("Toma de hora", null, pb1,"");
		 jtp.addTab("Calendarios", null, pb2,"");
		 
		 jtp.setBackgroundAt(0, gris);
		 jtp.setBackgroundAt(1, gris);
		 jtp.setBackgroundAt(2, gris);

		 pb1.setBorder(BorderFactory.createTitledBorder(linea, "Toma de hora"));
		return jtp;
	}
}
/*--------------------------------------------------------------------------------------------------------*/	

