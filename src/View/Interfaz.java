package View;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interfaz extends JFrame {
	private static final long serialVersionUID = 1L;
	Color navyblue	= Color.decode("#0C3062");
	Color rojo		= Color.decode("#DA233F");
	Color celeste	= Color.decode("#84A1C6");
	Color gris		= Color.decode("#EAECEF");
	Color blanco	= Color.decode("#FBFCFE");

	ImageIcon ulsback=new ImageIcon(getClass().getResource("logo_xl.png"));

	protected JPanel PanelContenedor;
	
	public Interfaz(){
		
		setResizable(false);
		setBackground(blanco);
		setTitle("Odontolog\u00EDa ULS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 76, 940, 600);
		PanelContenedor = new JPanel();
		PanelContenedor.setBackground(blanco);
		setContentPane(PanelContenedor);
		
		JLabel lu = new JLabel ("Interfaz usuacio: ");
		PanelContenedor.add(lu);

		JLabel l = new JLabel();
		l.setIcon(ulsback);
		PanelContenedor.add(l);
	}

}
