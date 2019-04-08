package PDF_READ;

import java.io.File;

import com.asprise.util.pdf.PDFReader;;

public class PdfRead_AspriseJavaPDFLib {

	public String extraction_of_text(String filename) {
		
		String inhalt="";
		try {
		PDFReader read=new PDFReader(new File(filename));
		read.open();
		inhalt=read.extractTextFromPage(0);
		read.close();
		System.out.println("\n\n\n ### Extraction with AspriseJavaPDFLib ###\n\n\n ");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return inhalt;
	}
}
