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
	Border		linea 			= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	String [] 	tiposServicios	= {	"General","Estetica","Especialidad"	};
	String [] 	ids				= {null};
	JTextField  nIdM  		= new JTextField(),
				nNameM 		= new JTextField(),
				nPrecioM	= new JTextField(),
				nIdA		= new JTextField(),
				nNameA 		= new JTextField(),
				nPrecioA	= new JTextField();
	JButton		Modificar	= new JButton("Modificar"),
				Agregar 	= new JButton("Agregar"),
				Eliminar 	= new JButton("Eliminar");
	JLabel		rTipoM 		= new JLabel("Tipo actual"),
				rIdM		= new JLabel("Id actual"),
				rNameM 		= new JLabel("Name actual"),
				rPrecioM	= new JLabel("Precio actual"),
				ResultadoE1	= new JLabel("Datos resultado 1"),
				ResultadoE2	= new JLabel("Datos resultado 2");
	JComboBox<String>	comboServiciosM = new JComboBox<String>(ids),
						comboServiciosA = new JComboBox<String>(ids),
						comboServiciosE = new JComboBox<String>(ids),
						comboTiposA 	= new JComboBox<String>(tiposServicios),
						comboTiposM 	= new JComboBox<String>(tiposServicios),
						comboTiposMN	= new JComboBox<String>(tiposServicios),
						comboTiposE 	= new JComboBox<String>(tiposServicios);	
	
	public Tab_Servicios(){		
		super("../img/backgroundjtp.png");
		this.setLayout(new GridLayout(1,0));		
		this.add(getConIzq());	this.add(getpM());		
	}
	protected PanelBase getConIzq() {
		conIzq = new PanelBase();	conIzq.setLayout(new GridLayout(0,1));
		conIzq.add(getpA());		conIzq.add(getpE());
		return conIzq;
	}
	protected PanelBase getpM() {
		pM = new PanelBase();		PanelBase pb = new PanelBase();
		GridLayout g = new GridLayout(0,2);
		pb.setLayout(null);		pM.setLayout(g);

		pM.add(new JLabel("Tipo de Servicio"));	pM.add(comboTiposM);
		pM.add(new JLabel("Id Servicio"));		pM.add(comboServiciosM);
		pM.add(new JLabel());					pM.add(new JLabel());
		pM.add(new JLabel("Resultados"));		pM.add(new JLabel());
		pM.add(rTipoM);							pM.add(comboTiposMN);
		pM.add(rIdM);							pM.add(nIdM);
		pM.add(rNameM);							pM.add(nNameM);
		pM.add(rPrecioM);						pM.add(nPrecioM);
		pM.add(new JLabel());					pM.add(Modificar);

		pb.setBorder(BorderFactory.createTitledBorder(linea, "Modificar Servicio"));
		pM.setBounds(120,60,260,280);				pb.add(pM);		
		return pb;

	}
	protected PanelBase getpE() {
		pE = new PanelBase();
		PanelBase pb = new PanelBase();	GridLayout g = new GridLayout(0,2);
		pb.setLayout(null);				pE.setLayout(g);

		pE.add(new JLabel("Tipo de Servicio"));	pE.add(comboTiposE);
		pE.add(new JLabel("Id Servicio"));		pE.add(comboServiciosE);	
		pE.add(new JLabel());					pE.add(new JLabel());
		
		pE.add(new JLabel("Resultados"));		pE.add(new JLabel());
		pE.add(ResultadoE1);					pE.add(ResultadoE2);
		pE.add(new JLabel());					pE.add(Eliminar);

		pb.setBorder(BorderFactory.createTitledBorder(linea, "Eliminar Servicio"));
		pE.setBounds(120,40,230,140);			pb.add(pE);		
		return pb;
	}
	protected PanelBase getpA() {
		pA = new PanelBase();
		PanelBase pb = new PanelBase();			pb.setLayout(null);		
		GridLayout g = new GridLayout(0,2);		pA.setLayout(g);	
		
		pA.add(new JLabel("Tipo de Servicio:"));pA.add(comboTiposA);
		pA.add(new JLabel("Id Servicio: "));	pA.add(nIdA);
		pA.add(new JLabel("Precio: "));			pA.add(nPrecioA);
		pA.add(new JLabel("Nombre: "));			pA.add(nNameA);
		pA.add(new JLabel());					pA.add(Agregar);

		pb.setBorder(BorderFactory.createTitledBorder(linea, "Agregar Servicio"));	
		pA.setBounds(120,40,230,140);			pb.add(pA);
		
		
		return pb;
	}

}