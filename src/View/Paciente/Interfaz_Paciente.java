package View.Paciente;

import javax.swing.JTabbedPane;

import Model.User;
import View.Interfaz;
import View.PanelBase;

@SuppressWarnings("serial")
public class Interfaz_Paciente extends Interfaz {
	public Interfaz_Paciente(User user){
		super("Paciente",user.getId(),user.getName());
	}

	@Override
	public JTabbedPane Paneles() {

		 PanelBase pb0 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb1 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb2 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb3 = new PanelBase("img/backgroundjtp.png");	 

		 jtp.addTab("Informaciones", null, pb0,"");
		 jtp.addTab("Toma de hora", null, pb1,"");
		 jtp.addTab("Calendario", null, pb2,"");
		 jtp.addTab("Ficha", null, pb3,""); 
		 
		 jtp.setBackgroundAt(0, gris);
		 jtp.setBackgroundAt(1, gris);
		 jtp.setBackgroundAt(2, gris);
		 jtp.setBackgroundAt(3, gris);

		return jtp;
	}

}