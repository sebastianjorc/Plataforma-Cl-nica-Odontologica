package View.Administrador;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import View.PanelBase;

public class Tab_Servicios  extends PanelBase{
	
	private static final long serialVersionUID = 1L;	
	PanelBase conIzq,pM,pE,pA;
	Border 	linea 	= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	String [] tiposServicios = {	"General","Estetica","Especialidad"	};
	String [] ids = {"1","2","3"};
	
	public Tab_Servicios(){
		
		super("../img/backgroundjtp.png");
		this.setLayout(new GridLayout(1,0));		
		
		this.add(getConIzq());	
		this.add(getpM());
		
	}

	public Border getLinea() {
		return linea;
	}

	public void setLinea(Border linea) {
		this.linea = linea;
	}

	public PanelBase getConIzq() {		
		conIzq = new PanelBase();
		conIzq.setLayout(new GridLayout(0,1));
		conIzq.add(getpA());		
		conIzq.add(getpE());
		return conIzq;
	}

	public PanelBase getpM() {	
		pM = new PanelBase();
		PanelBase pb = new PanelBase();
		
		GridLayout g = new GridLayout(0,2);
		pb.setLayout(null);
		pM.setLayout(g);

		pM.add(new JLabel("Tipo de Servicio"));
		pM.add(new JComboBox(tiposServicios));
		pM.add(new JLabel("Id Servicio"));
		pM.add(new JComboBox(ids));
		pM.add(new JLabel());
		pM.add(new JLabel());
		pM.add(new JLabel("Resultados"));
		pM.add(new JLabel());
		pM.add(new JLabel("tipo actual"));
		pM.add(new JComboBox(tiposServicios));
		pM.add(new JLabel("id actual"));
		pM.add(new JTextField("Nuevo id"));
		pM.add(new JLabel("nombre actual"));
		pM.add(new JTextField("nombre nuevo"));
		pM.add(new JLabel("Precio actual"));
		pM.add(new JTextField("Precio nuevo"));
		pM.add(new JLabel());
		pM.add(new JButton ("Modificar"));

		pM.setBounds(120,60,260,280);
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Modificar Servicio"));
		pb.add(pM);
		
		return pb;

	}

	protected PanelBase getpE() {
		pE = new PanelBase();
		PanelBase pb = new PanelBase();
		
		GridLayout g = new GridLayout(0,2);
		pb.setLayout(null);
		pE.setLayout(g);

		pE.add(new JLabel("Tipo de Servicio"));
		pE.add(new JComboBox(tiposServicios));
		pE.add(new JLabel("Id Servicio"));
		pE.add(new JComboBox(ids));
	
		pE.add(new JLabel());
		pE.add(new JLabel());
		pE.add(new JLabel("Resultados"));
		pE.add(new JLabel());
		pE.add(new JLabel("Datos"));
		pE.add(new JLabel());
		pE.add(new JLabel());
		pE.add(new JButton ("Eliminar"));

		pE.setBounds(120,40,230,140);
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Eliminar Servicio"));
		pb.add(pE);
		
		return pb;
	}

	protected PanelBase getpA() {
		pA = new PanelBase();
		PanelBase pb = new PanelBase();
		pb.setLayout(null);
		
		GridLayout g = new GridLayout(0,2);
		pA.setLayout(g);		
		
		pA.add(new JLabel("Id Servicio: "));
		pA.add(new JTextField(""));
		pA.add(new JLabel("Precio: "));
		pA.add(new JTextField(""));
		pA.add(new JLabel("Nombre: "));
		pA.add(new JTextField(""));
		pA.add(new JLabel("Tipo de Servicio: "));
		pA.add(new JComboBox(tiposServicios));
		pA.add(new JLabel());
		pA.add(new JButton ("Agregar"));

		pA.setBounds(120,40,230,140);
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Agregar Servicio"));		pb.add(pA);
		
		
		return pb;
	}
}