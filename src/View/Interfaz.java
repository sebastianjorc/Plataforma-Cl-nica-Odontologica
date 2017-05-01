package View;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import Controller.ClickSalir;

public abstract class Interfaz extends JFrame implements Colores{
	private static final long serialVersionUID = 1L;
	Image 		Icono		= Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icon1.png"));	
	
	protected PanelBase PanelContenedor;
	protected JTabbedPane jtp = new JTabbedPane();
	PanelBase pfa, pfc;
	BaseButton btnSalir = new BaseButton("Salir");

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
		btnSalir.addActionListener(new ClickSalir(this));

	}
	
	public Interfaz(String title, int id, String name){	
		this.setIconImage(Icono);
		setResizable(false);
		setBackground(blanco);
		setTitle("Odontolog\u00EDa ULS   ["+title+"] ["+name+"]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 76, 940, 600);
		PanelContenedor = new PanelBase("img/logo_xl.png");
		PanelContenedor.setLayout(new BorderLayout());
		PanelContenedor.setBackground(blanco);
		setContentPane(PanelContenedor);
		PanelContenedor.add(Paneles());
		btnSalir.addActionListener(new ClickSalir(this));
		jtp.add(btnSalir,"Salir");

	}
	
	abstract public JTabbedPane Paneles ();
	
	
}