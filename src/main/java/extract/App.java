package extract;


public class App 
{
    public static void main( String[] args )
    {
        //we are testing 2 API vor the extraction
    	PdfRead_PdfBox pdf=new PdfRead_PdfBox();
    	PdfRead_PDFxStream pdf2=new PdfRead_PDFxStream();
    	
    	//information on the file
    	String[] details=new String[]{"","",""};
    	
    	//here will be the extracted text
    	String output;
    	String output2="";
    	String text_file="";
    	
    	//getting informations on the file
    	details=pdf.parametres_fichier();
    	
    	
    	System.out.println("File_NAME:\t"+details[0]);
    	System.out.println("File_PATH:\t"+details[1]);
    	System.out.println("File_LOCATION:\t"+details[2]);
    	
    	//first : use of the API PDFBOX
    	output=pdf.extraction_de_texte_pdfbox(details[1]);
    	System.out.println(output);
    	
   
    	//second: Use of the API PDFXSTREAM (Seems better)
    	output2=pdf2.extraction_de_texte(details[1]);
		System.out.println(output2);
		
		//Writting in a Text File
		text_file=details[1].substring(0, details[1].length()-3)+"txt";
		System.out.println("text_File Name:"+text_file);
		pdf.writeTexttoFile(output2, text_file);

		
    }
}
