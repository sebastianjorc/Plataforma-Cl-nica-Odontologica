package View.Paciente;


import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JCalendar;

import View.PanelBase;

public class Tab_Calendario extends PanelBase {
	private static final long serialVersionUID = 1L;
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

	public Tab_Calendario(){
		super("../img/backgroundjtp.png");	
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder(linea,"Calendario"));

		JCalendar calendar = new JCalendar();
		calendar.setBounds(28, 33, 700, 500);
		calendar.setForeground(blanco);
		calendar.setDecorationBackgroundColor(blanco);
		calendar.setDecorationBackgroundVisible(true);
		
		add(calendar);
	}
}
