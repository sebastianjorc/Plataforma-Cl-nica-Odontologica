package View.Paciente;


import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JCalendar;

import Controller.ClickEnCalendario;

import View.PanelBase;
import View.ReservasEnCalendario;

public class Tab_Calendario extends PanelBase {
	private static final long serialVersionUID = 1L;
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	private JLabel a = new JLabel("Id:");
	private JLabel b = new JLabel("Tipo de servicio:");
	private JLabel c = new JLabel("Servicio:");
	private JLabel d = new JLabel("Profesional:");
	private JLabel e = new JLabel("Hora:");
	
	ReservasEnCalendario abc = new ReservasEnCalendario();
	
	PanelBase panel_1,panel_2;

	public static JTextField aa = new JTextField();
	public static JTextField bb = new JTextField();
	public static JTextField cc = new JTextField();
	public static JTextField dd = new JTextField();
	public static JTextField ee= new JTextField();

	public Tab_Calendario(){
		super("../img/backgroundjtp.png");	
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder(linea,"Calendario"));
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 24, 700, 500);
		calendar.getDayChooser().addDateEvaluator(abc);

		calendar.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 16));
		calendar.setForeground(blanco);
		calendar.setWeekOfYearVisible(false);
		
		
		calendar.setDecorationBackgroundColor(blanco);
		calendar.setDecorationBackgroundVisible(true);	
		calendar.setDecorationBordersVisible(true);

		
		calendar.addPropertyChangeListener("calendar",new ClickEnCalendario()); 

		add(calendar);
		
		panel_1 = new PanelBase();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder(linea, "Reserva de hora"));
		panel_1.setBounds(714, 14 , 213, 520);
		add(panel_1);
		
		a.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 14));
		b.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 14));
		c.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 14));
		d.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 14));
		e.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 14));
		
		aa.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 14));
		bb.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 14));
		cc.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 14));
		dd.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 14));
		ee.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 14));
		
		a.setBounds (750, 34 , 140, 20);
		aa.setBounds(750, 84 , 140, 20);
		aa.setEditable(false);
		
		
		b.setBounds (750, 134, 140, 20);
		bb.setBounds(750, 194 , 140, 20);
		bb.setEditable(false);
		
		c.setBounds (750, 234, 140, 20);
		cc.setBounds(750, 294 , 140, 20);
		cc.setEditable(false);
		
		d.setBounds (750, 334, 140, 20);
		dd.setBounds(750, 384 , 140, 20);
		dd.setEditable(false);
		
		e.setBounds (750, 434, 140, 20);
		ee.setBounds(750, 484 , 140, 20);
		ee.setEditable(false);
		
		add(a);add(b);add(c);add(d);add(e);
		add(aa);add(bb);add(cc);add(dd);add(ee);
		
		
	}
}
