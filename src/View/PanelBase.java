package View;
/*--------------------------------------------------------------------------------------------------------*/
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/*--------------------------------------------------------------------------------------------------------*/
public class PanelBase extends JPanel implements Colores {	
	
	private static final long serialVersionUID = 1L;
	private Image background;
/*--------------------------------------------------------------------------------------------------------*/
	public PanelBase(){
		this.setBackground(blanco);
		this.setForeground(navyblue);
		this.setOpaque(false);
		this.background = new ImageIcon(getClass().getResource("img/transparent.png")).getImage();
		repaint();
	}
	
	public PanelBase(String background) {
		this.setBackground(blanco);
		this.setForeground(navyblue);
		this.setOpaque(false);
		this.background = new ImageIcon(getClass().getResource(background)).getImage();
		repaint();
	}
/*--------------------------------------------------------------------------------------------------------*/		
	public void setBackground(String background) {
		this.setOpaque(false);
		this.background = new ImageIcon(getClass().getResource(background)).getImage();
		repaint();
	}
/*--------------------------------------------------------------------------------------------------------*/	
	public void paintComponent(Graphics g) {
		int width = this.getSize().width;
		int height = this.getSize().height;
		g.drawImage(this.background, 0, 0, width, height, null);			
		super.paintComponent(g);
		
	}
}
/*--------------------------------------------------------------------------------------------------------*/	