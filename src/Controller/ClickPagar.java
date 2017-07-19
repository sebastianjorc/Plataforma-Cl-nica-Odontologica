package Controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import View.Colores;

/**
 * @author Norton -Sebastian
 * Listener relacionados a la paga
 */
public class ClickPagar implements ActionListener, Colores{

	public ClickPagar(){
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		crear_pdf();
	}
	
	/**
	 * 
	 */
	void crear_pdf(){
		//DOC DE LA API: http://itextsupport.com/apidocs/itext5/latest/overview-summary.html
				
		FileOutputStream archivo;
		String ruta= getClass()+".ARCHIVO.pdf";		
		try {
			archivo = new FileOutputStream(ruta.toString());
		    Document documento = new Document();
		    PdfWriter.getInstance(documento, archivo);
		    documento.open();
		    documento.setMarginMirroringTopBottom(true);
		    
			Paragraph date = new Paragraph("Viernes 12 de Mayo, 2017",
			FontFactory.getFont("arial", 10));
			date.setAlignment(Chunk.ALIGN_RIGHT);
			documento.add(date);
			
		    Image foto = Image.getInstance("imagenes/icon_uls.png");
		    foto.scaleToFit(100, 100);
			foto.setAlignment(Chunk.ALIGN_LEFT);
			documento.add(foto);

			Paragraph title = new Paragraph("COMPROBANTE DE PAGO",
			FontFactory.getFont("arial", 20));
			title.setAlignment(Chunk.ALIGN_CENTER);
			documento.add(title);
			
			Paragraph perfil = new Paragraph("Id_usuario\nname_usuario\n",
			FontFactory.getFont("arial", 12));
			perfil.setAlignment(Chunk.ALIGN_LEFT);
			perfil.setSpacingBefore(30);
			perfil.setIndentationLeft(53);
			documento.add(perfil);
			
			
		    PdfPTable table = new PdfPTable(3);
		    table.setSpacingBefore(15);
		    PdfPCell c1 = new PdfPCell(new Phrase("COD"));		    
		    c1.setBackgroundColor(new BaseColor(9,85,121));		    
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);

	        c1 = new PdfPCell(new Phrase("SERVICIO"));
		    c1.setBackgroundColor(new BaseColor(9,85,121));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);

	        c1 = new PdfPCell(new Phrase("MONTO"));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    c1.setBackgroundColor(new BaseColor(9,85,121));
	        table.addCell(c1);
	        table.setHeaderRows(1);

	        table.addCell("id_servicio_1");
	        table.addCell("Servicio 1");
	        table.addCell("costo_servicio_1");
	        table.addCell("id_servicio_2");
	        table.addCell("Servicio 2");
	        table.addCell("costo_servicio_2");

		    documento.add(table);
		    
		    Paragraph total = new Paragraph("Total: costo_total",
			FontFactory.getFont("arial", 10));
		    total.setAlignment(Chunk.ALIGN_RIGHT);
		    total.setIndentationRight(54);
			documento.add(total);
		    


			Paragraph linea = new Paragraph("     _________________                              "
					+ "                ________________   ",
			FontFactory.getFont("arial", 12));
			linea.setSpacingBefore(130);
			linea.setAlignment(Chunk.ALIGN_CENTER);
			documento.add(linea);
			
			Paragraph Firma = new Paragraph("Firma del reacaudador                              "
					+ "                Firma del paciente ",
			FontFactory.getFont("arial", 12));
			Firma.setAlignment(Chunk.ALIGN_CENTER);
			documento.add(Firma);
			
		    documento.close();
		    
		    
		    File fileToPrint = new File(ruta.toString());
			Desktop.getDesktop().print(fileToPrint);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
