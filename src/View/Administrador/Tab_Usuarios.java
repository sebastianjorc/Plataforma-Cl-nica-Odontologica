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

public class Tab_Usuarios extends PanelBase{
	
	private static final long serialVersionUID = 1L;	
	PanelBase conIzq,pM,pE,pA;
	Border 	linea 	= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	String [] tiposUsuarios = {	"Administrador",
			"Administrador finanzas", 
			"Paciente", 
			"Practicante", 
			"Recaudador", 
			"Secretaria", 
			"Tutor"	};
	String [] ids = {null};
	
	JComboBox 	comboUsersM  = new JComboBox(ids),
				comboUsersA  = new JComboBox(ids),
				comboUsersE  = new JComboBox(ids),
				comboTipesA  = new JComboBox(tiposUsuarios),
				comboTipesM  = new JComboBox(tiposUsuarios),
				comboTipesMN = new JComboBox(tiposUsuarios),
				comboTipesE  = new JComboBox(tiposUsuarios);

	JLabel		rTipo 	= new JLabel("Tipo actual"),
				rId		= new JLabel("Id actual"),
				rName  	= new JLabel("Name actual"),
				rPass  	= new JLabel("Pass actual");
	
	JTextField  nId  	= new JTextField(),
				nName  	= new JTextField(),
				nPass  	= new JTextField();
	
	JButton		Modificar	= new JButton("Modificar"),
				Agregar 	= new JButton("Agregar"),
				Eliminar 	= new JButton("Eliminar");
	
	public Tab_Usuarios(){
		super("../img/backgroundjtp.png");		
		this.setLayout(new GridLayout(1,0));		
		
		this.add(getConIzq());
		this.add(getpM());
		
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

		pM.add(new JLabel("Tipo de Usuario"));
		pM.add(comboTipesM);
		pM.add(new JLabel("Id Usuario"));
		pM.add(comboUsersM);
		pM.add(new JLabel(""));
		pM.add(new JLabel(""));
		
		pM.add(new JLabel("Resultados:"));
		pM.add(new JLabel(""));
		pM.add(rTipo);
		pM.add(comboTipesMN);
		pM.add(rId);	pM.add(nId);
		pM.add(rName);	pM.add(nName);
		pM.add(rPass);	pM.add(nPass);
		pM.add(new JLabel(""));
		pM.add(Modificar);

		pM.setBounds(120,60,260,280);
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Modificar usuario"));
		pb.add(pM);
		
		return pb;

	}

	protected PanelBase getpE() {
		pE = new PanelBase();
		PanelBase pb = new PanelBase();
		
		GridLayout g = new GridLayout(0,2);
		pb.setLayout(null);
		pE.setLayout(g);

		pE.add(new JLabel("Tipo de Usuario"));
		pE.add(new JComboBox(tiposUsuarios));
		pE.add(new JLabel("Id Usuario"));
		pE.add(new JComboBox(ids));
		pE.add(new JLabel(""));
		pE.add(new JLabel(""));
		pE.add(new JLabel("Resultados"));
		pE.add(new JLabel(""));
		pE.add(new JLabel("Datos"));
		pE.add(new JLabel(""));
		pE.add(new JLabel(""));
		pE.add(new JButton ("Eliminar"));

		pE.setBounds(120,40,230,140);
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Eliminar usuario"));
		pb.add(pE);
		
		return pb;
	}

	protected PanelBase getpA() {
		pA = new PanelBase();
		PanelBase pb = new PanelBase();
		pb.setLayout(null);
		
		GridLayout g = new GridLayout(0,2);
		pA.setLayout(g);		
		
		pA.add(new JLabel("Id usuario: "));
		pA.add(new JTextField(""));
		pA.add(new JLabel("Pass: "));
		pA.add(new JTextField(""));
		pA.add(new JLabel("Nombre: "));
		pA.add(new JTextField(""));
		pA.add(new JLabel("Tipo de Usuario: "));
		pA.add(new JComboBox(tiposUsuarios));
		pA.add(new JLabel(""));
		pA.add(new JButton ("Agregar"));

		pA.setBounds(120,40,230,140);
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Agregar Usuario"));
		pb.add(pA);
		
		
		return pb;
	}
}
