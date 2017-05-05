package View.Finanza;
/*--------------------------------------------------------------------------------------------------------*/	
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.Font;

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
		inicializar_panel_base1();
	}
/*--------------------------------------------------------------------------------------------------------*/
void inicializar_panel_base1(){		
	String ID = String.valueOf(usuario.getId());
	
	a=new JLabel("Id:  \t "+ID+".\n      ");
	a.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 18));
	
	b=new JLabel("Tipo de Usuario:  \t "+usuario.getTipoUsuario()+".\n      ");
	b.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 18));
	
	c=new JLabel("Nombre:  \t "+usuario.getName()+".\n");
	c.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 18));
	
	panel_base_1.add(a);
	panel_base_1.add(b);
	panel_base_1.add(c);
	panel_base_1.setBorder(BorderFactory.createTitledBorder(linea, "Datos del usuario"));
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