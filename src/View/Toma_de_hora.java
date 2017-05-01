package View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Toma_de_hora extends PanelBase{
	private static final long serialVersionUID = 1L;
	String [] tiposServicios= {	"General","Estetica","Especialidad"	};
	String [] Servicios		= {null};
	String [] Practicantes	= {null};
	String [] bloques		= {null};
	
	JLabel 		jlPrecio 	= new JLabel ();
	JTextField	jtaId 		= new JTextField();
	JButton		btnGenVale	= new JButton("Generar vale");
	JComboBox<String>	cbTipoServicio 	= new JComboBox<String>(tiposServicios),
						cbServicios		= new JComboBox<String>(Servicios),
						cbPracticantes	= new JComboBox<String>(Practicantes),
						cbHorarios		= new JComboBox<String>(bloques);
	
	public Toma_de_hora(){ 
		this.setLayout(new GridLayout(0,2));
		this.add(new JLabel ("Id"));				this.add(jtaId);
		this.add(new JLabel ("Tipo de servicio"));	this.add(cbTipoServicio);		
		this.add(new JLabel ("Servicio"));			this.add(cbServicios);
		this.add(new JLabel ("Profecional"));		this.add(cbPracticantes);
		this.add(new JLabel ("Fecha"));				this.add(cbHorarios);	
		this.add(new JLabel());						this.add(new JLabel());	
		this.add(new JLabel());						this.add(btnGenVale);
		this.add(new JLabel());						this.add(new JLabel());	
		this.add(new JLabel());						this.add(jlPrecio);		
	}

}