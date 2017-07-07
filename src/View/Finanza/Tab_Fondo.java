package View.Finanza;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Model.ConexionSQL;
import View.PanelBase;

/**
 * @author Sebastian Joshua
 *
 */
public class Tab_Fondo extends PanelBase{
	private static final long serialVersionUID = 1L;

	Border 		linea 		= BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

	ConexionSQL con;
	
	PanelBase a = new PanelBase();
	
	JTextField fondo_fecha = new JTextField();
	JTextField fondo_t = new JTextField();
	JTextField fondo_g = new JTextField();
	JTextField fondo_i = new JTextField();
	JTextField fondo_p = new JTextField();
	
	JLabel fondofecha = new JLabel("Fecha:");
	JLabel fondot=new JLabel("Fondo sin descuento:");
	JLabel fondog=new JLabel("Gasto total:");
	JLabel fondoi=new JLabel("Egreso total:");
	JLabel fondop=new JLabel("Fondo con descuento:");
	
	/**
	 * 
	 */
	public Tab_Fondo(){	
		super("../img/backgroundjtp.png");	
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder(linea,"Fondos"));
		ResultSet rs = null;	Statement s = null;
		DecimalFormat f = new DecimalFormat("###,###.##");
		try{
			con = new ConexionSQL();
			con.connect();
			s = con.con.createStatement();
			rs = s.executeQuery("SELECT * FROM Fondos");
			String fecha=null;
			while(rs.next()){
				fecha=(rs.getString(1)+" "+rs.getString(2));
				fondo_fecha.setText(fecha);
				fondo_t.setText(String.valueOf(f.format(rs.getInt(3))));
				fondo_g.setText(String.valueOf(f.format(rs.getInt(4))));
				fondo_i.setText(String.valueOf(f.format(rs.getInt(5))));
				fondo_p.setText(String.valueOf(f.format(rs.getInt(6))));
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		
		fondot.setBounds(20, 16, 200, 30);
		fondot.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		add(fondot);

		fondog.setBounds(20, 52, 200, 30);
		fondog.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		add(fondog);
	
		fondoi.setBounds(20, 96, 200, 30);
		fondoi.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		add(fondoi);
		
		fondop.setBounds(20, 136, 200, 30);
		fondop.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		add(fondop);
		
		fondofecha.setBounds(20, 186, 200, 30);
		fondofecha.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		add(fondofecha);
		
		fondo_t.setBounds(260, 22, 140, 20);
		fondo_t.setEditable(false);
		add(fondo_t);
		
		fondo_g.setBounds(260, 58, 140, 20);
		fondo_g.setEditable(false);
		add(fondo_g);
		
		fondo_i.setBounds(260, 102, 140, 20);
		fondo_i.setEditable(false);
		add(fondo_i);
		
		fondo_p.setBounds(260, 143, 140, 20);
		fondo_p.setEditable(false);
		add(fondo_p);
		
		fondo_fecha.setBounds(260, 183, 140, 20);
		fondo_fecha.setEditable(false);
		add(fondo_fecha);


	}
}
