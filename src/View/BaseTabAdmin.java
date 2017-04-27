package View;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class BaseTabAdmin extends PanelBase{
	
	private static final long serialVersionUID = 1L;	
	PanelBase conIzq= new PanelBase();
	PanelBase pM	= new PanelBase();
	PanelBase pE	= new PanelBase();
	PanelBase pA	= new PanelBase();
	Border 	linea 	= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	BaseTabAdmin(){
		super("img/backgroundjtp.png");
		
		pE.add(new JButton("Eliminar"));
		pM.add(new JButton("Modificar"));
		
		this.setLayout(new GridLayout(1,0));
		conIzq.setLayout(new GridLayout(0,1));
		
		conIzq.add(getpA());		conIzq.add(pE);	
		this.add(conIzq);	this.add(pM);
		
		pM.setBorder(linea);
		pA.setBorder(linea);
		pE.setBorder(linea);
		
	}

	public Border getLinea() {
		return linea;
	}

	public void setLinea(Border linea) {
		this.linea = linea;
	}

	public PanelBase getConIzq() {
		return conIzq;
	}

	public PanelBase getpM() {
		return pM;
	}

	public PanelBase getpE() {
		return pE;
	}

	public PanelBase getpA() {
		GridLayout g = new GridLayout(0,2);
		pA.setLayout(g);
		
		pA.add(new JLabel("Id: "));
		pA.add(new JTextField(""));
		pA.add(new JLabel("Pass: "));
		pA.add(new JTextField(""));
		pA.add(new JLabel("Nombre: "));
		pA.add(new JTextField(""));
		pA.add(new JLabel("Tipo de Usuario: "));
		pA.add(new JTextField(""));
		pA.add(new JLabel());
		pA.add(new JButton ("Agregar"));
		return pA;
	}
}
