package View.Secretaria;
/*--------------------------------------------------------------------------------------------------------*/	
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import Model.User;

import View.Interfaz;
import View.PanelBase;
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
		this.user = user;	inicializar_pb0();
		inicializar_pb1();	
		inicializar_pb2();
	}
/*--------------------------------------------------------------------------------------------------------*/		
	private void inicializar_pb0() { 
		pb0.add(new JLabel("Id: "+ String.valueOf(user.getId())));
		pb0.add(new JLabel("Tipo de Usuario:\t "+ user.getTipoUsuario() +"\n"));
		pb0.add(new JLabel("Nombre:\t "+user.getName()+"\n"));		
	}
	private void inicializar_pb1() { 
		pb1.setLayout(null);
		tdh.setBounds(140,40,600,440);
		pb1.add(tdh);
	}
	private void inicializar_pb2() { 
		pb2.add(new JLabel ("Tipo de usuario"));pb2.add(cbTipo);
		pb2.add(new JLabel());
		pb2.add(new JLabel("Usuario"));			pb2.add(cbUsuarios);
		pb2.add(new JLabel());					pb2.add(Ver);
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

		return jtp;
	}
}
/*--------------------------------------------------------------------------------------------------------*/	

