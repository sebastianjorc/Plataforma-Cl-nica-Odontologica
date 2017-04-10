package View;

import javax.swing.JTabbedPane;

import Model.User;

@SuppressWarnings("serial")
public class Interfaz_Tutor extends Interfaz {
	public Interfaz_Tutor(User user){
		super("Tutor",user.getId(),user.getName());
	}

	@Override
	public JTabbedPane Paneles() {
		 
		 PanelBase pb0 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb1 = new PanelBase("img/backgroundjtp.png"); 
		 
		 jtp.addTab("Informaciones", null, pb0,"");
		 jtp.addTab("Alumnos del nivel", null, pb1,"");
		 
		 jtp.setBackgroundAt(0, gris);
		 jtp.setBackgroundAt(1, gris);

		return jtp;
	}
}