package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Interfaz extends JFrame implements Colores{
	private static final long serialVersionUID = 1L;
	protected PanelBase PanelContenedor;
	PanelBase pfa, pfc;
	
	public Interfaz(){		
		setResizable(false);
		setBackground(blanco);
		setTitle("Odontolog\u00EDa ULS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 76, 940, 600);
		PanelContenedor = new PanelBase();
		PanelContenedor.setBackground(blanco);
		setContentPane(PanelContenedor);
		
		LabelBase lu = new LabelBase ("Interfaz usuario: ");
		PanelContenedor.add(lu);
	}
	
	public Interfaz(String title, int id, String name){		
		
		setResizable(false);
		setBackground(blanco);
		setTitle("Odontolog\u00EDa ULS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 76, 940, 600);
		PanelContenedor = new PanelBase("logo_xl.png");
		PanelContenedor.setLayout(new BorderLayout());
		PanelContenedor.setBackground(blanco);
		setContentPane(PanelContenedor);

		pfa = new PanelBase();
		pfa.add(new LabelBase ("\tInterfaz usuario: "+title));
		pfa.add(new LabelBase ("\tId Usuario: "+id));
		pfa.add(new LabelBase ("\tnombre Usuario: "+name));		
		PanelContenedor.add(pfa,BorderLayout.NORTH);

		pfc = new PanelBase();
		pfc.setSize(300, 300);
		PanelContenedor.add(pfc);

	}
	
}