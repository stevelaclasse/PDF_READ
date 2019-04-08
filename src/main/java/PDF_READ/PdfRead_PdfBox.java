package PDF_READ;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;



public class PdfRead_PdfBox {

	//used variables
    
    String parsedText;
    
    PDFTextStripper pdfStripper;

    //defualt constructor 
    public PdfRead_PdfBox() {
    	
    }

    // text extraction from a PDF file
    public String extraction_of_text_pdfbox(String fileName) {
        
        File f = new File(fileName); //file creation
        PDDocument fichier;
  
        if (!f.isFile()) { //testing if file exist
        	
            System.out.println("The file" + fileName + "do not exist");
            
            return null;
        }
  
   	
            

        try {
        	
            fichier=PDDocument.load(f);
            pdfStripper = new PDFTextStripper();
           
            pdfStripper.setStartPage(1);
            pdfStripper.setEndPage(1);
            
            
            parsedText = pdfStripper.getText(fichier);
            
        	} 
        catch (Exception e) {
            
            e.printStackTrace();

            return null;
        	}
        
        System.out.println("\n\n\n ### Extraction with PdfBox ###\n\n\n ");
        
        return parsedText;
    }


    


    }