package View.Recaudador;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import View.PanelBase;

public class Tab_Pago extends PanelBase {
	private static final long serialVersionUID = 1L;
	PanelBase	pVale, 
				pDeuda;
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);	
	JLabel 		jlResultado = new JLabel("resultado");
	JTextField	jtfVale 	= new JTextField(),
				idUser		= new JTextField();	
	JButton		pagarVale 	= new JButton ("Pagar"),
				pagarDeuda	= new JButton ("Pagar");
	JTable 		table 		= new JTable();
	
	public Tab_Pago(){ 
		super("../img/backgroundjtp.png");
		this.setLayout(new BorderLayout());
		this.add(panel_deuda(),BorderLayout.CENTER);
		this.add(panel_vale(),BorderLayout.NORTH);		
	}
	private Component panel_vale() {
		PanelBase pb = new PanelBase();	
		pVale = new PanelBase();				pVale.setLayout(new GridLayout(1,0));
		
		pVale.add(new JLabel("C�digo vale:"));	pVale.add(jtfVale);
		pVale.add(new JLabel());				
		pVale.add(new JLabel("Resultado:"));	pVale.add(jlResultado);		
		pVale.add(new JLabel());				pVale.add(pagarVale);		
		pVale.setBounds(50, 10, 800, 60);		pb.add(pVale);
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Pago por vale"));
		return pb;
	}
	private Component panel_deuda() {
		PanelBase pb = new PanelBase();			pDeuda = new PanelBase();
		pb.setLayout(null);						pDeuda.setLayout(new GridLayout(0,2));
		
		pDeuda.add(new JLabel());				pDeuda.add(new JLabel());	
		pDeuda.add(new JLabel("Id usuario:"));	pDeuda.add(idUser);
		pDeuda.add(new JLabel());				pDeuda.add(new JLabel());		
		pDeuda.add(new JLabel("Resultados:"));	pDeuda.add(table);
		
		pDeuda.add(new JLabel());				pDeuda.add(pagarDeuda);		
		pDeuda.setBounds(50, 10, 800, 160);		pb.add(pDeuda);
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Pago de deudas"));
		return pb;
	}
}