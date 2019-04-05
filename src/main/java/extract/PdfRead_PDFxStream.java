package extract;

import java.io.IOException;

import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.OutputTarget;
import com.snowtide.pdf.Page;

public class PdfRead_PDFxStream {

	public PdfRead_PDFxStream() {
		
	}
	
	public String extraction_de_texte(String fileName) {

		String return_text="";
		
		try {
		Document pdf_text = PDF.open(fileName);
		Page current = pdf_text.getPage(0);
		StringBuilder text = new StringBuilder(1024);
		current.pipe(new OutputTarget(text));
		pdf_text.close();
		System.out.println("\n\n\n ### Extraction with PDFxStream ###\n\n\n ");
		return_text= text.toString();
		} 
		
		catch (IOException e) { 
		
		e.printStackTrace();
		}
		
		return return_text;
	}
	
}
