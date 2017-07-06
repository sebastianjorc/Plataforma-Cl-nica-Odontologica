package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class CambioenBoxAdministrador implements ItemListener {
	JTextField nnNivel;
	JComboBox<String> ccomboTiposA;

	public CambioenBoxAdministrador(JTextField nNivel, JComboBox<String> comboTiposA) {
		nnNivel = nNivel;
		ccomboTiposA = comboTiposA;
	}

	public void itemStateChanged(ItemEvent e) {
		String stringdelbox = (String) ccomboTiposA.getSelectedItem();
		if ( e.getStateChange() == ItemEvent.SELECTED ){
			nnNivel.setEnabled(false);
			if(stringdelbox.equals("Practicante")){
				nnNivel.setEnabled(true);
			}
        }
	}
}
