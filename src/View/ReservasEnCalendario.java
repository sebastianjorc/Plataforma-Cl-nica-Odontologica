package View;
 
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.toedter.calendar.IDateEvaluator;

public class ReservasEnCalendario implements IDateEvaluator {
 
 Calendar calendar = Calendar.getInstance();

 public ReservasEnCalendario(){getSpecialTooltip();}
 
 //se debe agregar segun la base de datos
 public static List<Calendar> fechasEspeciales() {
	 List<Calendar> fechas = new ArrayList<Calendar>();
	 //Inicio AGREGAR 
	 Calendar calendar = new GregorianCalendar(2017, Calendar.MAY, 24);
	 fechas.add(calendar);		
	 //Fin agregar
     return fechas;
}
 @Override
 public boolean isSpecial(Date date) {
	 calendar.setTime(date);
	 for (int i = 0; i < fechasEspeciales().size(); i++) {
	  if (calendar.get(Calendar.MONTH) == fechasEspeciales().get(i).get(Calendar.MONTH)&&
          calendar.get(Calendar.DAY_OF_MONTH) == fechasEspeciales().get(i).get(Calendar.DAY_OF_MONTH)) {
		  return true;
	  }
	 }
	 return false;
 }
 
 @Override
 public Color getSpecialForegroundColor() {
  return Color.GREEN;
 }
 
 @Override
 public Color getSpecialBackroundColor() {
  return (Colores.navyblue);
 }
/*--------------------------------------------------------------------------------------------------------*/
 public String getSpecialTooltip() {return null;}
@Override
public Color getInvalidBackroundColor() {	return null;}
@Override
public Color getInvalidForegroundColor() {return null;}
@Override
public String getInvalidTooltip() {return null;}
@Override
public boolean isInvalid(Date arg0) {return false;}

}