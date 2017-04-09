package View;

import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.ClickLogin;

@SuppressWarnings("serial")
public class Login extends Interfaz  {
	
	private BaseTextField Usuario = new BaseTextField();
	private BaseTextField Usuario_1 = new BaseTextField();
	
	LabelBase IniciarSesion = new LabelBase("Iniciar Sesi\u00F3n");
	LabelBase RutUsuario = new LabelBase("Rut Usuario");
	LabelBase LogoUls = new LabelBase();
	LabelBase LoginDerecha = new LabelBase();
	LabelBase LoginIzquierda = new LabelBase();
	
	ImageIcon e=new ImageIcon(getClass().getResource("img/IniciarSesion.png"));
	ImageIcon g=new ImageIcon(getClass().getResource("img/LogoUls.png"));
	
	BaseButton BotonIniciar = new BaseButton();
	
	public Login(){
		
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
		
		LabelBase RutUsuario = new LabelBase("Rut Usuario");
		RutUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		RutUsuario.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		RutUsuario.setBounds(52, 229, 203, 21);
		PanelContenedor.add(RutUsuario);
		
		LabelBase lblContrasea = new LabelBase("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		BotonIniciar.addActionListener(new ClickLogin(Usuario, Usuario_1,BotonIniciar,this));
	}

	
}