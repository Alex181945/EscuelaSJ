package com.sorjuana.escuela.controlador.kardex;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.sorjuana.escuela.modelo.datos.kardex.KardexM;

public class GeneraKardexPDF {

	public static ByteArrayInputStream reporteKardex(KardexM[] kardex, String cNombre) {
		
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {
        	
        	Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        	Font smallFont = FontFactory.getFont(FontFactory.HELVETICA, 5.0f);
        	
        	Paragraph escuela = new Paragraph();
        	escuela.setAlignment(Element.ALIGN_CENTER);
        	escuela.add("Institución Educativa y Cultural");
        	escuela.setFont(smallFont);
        	
        	Paragraph escuela2 = new Paragraph();
        	escuela2.setAlignment(Element.ALIGN_CENTER);
        	escuela2.add("\"SOR JUANA INÉS DE LA CRUZ\"");
        	
        	Paragraph niveles = new Paragraph();
        	niveles.setAlignment(Element.ALIGN_CENTER);
        	niveles.add("SECUNDARIA");
        	niveles.setFont(smallFont);
        	
        	Paragraph permisos = new Paragraph();
        	permisos.setAlignment(Element.ALIGN_CENTER);
        	permisos.add("C.C.T. 15PJN023E1E,C.C.T. 15PST0600J,C.C.T. 15PPR0024N");
        	permisos.setFont(smallFont);
        	
        	PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(60);
            table.setWidths(new int[]{3, 3, 3});

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Materia", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Calificación", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Observaciones", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            for (KardexM kardex2 : kardex) {
            	
            	PdfPCell cell;

                cell = new PdfPCell(new Phrase(kardex2.getcMateria()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(kardex2.getDeCalfProm().toString()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(kardex2.getcObs())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);
                
                PdfWriter.getInstance(document, out);
                document.open();
                
                document.add(escuela);
                document.add(escuela2);
                document.add(niveles);
                document.add(permisos);
                
                LineSeparator separator = new LineSeparator();
                separator.setPercentage(59500f / 523f);
                Chunk linebreak = new Chunk(separator);
                document.add(linebreak);
                
                document.add(new Paragraph("El presente documento hace constar que el alumno: " + cNombre + ", a cursado las siguiente materias: \n\r" ));
                document.add(table);                
                document.close();
				
			}
			
		} catch (Exception e) {
			Logger.getLogger(GeneraKardexPDF.class.getName()).log(Level.SEVERE, null, e);
		}
	
		return new ByteArrayInputStream(out.toByteArray());
	}
	
}

