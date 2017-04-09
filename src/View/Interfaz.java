package View;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Interfaz extends JFrame implements Colores{
	private static final long serialVersionUID = 1L;
	Image 		Icono		= Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/icon1.png"));	
	
	protected PanelBase PanelContenedor;
	PanelBase pfa, pfc;

	public Interfaz(){
		this.setIconImage(Icono);
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
		this.setIconImage(Icono);
		setResizable(false);
		setBackground(blanco);
		setTitle("Odontolog\u00EDa ULS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 76, 940, 600);
		PanelContenedor = new PanelBase("img/logo_xl.png");
		PanelContenedor.setLayout(new BorderLayout());
		PanelContenedor.setBackground(blanco);
		setContentPane(PanelContenedor);
		PanelContenedor.add(Paneles());

	}
	
	public JTabbedPane Paneles (){
		 JTabbedPane jtp = new JTabbedPane();
		 
		 PanelBase pb1 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb2 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb3 = new PanelBase("img/backgroundjtp.png");
		 PanelBase pb4 = new PanelBase("img/backgroundjtp.png");		 
		 
		 jtp.addTab("Tab 1", null, pb1,"Does nothing");
		 jtp.addTab("Tab 2", null, pb2,"Does nothing");
		 jtp.addTab("Tab 3", null, pb3,"Does nothing");
		 jtp.addTab("Tab 4", null, pb4,"Does nothing");		 

		 jtp.setBackground(blanco);
		 jtp.setBackgroundAt(0, gris);
		 jtp.setBackgroundAt(1, gris);
		 jtp.setBackgroundAt(2, gris);
		 jtp.setBackgroundAt(3, gris);
		 

		 
		 return jtp;
		
	}
	
}