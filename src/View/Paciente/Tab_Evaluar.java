package View.Paciente;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import View.PanelBase;

public class Tab_Evaluar extends PanelBase{
	private static final long serialVersionUID = 1L;
	
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	String [] Dolor                   = {"Extremadamente doloroso","Mucho dolor","Moderado","Casi nada","Ningun dolor"};
	String [] Amabilidad              = {"Muy amable","Amable","Regular","Desagradable"};
	String [] Limpieza 				  = {"Si","Regular","No"};
	String [] Seguridad 			  = {"Si","Regular","No"};
	String [] Velocidad_procedimiento = {"Rapido","Medio","Lento"};
	String [] Explicacion_patologia   = {"Si","No"};
	String [] Explicacion_tratamiento = {"Si","No"};
	String [] Uso_equipo_adecuado     =	{"Si","No"};
	String [] Condicion_equipo        = {"Si","Regular","No"};
	String [] Resolvio_problema		  = {"Si","En proceso","No"};
	String [] Anestesia               = {"Si","Casi Nada","No"};
	String [] Comodidad               = {"Muy comodo","comodo","Regular","incomodo"};
	String [] Satisfaccion            = {"Muy satisfecho","Satisfecho","Regular","Nada satisfecho"};

	JComboBox<String>	cbDolor 		          = new JComboBox<String>(Dolor),
						cbAmabilidad	 	      = new JComboBox<String>(Amabilidad),
						cbLimpieza			      = new JComboBox<String>(Limpieza),
						cbSeguridad		          = new JComboBox<String>(Seguridad),
						cbVelocidad_procedimiento = new JComboBox<String>(Velocidad_procedimiento),
						cbExplicacion_patologia	  = new JComboBox<String>(Explicacion_patologia),
						cbExplicacion_tratamiento = new JComboBox<String>(Explicacion_tratamiento),
						cbUso_equipo_adecuado	  = new JComboBox<String>(Uso_equipo_adecuado),
						cbResolvio_problema 	  = new JComboBox<String>(Resolvio_problema),
						cbCondicion_equipo		  = new JComboBox<String>(Condicion_equipo),
						cbAnestesia	              = new JComboBox<String>(Anestesia),
						cbComodidad		          = new JComboBox<String>(Comodidad),
						cbSatisfaccion		      = new JComboBox<String>(Satisfaccion);
	
	JLabel label_Dolor				     = new JLabel("¿Cuanto dolor percibio?");
	JLabel label_Amabilidad 			 = new JLabel("¿Que tan amable fue el Dentista?");
	JLabel label_Limpieza				 = new JLabel("¿Sé tuvo cuidado con la limpieza?");
	JLabel label_Seguridad 				 = new JLabel("¿Sé sintio seguro?");
	JLabel label_Velocidad_procedimiento = new JLabel("Velocidad del procedimiento");
	JLabel label_Explicacion_patologia   = new JLabel("¿El Dentista le explico su patologia?");
	JLabel label_Explicacion_tratamiento = new JLabel("¿Le explico su tratamiento?");
	JLabel label_Uso_equipo_adecuado     = new JLabel("¿Usó el equipo dental adecuado?");
	JLabel label_Condicion_equipo        = new JLabel("¿Estaba en buena condicion el equipo?");
	JLabel label_Resolvio_problema       = new JLabel("¿Resolvieron su problema?");
	JLabel label_Anestesia               = new JLabel("¿El Dentista Uso anestesia?");
	JLabel label_Comodidad 				 = new JLabel("¿Que tan comodo se sintio?");
	JLabel label_Satisfaccion 		     = new JLabel("Califique su Satisfaccion ");
	JLabel relleno 		     			 = new JLabel("");
				
	JButton Boton = new JButton("Enviar");
	
	public Tab_Evaluar (){
		super("../img/backgroundjtp.png");	
		setLayout(new GridLayout(0,2,0,13));
		setBorder(BorderFactory.createTitledBorder(linea, "Encuesta atencion dental."));
		
		label_Dolor.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE, 17));
		add(label_Dolor);
		add(cbDolor);
		
		label_Amabilidad.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE, 18));
		add(label_Amabilidad);
		add(cbAmabilidad);
		
		label_Seguridad.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE, 18));
		add(label_Seguridad);
		add(cbSeguridad);
		
		label_Limpieza.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE, 18));
		add(label_Limpieza);
		add(cbLimpieza);
		
		label_Velocidad_procedimiento.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE, 18));
		add(label_Velocidad_procedimiento);
		add(cbVelocidad_procedimiento);
		
		label_Explicacion_patologia.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE, 18));
		add(label_Explicacion_patologia);
		add(cbExplicacion_patologia);
		
		label_Explicacion_tratamiento.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE, 18));
		add(label_Explicacion_tratamiento);
		add(cbExplicacion_tratamiento);
		
		label_Uso_equipo_adecuado.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE, 18));
		add(label_Uso_equipo_adecuado);
		add(cbUso_equipo_adecuado);
		
		label_Condicion_equipo.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE, 18));
		add(label_Condicion_equipo);
		add(cbCondicion_equipo);
		
		label_Resolvio_problema.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE, 18));
		add(label_Resolvio_problema);
		add(cbResolvio_problema);
		
		label_Anestesia.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE, 18));
		add(label_Anestesia);
		add(cbAnestesia);
		
		label_Comodidad.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE, 18));
		add(label_Comodidad);
		add(cbComodidad);
		
		label_Satisfaccion.setFont(new Font("Book Antiqua", Font.HANGING_BASELINE, 18));
		add(label_Satisfaccion);
		add(cbSatisfaccion);
		
		add(relleno);
		add(Boton);
	}
}