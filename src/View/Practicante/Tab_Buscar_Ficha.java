package View.Practicante;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import View.PanelBase;

public class Tab_Buscar_Ficha extends PanelBase {
private static final long serialVersionUID = 1L;
	
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	JLabel id_paciente = new JLabel("Identificacion:");
	
	JTextField id_pacint = new JTextField();

	JButton buscar = new JButton ("Buscar ficha");
	
	PanelBase panelbusqueda,panelresultado,panelmezcla;
	public Tab_Buscar_Ficha(){
		super("../img/backgroundjtp.png");	
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder(linea, "Buscar"));
		
		panelbusqueda = new PanelBase();
		panelbusqueda.setLayout(new GridLayout(0,2,0,20));
		panelbusqueda.setBounds(200, 20, 400, 80);
		
		id_paciente.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		
		panelbusqueda.add(id_paciente);
		panelbusqueda.add(id_pacint);
		panelbusqueda.add(buscar);
	
		panelresultado = new PanelBase();
		panelresultado.setLayout(null);
		panelresultado.setBounds(14, 140, 900,403);
		panelresultado.setBorder(BorderFactory.createTitledBorder(linea, "resultado"));

		add(panelresultado);
		add(panelbusqueda);
	}
}
