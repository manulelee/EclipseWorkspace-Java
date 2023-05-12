package esercizio3;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RegistroPresenze {

	public static Logger log = LoggerFactory.getLogger(RegistroPresenze.class);
	static File file = new File("testFile/test.txt");
	
	public static List<Presenze> registroPresenze = new ArrayList<Presenze> ();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		registroPresenze.add(new Presenze("Emanuele", 5)) ;
		registroPresenze.add(new Presenze("Giovanni", 4));
		registroPresenze.add(new Presenze("Franco", 3));
		
	registroPresenze.forEach(p-> {
		try {
			scriviFile(p+"#");
		} catch (IOException e) {
			log.error("Error IO: "+ e.getMessage());
			e.printStackTrace();
		}
	}); 
	}
		

	
	public static void scriviFile(String s) throws IOException {
		FileUtils.writeStringToFile(file, s, "UTF-8", true);
		System.out.println("File aggiornato...");
	}
	
	public static String leggiFile() throws IOException {
		return FileUtils.readFileToString(file, "UTF-8");
	}
	
	public static void cancellaFile() throws IOException {
		FileUtils.deleteQuietly(file);
		System.out.println("------- File eliminato -------");
	}
	
	public static void cancellaDir() throws IOException {
		FileUtils.deleteDirectory(new File("testFile/"));
		System.out.println("------- Directory eliminata -------");
	}

}
