package View.Administrador;
/*--------------------------------------------------------------------------------------------------------*/	
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import View.PanelBase;
/*--------------------------------------------------------------------------------------------------------*/	
/**
 * @author Sebastian Joshua
 *
 */
public class Tab_Inventario  extends PanelBase{
	
	private static final long serialVersionUID = 1L;	
	
	PanelBase 	conIzq,pM,pE,pA;
	
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	String [] 	tipoInsumo 	= {null};
	String [] 	ids 		= {null};
	
	JTextField  nIdM  		= new JTextField(),
				nNameM 		= new JTextField(),
				nPrecioM	= new JTextField(),
				nIdA		= new JTextField(),
				nNameA 		= new JTextField(),
				nPrecioA 	= new JTextField();
	
	JSpinner 	nCantidadA 	= new JSpinner(),
				nCantidadM 	= new JSpinner(),
				nCantidadE 	= new JSpinner();
	
	JLabel		rTipoM 		= new JLabel("Tipo actual"),
				rIdM		= new JLabel("Id actual"),
				rNameM 		= new JLabel("Name actual"),
				rPrecioM 	= new JLabel("Precio actual"),
				rCantidadM 	= new JLabel("Cantidad actual"),
				ResultadoE1	= new JLabel("Datos resultado 1"),
				ResultadoE2	= new JLabel("Datos resultado 2");
	
	JButton		Modificar	= new JButton("Modificar"),
				Agregar 	= new JButton("Agregar"),
				Eliminar 	= new JButton("Eliminar");
	
	JComboBox<String>	comboUsersM = new JComboBox<String>(ids),
						comboUsersA = new JComboBox<String>(ids),
						comboUsersE = new JComboBox<String>(ids),
						comboTiposA = new JComboBox<String>(tipoInsumo),
						comboTiposM = new JComboBox<String>(tipoInsumo),
						comboTiposMN= new JComboBox<String>(tipoInsumo),
						comboTiposE = new JComboBox<String>(tipoInsumo);
/*--------------------------------------------------------------------------------------------------------*/	
	/**
	 * 
	 */
	public Tab_Inventario() {
		super("../img/backgroundjtp.png");		
		this.setLayout(new GridLayout(1,0));		
		this.add(getConIzq());
		this.add(getpM());
	}
/*--------------------------------------------------------------------------------------------------------*/		
	/**
	 * @return
	 */
	protected PanelBase getConIzq() {
		conIzq = new PanelBase();
		conIzq.setLayout(new GridLayout(0,1));
		conIzq.add(getpA());		
		conIzq.add(getpE());
		return conIzq;
	}
	
	/**
	 * @return
	 */
	protected PanelBase getpM() {
		pM = new PanelBase();
		PanelBase pb = new PanelBase();			GridLayout g = new GridLayout(0,2);
		pb.setLayout(null);						pM.setLayout(g);

		pM.add(new JLabel("Tipo de Insumo"));	pM.add(comboTiposM);
		pM.add(new JLabel("Id Insumo"));		pM.add(comboUsersM);
		pM.add(new JLabel());					pM.add(new JLabel());
		
		pM.add(new JLabel("Resultados:"));		pM.add(new JLabel());
		pM.add(rTipoM);							pM.add(comboTiposMN);
		pM.add(rIdM);							pM.add(nIdM);
		pM.add(rNameM);							pM.add(nNameM);
		pM.add(rPrecioM);						pM.add(nPrecioM);
		pM.add(rCantidadM);						pM.add(nCantidadM);
		pM.add(new JLabel());					pM.add(Modificar);

		pb.setBorder(BorderFactory.createTitledBorder(linea, "Modificar Insumo"));
		pM.setBounds(70,60,300,280);			pb.add(pM);
		return pb;
	}
	
	/**
	 * @return
	 */
	protected PanelBase getpE() {
		pE = new PanelBase();
		PanelBase pb = new PanelBase();			GridLayout g = new GridLayout(0,2);
		pb.setLayout(null);						pE.setLayout(g);

		pE.add(new JLabel("Tipo de Insumo"));	pE.add(comboTiposE);
		pE.add(new JLabel("Id Insumo"));		pE.add(comboUsersE);
		pE.add(new JLabel());					pE.add(new JLabel());
		pE.add(new JLabel("Resultados"));		pE.add(new JLabel());
		pE.add(ResultadoE1);					pE.add(ResultadoE2);
		pE.add(new JLabel());					pE.add(Eliminar);

		pb.setBorder(BorderFactory.createTitledBorder(linea, "Eliminar Insumo"));
		pE.setBounds(70,40,300,160);			pb.add(pE);		
		return pb;
	}
	
	/**
	 * @return
	 */
	protected PanelBase getpA() {
		pA = new PanelBase();
		PanelBase pb = new PanelBase();			pb.setLayout(null);		
		GridLayout g = new GridLayout(0,2);		pA.setLayout(g);	
		
		pA.add(new JLabel("Tipo de Insumo:"));	pA.add(comboTiposA);
		pA.add(new JLabel("Id Insumo: "));		pA.add(nIdA);
		pA.add(new JLabel("Nombre: "));			pA.add(nNameA);
		pA.add(new JLabel("Precio: "));			pA.add(nPrecioA);
		pA.add(new JLabel("Cantidad:"));		pA.add(nCantidadA);
		pA.add(new JLabel());					pA.add(Agregar);

		pb.setBorder(BorderFactory.createTitledBorder(linea, "Agregar Insumo"));
		pA.setBounds(70,40,300,150);			pb.add(pA);
		return pb;
	}
}
/*--------------------------------------------------------------------------------------------------------*/	