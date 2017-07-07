package View.Login;
/*--------------------------------------------------------------------------------------------------------*/
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.ClickLogin;
import Controller.SkipList;
import View.Interfaz;
/*--------------------------------------------------------------------------------------------------------*/
/**
 * @author
 *
 */
@SuppressWarnings("serial")
public class Login extends Interfaz  {
	
	private JTextField Usuario = new JTextField();
	private JPasswordField Usuario_1 = new JPasswordField();
	
	JLabel IniciarSesion = new JLabel("Iniciar Sesi\u00F3n");
	JLabel RutUsuario = new JLabel("Rut Usuario");
	JLabel LogoUls = new JLabel();
	JLabel LoginDerecha = new JLabel();
	JLabel LoginIzquierda = new JLabel();
	
	ImageIcon e=new ImageIcon(getClass().getResource("../img/IniciarSesion.png"));
	ImageIcon g=new ImageIcon(getClass().getResource("../img/LogoUls.png"));
	
	JButton BotonIniciar = new JButton();
	SkipList skiplist;
/*--------------------------------------------------------------------------------------------------------*/
	/**
	 * @param sl
	 */
	public Login(SkipList sl){
		skiplist = sl;
		
		PanelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));		
		PanelContenedor.setLayout(null);
		PanelContenedor.setBackground("img/backgroundLogin.png");
		
		LogoUls.setBounds(82, 23, 138, 137);
		ImageIcon h=new ImageIcon(g.getImage().getScaledInstance(LogoUls.getWidth(),LogoUls.getHeight(),Image.SCALE_DEFAULT));
		
		LogoUls.setIcon(h);
		PanelContenedor.add(LogoUls);
		
		IniciarSesion.setForeground(rojo);
		IniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		IniciarSesion.setFont(new Font("Book Antiqua", Font.BOLD, 24));
		IniciarSesion.setBounds(52, 180, 203, 29);
		PanelContenedor.add(IniciarSesion);
		
		JLabel RutUsuario = new JLabel("Rut Usuario");
		RutUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		RutUsuario.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		RutUsuario.setBounds(52, 229, 203, 21);
		PanelContenedor.add(RutUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		lblContrasea.setBounds(52, 292, 203, 21);
		PanelContenedor.add(lblContrasea);
		
		Usuario.setHorizontalAlignment(SwingConstants.CENTER);
		Usuario.setBackground(gris);
		Usuario.setBounds(80, 261, 154, 20);
		PanelContenedor.add(Usuario);
		Usuario.setColumns(10);
		
		Usuario_1.setBackground(gris);
		Usuario_1.setHorizontalAlignment(SwingConstants.CENTER);
		Usuario_1.setColumns(10);
		Usuario_1.setBounds(80, 324, 154, 20);
		PanelContenedor.add(Usuario_1);
		
		BotonIniciar.setBackground(blanco);
		BotonIniciar.setBorder(null);
		BotonIniciar.setFont(new Font("MS Gothic", Font.BOLD, 18));
		BotonIniciar.setBounds(59, 409, 196, 78);
		ImageIcon f=new ImageIcon(e.getImage().getScaledInstance(196,78,Image.SCALE_DEFAULT));
		BotonIniciar.setIcon(f);
		PanelContenedor.add(BotonIniciar);			
		
		LoginDerecha.setBounds(302, 0, 632, 571);
		PanelContenedor.add(LoginDerecha);
		
		LoginIzquierda.setBounds(0, 0, 306, 571);
		PanelContenedor.add(LoginIzquierda);
		
		BotonIniciar.addActionListener(new ClickLogin(Usuario, Usuario_1,BotonIniciar,this,sl));
	}
public JTextField getUsuario() {
		return Usuario;
	}
	public JPasswordField getUsuario_1() {
		return Usuario_1;
	}
	public JLabel getIniciarSesion() {
		return IniciarSesion;
	}
	public JLabel getRutUsuario() {
		return RutUsuario;
	}
	public JLabel getLogoUls() {
		return LogoUls;
	}
	public JLabel getLoginDerecha() {
		return LoginDerecha;
	}
	public JLabel getLoginIzquierda() {
		return LoginIzquierda;
	}
	public ImageIcon getE() {
		return e;
	}
	public ImageIcon getG() {
		return g;
	}
	public JButton getBotonIniciar() {
		return BotonIniciar;
	}
	public SkipList getSkiplist() {
		return skiplist;
	}
	/*--------------------------------------------------------------------------------------------------------*/
	@Override
	public JTabbedPane Paneles() {
		// TODO Auto-generated method stub
		return null;
	}
}
/*--------------------------------------------------------------------------------------------------------*/
