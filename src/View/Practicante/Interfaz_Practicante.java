package View.Practicante;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
/*--------------------------------------------------------------------------------------------------------*/	
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Model.User;
import View.Interfaz;
import View.PanelBase;
/*--------------------------------------------------------------------------------------------------------*/	
@SuppressWarnings("serial")
public class Interfaz_Practicante extends Interfaz {
/*--------------------------------------------------------------------------------------------------------*/	
	Border 		linea = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

	User usuario;
	
	PanelBase panel_base_1, panel_base_2,panel_base_3,panel_base_4,panel_base_5;

	
	JLabel a,b,c;

	public Interfaz_Practicante(User user){
		super("Practicante",user.getId(),user.getName());
		usuario=user;
		inicializar_pb0(panel_base_1,usuario);
		//inicializar_panel_base1();
	}
	
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
		
	}
/*--------------------------------------------------------------------------------------------------------*/	
	@Override
	public JTabbedPane Paneles() {
		 
		 panel_base_1 = new PanelBase("img/backgroundjtp.png");
		 panel_base_2 = new Tab_horario();
		 panel_base_3 = new Tab_Buscar_Ficha();
		 panel_base_4 = new Tab_Historial_serv();	 
		 
		 jtp.addTab("Informaciones", panel_base_1);
		 jtp.addTab("Horario", panel_base_2);
		 jtp.addTab("Buscar Ficha", panel_base_3); 
		 jtp.addTab("Historial de servicios", panel_base_4); 
		 panel_base_1.setBorder(BorderFactory.createTitledBorder(linea, "Datos personales"));
		 

		return jtp;
	}
}
/*--------------------------------------------------------------------------------------------------------*/	
