package View.Paciente;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import View.PanelBase;

public class Tab_Ficha extends PanelBase{
	private static final long serialVersionUID = 1L;

	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

	public Tab_Ficha(){
		super("../img/backgroundjtp.png");	
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder(linea, "Ficha paciente"));

	}
}
