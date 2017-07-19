package Controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;

import View.Paciente.Tab_Calendario;

/**Clase que muestra los datos del calendario
 * @author Norton -Sebastian
 */
public class ClickEnCalendario implements PropertyChangeListener {

	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		final Calendar c = (Calendar) evt.getNewValue();   
			String dia,mes;
			int mes_numerico;
		 
		 dia=Integer.toString(c.get(Calendar.DAY_OF_MONTH));
		 mes_numerico=(c.get(Calendar.MONTH));
		 mes_numerico=mes_numerico+1;
		 
		 //porque los meses en jcalendar parten en 0
		 mes=Integer.toString(mes_numerico);
		 //aca invocar a clase para acceder a los datos relacionados con la toma de hora.
		 //esto es solo un ejemplo
		   if( (dia.equals("24"))&&(mes.equals("5")) ){	
			   Tab_Calendario.aa.setText("Paciente 1");
			   Tab_Calendario.bb.setText("Estetica");
			   Tab_Calendario.cc.setText("Servicio 1");
			   Tab_Calendario.dd.setText("Dr. Marco");
			   Tab_Calendario.ee.setText("16:00");
		  }
	}
}
