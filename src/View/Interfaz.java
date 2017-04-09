package View;


import javax.swing.JFrame;

public class Interfaz extends JFrame implements Colores{
	private static final long serialVersionUID = 1L;
	protected PanelFondo PanelContenedor;
	
	public Interfaz(){		
		setResizable(false);
		setBackground(blanco);
		setTitle("Odontolog\u00EDa ULS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 76, 940, 600);
		PanelContenedor = new PanelFondo();
		PanelContenedor.setBackground(blanco);
		setContentPane(PanelContenedor);
		
		LabelBase lu = new LabelBase ("Interfaz usuario: ");
		PanelContenedor.add(lu);
		PanelContenedor.setBackground();			
	}
	
	public Interfaz(String title, int id, String name){		
		setResizable(false);
		setBackground(blanco);
		setTitle("Odontolog\u00EDa ULS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 76, 940, 600);
		PanelContenedor = new PanelFondo();
		PanelContenedor.setBackground(blanco);
		setContentPane(PanelContenedor);
		
		PanelContenedor.add(new LabelBase ("\tInterfaz usuario: "+title));
		PanelContenedor.add(new LabelBase ("\tId Usuario: "+id));
		PanelContenedor.add(new LabelBase ("\tnombre Usuario: "+name));
		
		PanelContenedor.setBackground();
	}
	

}
