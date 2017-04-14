package View;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class BaseTabAdmin extends PanelBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanelBase conIzq= new PanelBase();
	PanelBase pM	= new PanelBase();
	PanelBase pE	= new PanelBase();
	PanelBase pA	= new PanelBase();
	Border 	linea 	= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	BaseTabAdmin(){
		super("img/backgroundjtp.png");
		
		pA.add(new JButton ("Agregar"));
		pE.add(new JButton("Eliminar"));
		pM.add(new JButton("Modificar"));
		
		this.setLayout(new GridLayout(1,0));
		conIzq.setLayout(new GridLayout(0,1));
		
		conIzq.add(pA);		conIzq.add(pE);	
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
		return pA;
	}
}
