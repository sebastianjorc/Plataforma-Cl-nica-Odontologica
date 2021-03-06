package View.Administrador;
/*--------------------------------------------------------------------------------------------------------*/	
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import com.mxrck.autocompleter.TextAutoCompleter;

import Controller.CambioenBoxAdministrador;
import Controller.ClickAgregarUsuario;
import Controller.ClickBuscar;
import Controller.ClickEliminarUsuario;
import Controller.ClickModificarUsuario;
import Controller.consulta_ComboBoxTipoUsuario;
import View.PanelBase;
/*--------------------------------------------------------------------------------------------------------*/	
/**
 * @author Sebastian Joshua
 *
 */
public class Tab_Usuarios extends PanelBase{
	
	private static final long serialVersionUID = 1L;	
	Border 	linea 	= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	PanelBase 	conIzq,
				pM,
				pE,
				pA;
	String [] 	tiposusuario = {	"Administrador",
									"Administrador finanzas", 
									"Paciente", 
									"Practicante", 
									"Recaudador", 
									"Secretaria", 
									"Tutor"	};
	String  	tipo 	= null;
	
	JTextField  nIdM  	= new JTextField(),
				nNameM 	= new JTextField(),
				nPassM 	= new JTextField(),
				nIdA	= new JTextField(),
				nNameA 	= new JTextField(),
				nPassA	= new JTextField(),
				nNivel  = new JTextField(),
				usuarioM= new JTextField(),
				usuarioE = new JTextField(),
				usuarioA = new JTextField();
	
	JLabel		rTipoM 		= new JLabel("Tipo actual:"),
				rIdM		= new JLabel("Id actual:"),
				rNameM 		= new JLabel("Name actual:"),
				rPassM 		= new JLabel("Pass actual:"),
				ResultadoE1	= new JLabel("Datos resultado 1:"),
				ResultadoE2	= new JLabel("Datos resultado 2:");
	
	JButton		Modificar	= new JButton("Modificar"),
				Agregar 	= new JButton("Agregar"),
				Eliminar 	= new JButton("Eliminar"),
				buscarE		= new JButton("Buscar"),
				buscarM		= new JButton("Buscar");
	
	JComboBox<String>	comboTiposA = new JComboBox<String>(tiposusuario),
						comboTiposM = new JComboBox<String>(tiposusuario),
						comboTiposMN= new JComboBox<String>(tiposusuario),
						comboTiposE = new JComboBox<String>(tiposusuario);
	
	TextAutoCompleter 	AutoCompleterIdE  = new TextAutoCompleter(usuarioE),
						AutoCompleterIdM  = new TextAutoCompleter(usuarioM);
/*--------------------------------------------------------------------------------------------------------*/		
	/**
	 * 
	 */
	public Tab_Usuarios() {
		super("../img/backgroundjtp.png");		
		this.setLayout(new GridLayout(1,0));
		this.add(getConIzq());
		this.add(getpM());
		
		comboTiposM.addActionListener(new consulta_ComboBoxTipoUsuario(comboTiposM, AutoCompleterIdM,usuarioM,buscarM));
		comboTiposE.addActionListener(new consulta_ComboBoxTipoUsuario(comboTiposE, AutoCompleterIdE,usuarioE,buscarE));
		 
		buscarM.addActionListener(new ClickBuscar(pM,usuarioM,comboTiposM,rTipoM,rIdM,rNameM,rPassM,Modificar,comboTiposMN,nIdM,nNameM,nPassM));
		buscarE.addActionListener(new ClickBuscar(pE,usuarioE,comboTiposE,ResultadoE1,ResultadoE2,Eliminar));
		
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
		
		usuarioM.setEnabled(true);
		buscarM.setEnabled(true);
		comboTiposMN.setEnabled(true);
		nIdM.setEnabled(true);
		nNameM.setEnabled(true);
		nPassM.setEnabled(true);
		Modificar.setEnabled(true);
		
		pM.add(new JLabel("Tipo de Usuario:"));	pM.add(comboTiposM);
		pM.add(new JLabel("Id Usuario:"));		pM.add(usuarioM);
		pM.add(new JLabel());					pM.add(buscarM);
		pM.add(new JLabel());					pM.add(new JLabel());
		pM.add(new JLabel());					pM.add(new JLabel());
		
		pM.add(new JLabel("Resultados:"));		pM.add(new JLabel());
		pM.add(new JLabel());					pM.add(new JLabel());
		pM.add(new JLabel("Valor actual:"));	pM.add(new JLabel("Valor nuevo:"));
		pM.add(rTipoM);							pM.add(comboTiposMN);
		pM.add(rIdM);							pM.add(nIdM);
		pM.add(rNameM);							pM.add(nNameM);
		pM.add(rPassM);							pM.add(nPassM);
		pM.add(new JLabel());					pM.add(Modificar);
		

		Modificar.addActionListener(new ClickModificarUsuario(comboTiposMN,nIdM,nPassM,nNameM,nNivel,rTipoM,rIdM,rPassM,rNameM));
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Modificar usuario"));
		pM.setBounds(100,60,300,330);			pb.add(pM);
		return pb;
	}
	
	/**
	 * @return
	 */
	protected PanelBase getpE() {
		pE = new PanelBase();
		PanelBase pb = new PanelBase();			GridLayout g = new GridLayout(0,2);
		pb.setLayout(null);						pE.setLayout(g);
		
		usuarioE.setEnabled(true);
		buscarE.setEnabled(true);
		Eliminar.setEnabled(true);

		pE.add(new JLabel("Tipo de Usuario:"));	pE.add(comboTiposE);
		pE.add(new JLabel("Id Usuario:"));		pE.add(usuarioE);
		pE.add(new JLabel());					pE.add(buscarE);
		pE.add(new JLabel());					pE.add(new JLabel());
		pE.add(new JLabel("Resultados:"));		pE.add(new JLabel());
		pE.add(ResultadoE1);					pE.add(ResultadoE2);
		pE.add(new JLabel());					pE.add(Eliminar);
		
		Eliminar.addActionListener(new ClickEliminarUsuario(usuarioE));
		
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Eliminar usuario"));
		pE.setBounds(70,40,300,170);			pb.add(pE);		
		return pb;
	}
	
	/**
	 * @return
	 */
	
	protected PanelBase getpA() {
		pA = new PanelBase();
		PanelBase pb = new PanelBase();			pb.setLayout(null);		
		GridLayout g = new GridLayout(0,2);		pA.setLayout(g);	
		
		nIdA.setEnabled(true);
		nPassA.setEnabled(true);
		nNameA.setEnabled(true);
		nPassA.setEnabled(true);
		nNivel.setEnabled(false);
		Agregar.setEnabled(true);
		
		comboTiposA.addItemListener(new CambioenBoxAdministrador(nNivel,comboTiposA));
		
		pA.add(new JLabel("Tipo de Usuario:"));		pA.add(comboTiposA);
		pA.add(new JLabel("Id usuario: "));			pA.add(nIdA);
		pA.add(new JLabel("Contraseņa: "));			pA.add(nPassA);
		pA.add(new JLabel("Nombre:"));				pA.add(nNameA);
		pA.add(new JLabel("Nivel practicante:"));	pA.add(nNivel);	
		pA.add(new JLabel());					pA.add(Agregar);
		
		//implementar action
		Agregar.addActionListener(new ClickAgregarUsuario(comboTiposA,nIdA,nPassA,nNameA,nNivel));
		
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Agregar Usuario"));
		pA.setBounds(70,40,300,130);				pb.add(pA);
		return pb;
	}
}
/*--------------------------------------------------------------------------------------------------------*/	
