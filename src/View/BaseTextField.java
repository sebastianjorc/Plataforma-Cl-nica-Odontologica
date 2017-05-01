package View;

import javax.swing.JTextField;

public class BaseTextField extends JTextField implements Colores{
	
	private static final long serialVersionUID = 1L;

	public BaseTextField(){
		this.setBackground(gris);
		this.setForeground(navyblue);
	}

}
