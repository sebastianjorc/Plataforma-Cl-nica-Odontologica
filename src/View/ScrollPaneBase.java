package View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class ScrollPaneBase extends JScrollPane implements Colores{

	private Image background;
	private static final long serialVersionUID = 1L;
	
	public ScrollPaneBase(){
		this.setBackground(blanco);
		this.setForeground(navyblue);
		this.setOpaque(false);
		this.background = new ImageIcon(getClass().getResource("img/transparent.png")).getImage();
		repaint();
		
	}	
	
	public void paintComponent(Graphics g) {
		int width = this.getSize().width;
		int height = this.getSize().height;
		g.drawImage(this.background, 0, 0, width, height, null);			
		super.paintComponent(g);
		
	}

}
