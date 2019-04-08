package extract;

import PDF_READ.PdfRead_AspriseJavaPDFLib;
import PDF_READ.PdfRead_PDFxStream;
import PDF_READ.PdfRead_PdfBox;
import utils.utils;

public class App 
{
	static String file_produced="";
	
	public String get_file_produced() {
		
		return file_produced;
	}
	
    public static void main( String[] args )
    {
        //we are testing 2 API vor the extraction
    	PdfRead_PdfBox pdf=new PdfRead_PdfBox();
    	PdfRead_PDFxStream pdf2=new PdfRead_PDFxStream();
    	PdfRead_AspriseJavaPDFLib pdf3= new PdfRead_AspriseJavaPDFLib();
    	//information on the file
    	String[] details=new String[]{"","",""};
    	
    	//here will be the extracted text
    	String output;
    	String output2="";
    	String output3="";
    	String text_file="";
    	
    	//getting informations on the file
    	details=utils.parametres_fichier();
    	
    	
    	System.out.println("File_NAME:\t"+details[0]);
    	System.out.println("File_PATH:\t"+details[1]);
    	System.out.println("File_LOCATION:\t"+details[2]);
    	
    	//first : use of the API PDFBOX
    	output=pdf.extraction_of_text_pdfbox(details[1]);
    	System.out.println(output);
    	
   
    	//second: Use of the API PDFXSTREAM (Seems better)
    	output2=pdf2.extraction_of_text(details[1]);
		System.out.println(output2);
		
    	//third: Use of the API ASPRISEJAVAPDF
    	output3=pdf3.extraction_of_text(details[1]);
		System.out.println(output3);
		
		//Writting in a Text File
		
		
		//PDFBox extracted text
		text_file=details[2]+"\\"+details[0]+"PDFBox"+".txt";
		System.out.println("text_File Name:"+text_file+"\n \n");
		utils.writeTexttoFile(output, text_file);
		
		//PDFXStream extracted text
		text_file=details[2]+"\\"+details[0]+"PDFxSTream"+".txt";
		
		file_produced=text_file;
		
		System.out.println("text_File Name:"+text_file+"\n \n");
		utils.writeTexttoFile(output2, text_file);
		
		//ASPRISEJAVAPDF extracted text
		text_file=details[2]+"\\"+details[0]+"ASPRISEJAVAPDFLib"+".txt";
		System.out.println("text_File Name:"+text_file+"\n \n");
		utils.writeTexttoFile(output3, text_file);
		


		
    }
}
