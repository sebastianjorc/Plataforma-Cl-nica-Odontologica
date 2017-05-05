package View;
import java.awt.Font;
/*--------------------------------------------------------------------------------------------------------*/	
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
/*--------------------------------------------------------------------------------------------------------*/	
@SuppressWarnings("serial")
public class Toma_de_hora extends PanelBase{
	
	String [] tiposServicios= {	"General","Estetica","Especialidad"	};
	String [] Servicios		= {null};
	String [] Practicantes	= {null};
	String [] bloques		= {null};
	
	JLabel 		jlPrecio 	  = new JLabel ();
	
	JLabel 		Identificacor = new JLabel("Id:"); 
	JLabel 		Tipo_servicio = new JLabel("Tipo de servicio:"); 
	JLabel 		Servicio 	  = new JLabel("Servicio:"); 
	JLabel 		Profesional   = new JLabel("Profesional:"); 
	JLabel 		Fecha         = new JLabel("Fecha:"); 

	JTextField	jtaId 		= new JTextField();
	
	JButton		btnGenVale	= new JButton("Generar vale");
	
	JComboBox<String>	cbTipoServicio 	= new JComboBox<String>(tiposServicios),
						cbServicios		= new JComboBox<String>(Servicios),
						cbPracticantes	= new JComboBox<String>(Practicantes),
						cbHorarios		= new JComboBox<String>(bloques);
/*--------------------------------------------------------------------------------------------------------*/	
	public Toma_de_hora(){ 
		this.setLayout(new GridLayout(0,2,0,15));
		
		Identificacor.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 18));
		Tipo_servicio.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 18));
		Servicio.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 18));
		Profesional.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 18));
		Fecha.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE | Font.BOLD, 18));
		
		this.add(Identificacor);				this.add(jtaId);
		this.add(Tipo_servicio);				this.add(cbTipoServicio);		
		this.add(Servicio);						this.add(cbServicios);
		this.add(Profesional);					this.add(cbPracticantes);
		this.add(Fecha);						this.add(cbHorarios);	
		this.add(new JLabel());						this.add(new JLabel());	
		this.add(new JLabel());						this.add(btnGenVale);
		this.add(new JLabel());						this.add(new JLabel());	
		this.add(new JLabel());						this.add(jlPrecio);		
	}
}
/*--------------------------------------------------------------------------------------------------------*/	