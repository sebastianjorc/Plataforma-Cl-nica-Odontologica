package Controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * @author
 *
 */
public class CambioenBoxAdministrador implements ItemListener {
	JTextField nnNivel;
	JComboBox<String> ccomboTiposA;
	

	/**
	 * @param nNivel
	 * @param comboTiposA
	 */
	public CambioenBoxAdministrador(JTextField nNivel, JComboBox<String> comboTiposA) {
		nnNivel = nNivel;
		ccomboTiposA = comboTiposA;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
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
