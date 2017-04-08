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
	public Interfaz(String title){		
		setResizable(false);
		setBackground(blanco);
		setTitle("Odontolog\u00EDa ULS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 76, 940, 600);
		PanelContenedor = new PanelFondo();
		PanelContenedor.setBackground(blanco);
		setContentPane(PanelContenedor);
		
		LabelBase lu = new LabelBase ("Interfaz usuacio: "+title);
		PanelContenedor.add(lu);
		PanelContenedor.setBackground();			
	}
	

}
