package JUnit;

import org.junit.Before;
import org.junit.Test;

import Controller.ClickPagar;
import Controller.look;

public class Crear_pdf_test {
	
	ClickPagar crear_pdf;


	@Before
	public void before(){
		new look();
		crear_pdf = new ClickPagar();
	}
	@Test
	public void test() {
		crear_pdf.actionPerformed(null);
	}

}
