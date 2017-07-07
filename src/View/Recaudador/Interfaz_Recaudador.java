package View.Recaudador;
/*--------------------------------------------------------------------------------------------------------*/
import javax.swing.JTabbedPane;

import Model.User;

import View.Interfaz;
import View.PanelBase;
/*--------------------------------------------------------------------------------------------------------*/	
/**
 * @author
 *
 */
@SuppressWarnings("serial")
public class Interfaz_Recaudador extends Interfaz {
	PanelBase	pb0, pb1;
	User	user;
/*--------------------------------------------------------------------------------------------------------*/	
	/**
	 * @param user
	 */
	public Interfaz_Recaudador(User user){
		super("Recaudador",user.getId(),user.getName());
		this.user = user;
		inicializar_pb0(pb0,user);
		inicializar_pb1();
	}
/*--------------------------------------------------------------------------------------------------------*/	
	void inicializar_pb1() {
	}
/*--------------------------------------------------------------------------------------------------------*/	
	/* (non-Javadoc)
	 * @see View.Interfaz#Paneles()
	 */
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
