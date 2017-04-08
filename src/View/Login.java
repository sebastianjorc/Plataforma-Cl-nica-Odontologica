package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Login extends JFrame  {
	private JPanel PanelContenedor;
	
	private JTextField Usuario = new JTextField();
	private JTextField Usuario_1 = new JTextField();
	
	JLabel IniciarSesion = new JLabel("Iniciar Sesi\u00F3n");
	JLabel RutUsuario = new JLabel("Rut Usuario");
	JLabel LogoUls = new JLabel();
	JLabel LoginDerecha = new JLabel();
	JLabel LoginIzquierda = new JLabel();
	
	ImageIcon a=new ImageIcon(getClass().getResource("Login Izquierda.jpg"));
	ImageIcon c=new ImageIcon(getClass().getResource("Login Derecha.jpg"));
	ImageIcon e=new ImageIcon(getClass().getResource("IniciarSesion.png"));
	ImageIcon g=new ImageIcon(getClass().getResource("LogoUls.png"));
	
	JButton BotonIniciar = new JButton();
	
	public Login(){
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("Odontolog\u00EDa ULS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 76, 940, 600);
		PanelContenedor = new JPanel();
		PanelContenedor.setBackground(Color.BLACK);
		PanelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelContenedor);
		PanelContenedor.setLayout(null);

		ImageIcon a=new ImageIcon(getClass().getResource("Plataforma-Cl-nica-Odontologica/Imagenes/Login Izquierda.jpg"));
		ImageIcon c=new ImageIcon(getClass().getResource("Plataforma-Cl-nica-Odontologica/Imagenes/Login Derecha.jpg"));
		ImageIcon e=new ImageIcon(getClass().getResource("Plataforma-Cl-nica-Odontologica/Imagenes/IniciarSesion.png"));
		ImageIcon g=new ImageIcon(getClass().getResource("Plataforma-Cl-nica-Odontologica/Imagenes/LogoUls.png"));
		
		LogoUls.setBounds(82, 23, 138, 137);
		ImageIcon h=new ImageIcon(g.getImage().getScaledInstance(LogoUls.getWidth(),LogoUls.getHeight(),Image.SCALE_DEFAULT));
		
		LogoUls.setIcon(h);
		PanelContenedor.add(LogoUls);
		
		
		IniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		IniciarSesion.setForeground(Color.BLACK);
		IniciarSesion.setFont(new Font("Book Antiqua", Font.BOLD, 24));
		IniciarSesion.setBounds(52, 180, 203, 29);
		PanelContenedor.add(IniciarSesion);
		
		JLabel RutUsuario = new JLabel("Rut Usuario");
		RutUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		RutUsuario.setForeground(Color.WHITE);
		RutUsuario.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		RutUsuario.setBounds(52, 229, 203, 21);
		PanelContenedor.add(RutUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		lblContrasea.setBounds(52, 292, 203, 21);
		PanelContenedor.add(lblContrasea);
		
		Usuario.setHorizontalAlignment(SwingConstants.CENTER);
		Usuario.setBounds(80, 261, 154, 20);
		PanelContenedor.add(Usuario);
		Usuario.setColumns(10);
		
		Usuario_1.setHorizontalAlignment(SwingConstants.CENTER);
		Usuario_1.setColumns(10);
		Usuario_1.setBounds(80, 324, 154, 20);
		PanelContenedor.add(Usuario_1);
		
		BotonIniciar.setBackground(Color.WHITE);
		BotonIniciar.setFont(new Font("MS Gothic", Font.BOLD, 18));
		BotonIniciar.setBounds(59, 409, 196, 65);
		ImageIcon f=new ImageIcon(e.getImage().getScaledInstance(210,68,Image.SCALE_DEFAULT));
		BotonIniciar.setIcon(f);
		PanelContenedor.add(BotonIniciar);			
		
		LoginDerecha.setBounds(302, 0, 632, 571);
		ImageIcon d=new ImageIcon(c.getImage().getScaledInstance(LoginDerecha.getWidth(),LoginDerecha.getHeight(),Image.SCALE_DEFAULT));
		LoginDerecha.setIcon(d);
		PanelContenedor.add(LoginDerecha);
		
		LoginIzquierda.setForeground(Color.WHITE);
		LoginIzquierda.setBounds(0, 0, 306, 571);
		ImageIcon b=new ImageIcon(a.getImage().getScaledInstance(LoginIzquierda.getWidth(),LoginIzquierda.getHeight(),Image.SCALE_DEFAULT));
		LoginIzquierda.setIcon(b);
		PanelContenedor.add(LoginIzquierda);
	}
}
