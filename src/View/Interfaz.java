package View;
/*--------------------------------------------------------------------------------------------------------*/
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Controller.ClickCambiarImagen;
import Controller.ClickSalir;
import Model.User;
/*--------------------------------------------------------------------------------------------------------*/
public abstract class Interfaz extends JFrame implements Colores{
	private static final long serialVersionUID = 1L;
	
		  			Image Icono		= Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icon1.png"));	
		  protected PanelBase PanelContenedor;
		  protected JTabbedPane jtp = new JTabbedPane();
	      			JButton btnSalir = new JButton("Salir");

	      protected Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
/*--------------------------------------------------------------------------------------------------------*/
	public Interfaz(){
		this.setIconImage(Icono);
		setResizable(false);
		setBackground(blanco);
		setTitle("Odontolog\u00EDa asistencial docente - ULS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 76, 940, 600);
		PanelContenedor = new PanelBase();
		setContentPane(PanelContenedor);
	}
/*--------------------------------------------------------------------------------------------------------*/	
	public Interfaz(String title, int id, String name){	
		this.setIconImage(Icono);
		setResizable(false);
		setBackground(blanco);
		setTitle("Odontolog\u00EDa asistencial docente - ULS   ["+title+"] ["+name+"]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 76, 940, 600);
		PanelContenedor = new PanelBase("img/logo_xl.png");
		PanelContenedor.setLayout(new BorderLayout());
		PanelContenedor.setBackground(blanco);
		setContentPane(PanelContenedor);
		PanelContenedor.add(Paneles());
		btnSalir.addActionListener(new ClickSalir(this));
		btnSalir.setBackground(blanco);
		btnSalir.setForeground(navyblue);
		jtp.add(btnSalir,"Salir");
	}
/*--------------------------------------------------------------------------------------------------------*/
	@SuppressWarnings("static-access")
	protected void inicializar_pb0(PanelBase pb0, User user){		
		pb0.setLayout(new BorderLayout());
		
		PanelBase pIzq = new PanelBase();
		PanelBase pDatos = new PanelBase();
		JLabel jl = new JLabel();
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img=new ImageIcon(getClass().getResource("../img/perfil.png"));

		pIzq.setLayout(new BoxLayout(pIzq,BoxLayout.Y_AXIS));

		pDatos.setLayout(new BoxLayout(pDatos,BoxLayout.PAGE_AXIS));
		pDatos.add(Box.createRigidArea(new Dimension(0,2)));
		
		jl.setIcon(img);
		jl.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		pIzq.add(jl);
		
		JButton btnImagen = new JButton("Subir imagen de perfil");
		
		btnImagen.addActionListener(new ClickCambiarImagen(pIzq,jl));
		pIzq.add(btnImagen);		
		
		pDatos.setBorder(BorderFactory.createTitledBorder(linea, "Datos personales"));
		
		pDatos.add(new JLabel("Id: "+ String.valueOf(user.getId())));
		pDatos.add(new JLabel("Tipo de Usuario: "+ user.getTipoUsuario() +"\n"));
		pDatos.add(new JLabel("Nombre:\t "+user.getName()+"\n"));
		pIzq.add(pDatos);

		btnImagen.setAlignmentX(pIzq.CENTER_ALIGNMENT);
		jl.setAlignmentX(pIzq.CENTER_ALIGNMENT);
		pDatos.setAlignmentX(pIzq.CENTER_ALIGNMENT);

		pIzq.setBorder(BorderFactory.createTitledBorder(linea, "Perfil"));
		
		PanelBase pDer = new PanelBase();
		pDer.setBorder(BorderFactory.createTitledBorder(linea, "Informaciones"));
		pb0.add(pIzq,BorderLayout.WEST);
		pb0.add(pDer,BorderLayout.CENTER);
	}
/*--------------------------------------------------------------------------------------------------------*/
	abstract public JTabbedPane Paneles ();
/*--------------------------------------------------------------------------------------------------------*/
}