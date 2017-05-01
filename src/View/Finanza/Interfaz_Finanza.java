package View.Finanza;

import javax.swing.JTabbedPane;

import Model.User;
import View.Interfaz;
import View.PanelBase;

@SuppressWarnings("serial")
public class Interfaz_Finanza extends Interfaz{
	public Interfaz_Finanza(User user){
		super("Administrador Financiero",user.getId(),user.getName());
	}

	@Override
	public JTabbedPane Paneles() {

		 PanelBase pb0 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb1 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb2 = new PanelBase("img/backgroundjtp.png");

		 jtp.addTab("Informaciones", null, pb0,"");
		 jtp.addTab("Informaciones", null, pb1,"");
		 jtp.addTab("Gestionar", null, pb2,"");
		 
		 jtp.setBackgroundAt(0, gris);
		 jtp.setBackgroundAt(1, gris);
		 jtp.setBackgroundAt(2, gris);
		 
		return jtp;
	}

}
