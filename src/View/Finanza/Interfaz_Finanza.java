package View.Finanza;
/*--------------------------------------------------------------------------------------------------------*/	
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import Model.User;

import View.Interfaz;
import View.PanelBase;
/*--------------------------------------------------------------------------------------------------------*/	
public class Interfaz_Finanza extends Interfaz{
	private static final long serialVersionUID = 1L;
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	User usuario;

	JLabel a,b,c;
	
	PanelBase	panel_base_1, panel_base_2,panel_base_3,panel_base_4,panel_base_5;
/*--------------------------------------------------------------------------------------------------------*/	
	public Interfaz_Finanza(User user){
		super("Administrador Financiero",user.getId(),user.getName());
		usuario=user;
		inicializar_pb0(panel_base_1,usuario);
		//inicializar_panel_base1();
	}
/*--------------------------------------------------------------------------------------------------------*/
public JTabbedPane Paneles() {
		panel_base_1 = new PanelBase("img/backgroundjtp.png");
		panel_base_3 = new Tab_Ingresos();
		panel_base_4 = new Tab_Egresos();
		panel_base_5 = new Tab_Fondo();

		jtp.addTab("Informaciones",panel_base_1);
		jtp.addTab("Ingresos",panel_base_3);
		jtp.addTab("Egresos",panel_base_4);
		jtp.addTab("Fondo",panel_base_5);
		return jtp;
	}
}
/*--------------------------------------------------------------------------------------------------------*/	