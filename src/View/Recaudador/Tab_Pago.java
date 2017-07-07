package View.Recaudador;
/*--------------------------------------------------------------------------------------------------------*/	
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.mxrck.autocompleter.TextAutoCompleter;

import Controller.ClickPagar;
import Model.ConexionSQL;
import View.PanelBase;
/*--------------------------------------------------------------------------------------------------------*/	
/**
 * @author Sebastian Joshua
 *
 */
public class Tab_Pago extends PanelBase {
	private static final long serialVersionUID = 1L;
	PanelBase	pVale, 
				pDeuda;
	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);	
	
	JLabel 		jlResultado = new JLabel("resultado");
	
	JTextField	jtfVale 	= new JTextField(),
				idUser		= new JTextField();	
	
	JButton		pagarVale 	= new JButton ("Pagar"),
				pagarDeuda	= new JButton ("Pagar"),
				btnBuscar	= new JButton ("Buscar");
	JTable table;
	DefaultTableModel modelo;
	TextAutoCompleter 	autoCompleter  = new TextAutoCompleter(idUser);
/*--------------------------------------------------------------------------------------------------------*/	
	/**
	 * 
	 */
	public Tab_Pago(){ 
		super("../img/backgroundjtp.png");
		modelo = new DefaultTableModel() {
			   @Override
			   public boolean isCellEditable(int fila, int columna) {
			       return false; //Con esto conseguimos que la tabla no se pueda editar
			   }
			};
		table = new JTable(modelo);
		modelo.addColumn("Id");
		modelo.addColumn("Servicio");
		modelo.addColumn("Monto");
		
		pagarVale.addActionListener(new ClickPagar());
		pagarDeuda.addActionListener(new ClickPagar());
		panel_deuda();
		//this.add(panel_vale(),BorderLayout.NORTH);		
	}
/*--------------------------------------------------------------------------------------------------------*/	
	/**
	 * @return
	 */
	@SuppressWarnings("unused")
	private Component panel_vale() {
		PanelBase pb = new PanelBase();	
		pVale = new PanelBase();				pVale.setLayout(new GridLayout(1,0));
		
		pVale.add(new JLabel("Código vale:"));	pVale.add(jtfVale);
		pVale.add(new JLabel());				
		pVale.add(new JLabel("Resultado:"));	pVale.add(jlResultado);		
		pVale.add(new JLabel());				pVale.add(pagarVale);		
		pVale.setBounds(50, 10, 800, 60);		pb.add(pVale);
		pb.setBorder(BorderFactory.createTitledBorder(linea, "Pago por vale"));
		return pb;
	}
	/**
	 * 
	 */
	private void panel_deuda() {
		consulta_autocompletado();
		this.setLayout(new BorderLayout());
		PanelBase pb = new PanelBase();
		pb.setLayout(new BoxLayout(pb,BoxLayout.X_AXIS));
		pb.add(new JLabel("Buscar usuario:    "));	pb.add(idUser);	
		pb.add(new JLabel("      ")); 				pb.add(btnBuscar);
		
		btnBuscar.addActionListener(new ClickBuscar());
		this.add(pb,BorderLayout.NORTH);
		
		pDeuda = new PanelBase();			pDeuda.setLayout(new GridLayout(0,2,0,15));
		
		pDeuda.add(new JLabel("Resultados:"));			
		pDeuda.add(new JLabel());			pDeuda.add(new JLabel());
		
		String[] columnas = {"id","Servicio","Monto"};
		
		table.setFillsViewportHeight(true);
		table.setBackground(blanco);
		table.setOpaque(false);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(navyblue);
		table.getTableHeader().setForeground(blanco);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		pDeuda.add(scrollPane);
		
		pDeuda.add(new JLabel());				pDeuda.add(new JLabel());
		pDeuda.add(new JLabel());		
		pDeuda.add(pagarDeuda);		
		pDeuda.setBounds(50, 10, 800, 300);		this.add(pDeuda,BorderLayout.CENTER);
		
		this.setBorder(BorderFactory.createTitledBorder(linea, "Pago de deudas"));
		
	}
	public void consulta_autocompletado(){
		ResultSet rs= null;
		Statement s	= null;
		ConexionSQL con = new ConexionSQL();
		
		try {
			autoCompleter.removeAllItems();
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery ("SELECT * from `Deuda paciente`");
			while (rs.next())
				autoCompleter.addItem(rs.getString(1));
			con.con.close();
			
		} catch (SQLException e) {
		    JOptionPane.showMessageDialog(null, "Error. No se encuentra el tipo de usuario\n "
		    		+ "en la base de datos\nError: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);	
			e.printStackTrace();
		}
		
	}
	class ClickBuscar implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			rellenarTabla(idUser.getText());
			
		}
		
		public void rellenarTabla(String ID) {
			Statement s	= null;
			ResultSet rs= null;
			ConexionSQL con = new ConexionSQL();
			String query = ("SELECT * FROM 'Deuda paciente' WHERE ID_PACIENTE='"+ID+"'");
			
			
			try {
				con.connect();
				s = con.con.createStatement();				
	            rs = s.executeQuery (query);  
	            
	            while(rs.next()){
	                Object[] fila = new Object[3]; 	                                              
	                fila[0] = rs.getString("ID_PACIENTE");
	                fila[1] = rs.getDouble("ID_SERVICIO");
	                fila[1] = rs.getDouble("PRECIO");
	                modelo.addRow(fila);
	            }	 
	            table.updateUI();
	           con.con.close();
	 
	        } catch (SQLException e) {
	            System.out.println(e+"    ");
	            e.printStackTrace();
	            
	        }
	 
	    }
		
	    void vaciarTabla(){
	        while (modelo.getRowCount() > 0) modelo.removeRow(0);
	    }
			
	}
		
	
	
}
/*--------------------------------------------------------------------------------------------------------*/	
