package esercizio1;

import java.util.InputMismatchException;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMain {
	
	static Logger log = LoggerFactory.getLogger(FirstMain.class);
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertStrings();
	}
	
	public static void insertStrings () {
		try {
		log.info("Inserisci un il numero di elementi da inserire");
		int n = sc.nextInt();
		
		Set<String> stringSet = new HashSet<String>();
		
		String nv;
		
		for (int i=0; i<n;i++) {
			do {
				log.info("Inserisci il nuovo valore");
				nv = sc.next();
				if (stringSet.contains(nv)) {
					log.warn("Elemento " + nv + " già presente!");
				}
				else {
					stringSet.add(nv);
				}
			}
			while (!stringSet.contains(nv)); 
				
			
		}
		log.info("Lunghezza totale: " + stringSet.size());
		stringSet.forEach(s -> log.info(s) );
		}
		catch ( InputMismatchException e ) {
			System.out.println("Errore: " + e);
		}
		catch (Exception e ) {
			System.out.println("Errore generico");
		}
		
		
	
		
	
}
	
}