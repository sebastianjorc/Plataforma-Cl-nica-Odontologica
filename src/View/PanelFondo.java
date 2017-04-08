package View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel implements Colores {	
	
	private static final long serialVersionUID = 1L;
	private Image background;
	boolean BackgrounBasic = true;
	
	PanelFondo(){
		this.setBackground(blanco);
		this.setForeground(navyblue);
	}
	
	public void paintComponent(Graphics g) {

		int width = this.getSize().width;
		int height = this.getSize().height;

		if (this.background != null && this.BackgrounBasic==true ) {
			g.drawImage(this.background, 180, 0, 600, 595, null);
		}else if (this.background != null && this.BackgrounBasic==false){
			g.drawImage(this.background, 0, 0, width, height, null);			
		}
		super.paintComponent(g);
	}
	
	public void setBackground() {
		
		this.setOpaque(false);
		this.background = new ImageIcon(getClass().getResource("logo_xl.png")).getImage();
		repaint();
	}

	public void setBackground(String background) {
		BackgrounBasic = false;		
		this.setOpaque(false);
		this.background = new ImageIcon(getClass().getResource(background)).getImage();
		repaint();
	}
 

}
