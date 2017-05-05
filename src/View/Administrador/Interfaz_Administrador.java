package View.Administrador;
import javax.swing.BorderFactory;
/*--------------------------------------------------------------------------------------------------------*/
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import Model.User;

import View.Interfaz;
import View.PanelBase;
/*--------------------------------------------------------------------------------------------------------*/
public class Interfaz_Administrador extends Interfaz {
	private static final long serialVersionUID = 1L;
	PanelBase	pb0, pb1,pb2,pb3;
	User	user;
/*--------------------------------------------------------------------------------------------------------*/
	public Interfaz_Administrador(User user){
		super("Administrador",user.getId(),user.getName());
		this.user = user;
		inicializar_pb0();
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
/*--------------------------------------------------------------------------------------------------------*/
	@Override
	public JTabbedPane Paneles() {
		pb0 = new PanelBase("img/backgroundjtp.png");
		pb1 = new Tab_Usuarios();
		pb2 = new Tab_Servicios();
		pb3 = new Tab_Inventario();
		
		jtp.addTab("Informaciones", null, pb0,"");
		jtp.addTab("Usuarios", null, pb1,"");
		jtp.addTab("Servicios", null, pb2,""); 
		jtp.addTab("Inventario", null, pb3,"");
		 
		 return jtp;
	}
}
/*--------------------------------------------------------------------------------------------------------*/
