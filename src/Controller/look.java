package Controller;
import javax.swing.UIManager;

import View.Colores;

public class look implements Colores{
	public look(){
		UIManager.put("TabbedPane.borderHightlightColor", navyblue);
		UIManager.put("TabbedPane.selected", blanco);
		UIManager.put("TabbedPane.focus", blanco);
		UIManager.put("TabbedPane.contentAreaColor", blanco);
		UIManager.put("TabbedPane.foreground", navyblue);
		
		
		UIManager.put("Spinner.foreground", navyblue);
		UIManager.put("Spinner.background", blanco);
		
		UIManager.put("Button.focus", navyblue);
		UIManager.put("Button.foreground", blanco);
		UIManager.put("Button.background", navyblue);
		UIManager.put("Button.select", celeste);
		
		UIManager.put("Label.foreground", navyblue);
		
		UIManager.put("TextField.foreground", rojo);
		UIManager.put("TextField.background", blanco);
		
		
		UIManager.put("ComboBox.foreground", navyblue);
		UIManager.put("ComboBox.background", blanco);
		UIManager.put("ComboBox.selectionBackground", navyblue);
		UIManager.put("ComboBox.selectionForeground", blanco);
		

		UIManager.put("Table.background", gris);
		UIManager.put("Table.foreground", navyblue);

	}
}
