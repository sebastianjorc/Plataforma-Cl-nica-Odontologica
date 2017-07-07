package Controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import View.PanelBase;

/**
 * @author
 *
 */
public class ClickCambiarImagen implements ActionListener{
	PanelBase panel;
	JLabel label;

	/**
	 * @param pb
	 * @param img
	 */
	public ClickCambiarImagen(PanelBase pb, JLabel img) {
		panel = pb;	this.label = img;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif", "png");
		fileChooser.setFileFilter(filter);
		String ruta;
		
		int seleccion = fileChooser.showOpenDialog(null);		
		if (seleccion == JFileChooser.APPROVE_OPTION){
			File fichero = fileChooser.getSelectedFile();
			ruta=fichero.getPath();
			ImageIcon g = new ImageIcon(ruta);			
			ImageIcon h=new ImageIcon(g.getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_DEFAULT));
			label.setIcon(h);
		}
		
		panel.repaint();
	}
}
