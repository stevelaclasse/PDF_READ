package extract;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class PdfRead_PdfBox {

	//used variables
    
    String parsedText;
    
    PDFTextStripper pdfStripper;

    //defualt constructor 
    public PdfRead_PdfBox() {
    	
    }

    // text extraction from a PDF file
    public String extraction_de_texte_pdfbox(String fileName) {
        
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

    // writing the extracted text in a txt file
    void writeTexttoFile(String pdfText, String fileName) {
  
        System.out.println("\n Writting the text in a file :" + fileName);
        try {
 
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)));
			
			writer.write(pdfText);
			
			writer.close();

        } catch (Exception e) {
        	         
            e.printStackTrace();
        }
        
        System.out.println("Writting End\n");
    }
    
    public String[] parametres_fichier(){
    	
		String[] param=new String[]{"","",""};
		
		System.out.println("Extracting text in a PDF");

		JFileChooser choix = new JFileChooser("C:\\Users\\wfozing\\Documents");	//Pour selectionner le fichier PDF

		choix.setFileSelectionMode(JFileChooser.FILES_ONLY);	//on ne peut choisir qu'un fichier

		String[] ext=new String[]{"pdf","PDF"}; 

		FileNameExtensionFilter filtre=new FileNameExtensionFilter("Only PDF Files",ext); 
		//on ne choisit que les fichiers avec l'extension pdf

		choix.setFileFilter(filtre);
		//choix.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int faisable = choix.showOpenDialog(null);

		if(faisable == JFileChooser.APPROVE_OPTION) {
			
			File fichier = choix.getSelectedFile();
			
			System.out.println(fichier.getName()); //Nom du fichier choisit
			
			String chemin;
			
			chemin= fichier.getAbsolutePath(); //chemin absolu du fichier choisit
			
			int taille_nom=fichier.getName().length(); //taille du nom du fichier choisit
			
			System.out.println(chemin);
			
			String dossier=chemin.substring(0,chemin.length()-taille_nom); 
			//on extrait le dossier ou on va cree le fichier texte
			
			dossier=dossier.replace("\\\\","\\\\\\\\");
			System.out.println(dossier);
			
			param[0]=fichier.getName();
			
			param[1]=chemin;
			
			param[2]=dossier;
			
		}
		
		return param;
    }

    }