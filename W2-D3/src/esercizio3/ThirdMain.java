package esercizio3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ThirdMain {

	static File file = new File("testFile/test.txt");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Presenze[] registroPresenze = new Presenze [3];
		registroPresenze[0] = new Presenze("Emanuele", 5);
		registroPresenze[1] = new Presenze("Giovanni", 4);
		registroPresenze[2] = new Presenze("Franco", 3);
		
	for (int i=0; i<registroPresenze.length; i++) {
		try {
			scriviFile(registroPresenze[i].nome+"@"+registroPresenze[i].presenze+"#");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
		
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
