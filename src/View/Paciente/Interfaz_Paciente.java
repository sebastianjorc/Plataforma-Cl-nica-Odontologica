package View.Paciente;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Model.User;

import View.Interfaz;
import View.PanelBase;
import View.Toma_de_hora;
/*--------------------------------------------------------------------------------------------------------*/	
@SuppressWarnings("serial")
public class Interfaz_Paciente extends Interfaz {
/*--------------------------------------------------------------------------------------------------------*/	
	Border 		linea = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	User usuario;

	JLabel a,b,c;
	
	Toma_de_hora toma_de_hora = new Toma_de_hora();
	
	PanelBase panel_base_1, panel_base_2,panel_base_3,panel_base_4,panel_base_5;
	
	public Interfaz_Paciente(User user){
		super("Paciente",user.getId(),user.getName());
		usuario=user;
		inicializar_panel_base1();
		inicializar_panel_base2();
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
	
	private void inicializar_panel_base2() { 
		panel_base_2.setLayout(null);
		toma_de_hora.setBounds(140,40,600,440);
		panel_base_2.add(toma_de_hora);
		panel_base_2.setBorder(BorderFactory.createTitledBorder(linea, "Toma de hora"));
	}
	
/*--------------------------------------------------------------------------------------------------------*/	
	@Override
	public JTabbedPane Paneles() {
		panel_base_1 = new PanelBase("img/backgroundjtp.png");
		panel_base_2 = new PanelBase("img/backgroundjtp.png");
		
		panel_base_3 = new Tab_Calendario();
		panel_base_4 = new Tab_Evaluar();	 
		panel_base_5 = new Tab_Ficha();	
		
		jtp.addTab("Informaciones",panel_base_1);
		jtp.addTab("Toma de hora",panel_base_2);
		jtp.addTab("Calendario",panel_base_3);
		jtp.addTab("Evaluar Atencion",panel_base_4);
		jtp.addTab("Ficha",panel_base_5); 

		panel_base_1.setBorder(BorderFactory.createTitledBorder(linea, "Datos personal"));

		return jtp;
	}
}
/*--------------------------------------------------------------------------------------------------------*/	
