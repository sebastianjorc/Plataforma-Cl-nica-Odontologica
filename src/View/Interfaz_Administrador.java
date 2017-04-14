package View;

import javax.swing.JTabbedPane;

import Model.User;

@SuppressWarnings("serial")
public class Interfaz_Administrador extends Interfaz {
	PanelBase	pb0;
	BaseTabAdmin pb1,pb2,pb3;
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
		pb0.add(new LabelBase("Id:\t "+ID+"\n"));
		pb0.add(new LabelBase("Tipo de Usuario:\t "+user.getTipoUsuario()+"\n"));
		pb0.add(new LabelBase("Nombre:\t "+user.getName()+"\n"));
	}
	
	void inicializar_pb1(){
		pb1.getpE();
	}
	
	void inicializar_pb2(){
	}
	
	void inicializar_pb3(){
	}

	@Override
	public JTabbedPane Paneles() {
		pb0 = new PanelBase("img/backgroundjtp.png");
		pb1 = new BaseTabAdmin();
		pb2 = new BaseTabAdmin();
		pb3 = new BaseTabAdmin();
		
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