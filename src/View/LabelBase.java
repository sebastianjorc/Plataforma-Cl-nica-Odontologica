package View;

import javax.swing.JLabel;

public class LabelBase extends JLabel implements Colores{
	private static final long serialVersionUID = 1L;
	LabelBase(){
		this.setForeground(navyblue);
		this.setBackground(gris);
	}
	public LabelBase(String text){
		super(text);
		this.setForeground(navyblue);
		this.setBackground(gris);
	}

}