package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class utils {
	
	public utils() {
		
	}

    // writing the extracted text in a txt file
    public static void writeTexttoFile(String pdfText, String fileName) {
  
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
    
 
    public static String[] parametres_fichier(){
    	
		String[] param=new String[]{"","",""};
		
		System.out.println("Extracting text in a PDF");

		JFileChooser choix = new JFileChooser("C:\\");	//Pour selectionner le fichier PDF

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
