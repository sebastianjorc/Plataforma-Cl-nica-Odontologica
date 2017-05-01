package View.Administrador;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import Model.User;
import View.Interfaz;
import View.PanelBase;

@SuppressWarnings("serial")
public class Interfaz_Administrador extends Interfaz {
	PanelBase	pb0, pb1,pb2,pb3;
	User	user;
	
	public Interfaz_Administrador(User user){
		super("Administrador",user.getId(),user.getName());
		this.user = user;
		inicializar_pb0();
		inicializar_pb1();
		inicializar_pb2();
		inicializar_pb3();
	}
	
	void inicializar_pb0(){		
		String ID = String.valueOf(user.getId());
		pb0.add(new JLabel("Id:\t "+ID+"\n"));
		pb0.add(new JLabel("Tipo de Usuario:\t "+user.getTipoUsuario()+"\n"));
		pb0.add(new JLabel("Nombre:\t "+user.getName()+"\n"));
	}
	
	void inicializar_pb1(){
	}
	
	void inicializar_pb2(){
	}
	
	void inicializar_pb3(){
	}

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
		 
		jtp.setBackgroundAt(0, gris);
		jtp.setBackgroundAt(1, gris);
		jtp.setBackgroundAt(2, gris);
		jtp.setBackgroundAt(3, gris);
		 
		 return jtp;
	}
}