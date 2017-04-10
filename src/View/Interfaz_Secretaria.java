package View;

import javax.swing.JTabbedPane;

import Model.User;

@SuppressWarnings("serial")
public class Interfaz_Secretaria extends Interfaz {
	public Interfaz_Secretaria(User user){
		super("Secretaria",user.getId(),user.getName());
		
	}

	@Override
	public JTabbedPane Paneles() {
		 
		 PanelBase pb0 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb1 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb3 = new PanelBase("img/backgroundjtp.png");
		 
		 jtp.addTab("Informaciones", null, pb0,"");
		 jtp.addTab("Toma de hora", null, pb1,"");
		 jtp.addTab("Calendarios", null, pb3,"");
		 
		 jtp.setBackgroundAt(0, gris);
		 jtp.setBackgroundAt(1, gris);
		 jtp.setBackgroundAt(2, gris);

		return jtp;
	}

}
