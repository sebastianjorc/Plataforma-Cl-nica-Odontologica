package View;
import javax.swing.JButton;

public class BaseButton extends JButton implements Colores {

	private static final long serialVersionUID = 1L;
	
	public BaseButton(){
		this.setBackground(blanco);
		this.setForeground(navyblue);
	}

	public BaseButton(String string) {
		super(string);
		this.setBackground(blanco);
		this.setForeground(navyblue);
		
	}

}
