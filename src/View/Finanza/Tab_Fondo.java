package View.Finanza;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import View.PanelBase;

public class Tab_Fondo extends PanelBase{
	private static final long serialVersionUID = 1L;

	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

	PanelBase a = new PanelBase();
	
	JTextField fondo_t = new JTextField();
	JTextField fondo_g = new JTextField();
	JTextField fondo_i = new JTextField();
	JTextField fondo_p = new JTextField();
	
	JLabel fondot=new JLabel("Fondo total:");//(10%)
	JLabel fondog=new JLabel("Fondo para gastos:");//(%60)
	JLabel fondoi=new JLabel("Fondo para inversion:");//(%15)
	JLabel fondop=new JLabel("Fondo preventivo:");//(%15 )
	
	public Tab_Fondo(){	
		super("../img/backgroundjtp.png");	
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder(linea,"Fondos"));
		
		fondot.setBounds(20, 16, 200, 30);
		fondot.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		add(fondot);

		fondog.setBounds(20, 52, 200, 30);
		fondog.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		add(fondog);
	
		fondoi.setBounds(20, 96, 200, 30);
		fondoi.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		add(fondoi);
		
		fondop.setBounds(20, 136, 200, 30);
		fondop.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		add(fondop);
		
		fondo_t.setBounds(260, 22, 140, 20);
		fondo_t.setEditable(false);
		add(fondo_t);
		
		fondo_g.setBounds(260, 58, 140, 20);
		fondo_g.setEditable(false);
		add(fondo_g);
		
		fondo_i.setBounds(260, 102, 140, 20);
		fondo_i.setEditable(false);
		add(fondo_i);
		
		fondo_p.setBounds(260, 143, 140, 20);
		fondo_p.setEditable(false);
		add(fondo_p);

	}
}
	/*
	Fondo
	//Fondo Total
	//Fondo para inversion
	Fondo para gastos
	Fondo preventivo
	*/

