package View.Practicante;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import View.PanelBase;

public class Tab_horario extends PanelBase{
	private static final long serialVersionUID = 1L;
	
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

	public Tab_horario(){
		super("../img/backgroundjtp.png");	
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder(linea, "Atencion pacientes"));
	}
}
