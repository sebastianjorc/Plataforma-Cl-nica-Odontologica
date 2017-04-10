package View;

import javax.swing.JTabbedPane;

import Model.User;

@SuppressWarnings("serial")
public class Interfaz_Administrador extends Interfaz {
	public Interfaz_Administrador(User user){
		super("Administrador",user.getId(),user.getName());
	}

	@Override
	public JTabbedPane Paneles() {

		 PanelBase pb0 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb1 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb2 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb3 = new PanelBase("img/backgroundjtp.png");	 

		 jtp.addTab("Informaciones", null, pb0,"");
		 jtp.addTab("Usuarios", null, pb1,"");
		 jtp.addTab("Inventario", null, pb2,"");
		 jtp.addTab("Servicios", null, pb3,""); 
		 
		 jtp.setBackgroundAt(0, gris);
		 jtp.setBackgroundAt(1, gris);
		 jtp.setBackgroundAt(2, gris);
		 jtp.setBackgroundAt(3, gris);
		 
		 return jtp;
	}

}