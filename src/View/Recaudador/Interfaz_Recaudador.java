package View.Recaudador;
import javax.swing.BorderFactory;
/*--------------------------------------------------------------------------------------------------------*/	
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import Model.User;

import View.Interfaz;
import View.PanelBase;
/*--------------------------------------------------------------------------------------------------------*/	
@SuppressWarnings("serial")
public class Interfaz_Recaudador extends Interfaz {
	PanelBase	pb0, pb1;
	User	user;
/*--------------------------------------------------------------------------------------------------------*/	
	public Interfaz_Recaudador(User user){
		super("Recaudador",user.getId(),user.getName());
		this.user = user;
		inicializar_pb0();
		inicializar_pb1();
	}
/*--------------------------------------------------------------------------------------------------------*/	
	void inicializar_pb0(){
		PanelBase pb = new PanelBase();
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Datos personal"));
		pb.add(new JLabel("Id: "+ String.valueOf(user.getId())));
		pb.add(new JLabel("Tipo de Usuario:\t "+ user.getTipoUsuario() +"\n"));
		pb.add(new JLabel("Nombre:\t "+user.getName()+"\n"));
		pb0.add(pb);
	}
	void inicializar_pb1() {
	}
/*--------------------------------------------------------------------------------------------------------*/	
	@Override
	public JTabbedPane Paneles() {

		 pb0 = new PanelBase("img/backgroundjtp.png");
		 pb1 = new Tab_Pago(); 

		 jtp.addTab("Informaciones", null, pb0,"");
		 jtp.addTab("Pago", null, pb1,"");

		 jtp.setBackgroundAt(0, gris);
		 jtp.setBackgroundAt(1, gris);

		return jtp;
	}
}
/*--------------------------------------------------------------------------------------------------------*/	
