package View;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import Model.User;

@SuppressWarnings("serial")
public class Interfaz_Tutor extends Interfaz {
	PanelBase	pb0, pb1;
	User	user;
	public Interfaz_Tutor(User user){
		super("Tutor",user.getId(),user.getName());
		this.user = user;
		inicializar_pb0();
		inicializar_pb1();
	}

	void inicializar_pb0(){		
		pb0.add(new LabelBase("Id: "+ String.valueOf(user.getId())));
		pb0.add(new LabelBase("Tipo de Usuario:\t "+ user.getTipoUsuario() +"\n"));
		pb0.add(new LabelBase("Nombre:\t "+user.getName()+"\n"));
	}
	
	void inicializar_pb1() {
		String [] practicantes = {"1","2","2","3","4"};
		PanelBase pb = new PanelBase();
		pb.add(new JLabel("Buscar Practicante"));
		pb.add(new JComboBox(practicantes));
		pb.add(new JLabel());
		pb.add(new JButton("Ver"));
		pb1.add(pb);		
		
	}

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