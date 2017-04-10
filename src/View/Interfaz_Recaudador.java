package View;

import javax.swing.JTabbedPane;

import Model.User;

@SuppressWarnings("serial")
public class Interfaz_Recaudador extends Interfaz {
	public Interfaz_Recaudador(User user){
		super("Recaudador",user.getId(),user.getName());
	}

	@Override
	public JTabbedPane Paneles() {

		 PanelBase pb0 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb1 = new PanelBase("img/backgroundjtp.png");	 

		 jtp.addTab("Informaciones", null, pb0,"");
		 jtp.addTab("Pago", null, pb1,"");

		 jtp.setBackgroundAt(0, gris);
		 jtp.setBackgroundAt(1, gris);

		return jtp;
	}

}
