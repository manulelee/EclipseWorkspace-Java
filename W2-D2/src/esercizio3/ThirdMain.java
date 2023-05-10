package esercizio3;


import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThirdMain {
	
	static Logger log = LoggerFactory.getLogger(ThirdMain.class);
	public static Scanner sc= new Scanner(System.in);
	
	private static Map <String, String> rubrica = new HashMap <String, String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			inserisciVoce();
			inserisciVoce();
			inserisciVoce();
			cercaNumero();
			cercaNome();
			rimuoviContatto();
			stampaRubrica();
		} catch (Exception e) {
			//e.printStackTrace();
			log.error("Errore:" + e.getMessage());
		}
		
	}

	public static void inserisciVoce  () throws Exception {
		String nome;
		String num;
		log.info("Inserisci il nome");
		nome = sc.nextLine();
		System.out.println("Inserisci il numero");
		num = sc.nextLine();
		if (rubrica.containsKey(nome)) {
			throw new Exception ("Nome gia presente in rubrica");
		}
		else {
			rubrica.put(nome, num);
		}
	}
	
	public static void rimuoviContatto() throws Exception {
		String nome;
		System.out.println("Inserisci il nome");
		nome = sc.nextLine();
		if (rubrica.containsKey(nome)) {
			rubrica.remove(nome);
			System.out.println(nome + " rimosso");
		}
		else {
			throw new Exception ("Nome non presente in rubrica");
		}
	}
	
	public static void cercaNome() {
		System.out.println("Ricerca in base al nome:");
		System.out.println("Inserisci il numero");
		String num = sc.nextLine(); 
		for (String nome : rubrica.keySet()) {
			if (rubrica.get(nome).equals(num)) {
				System.out.println("Nome: " + nome + " - numero: "+ num);
			}
		}
	}
	
	public static void cercaNumero() {
		System.out.println("Ricerca in base al numero:");
		System.out.println("Inserisci il nome");
		String nome = sc.nextLine();
		String num = rubrica.get(nome);
		System.out.println("Nome: " + nome + " - numero: " + num);
	}
	
	
	public static void stampaRubrica() {
		System.out.println("--------- Numeri in Rubrica ---------");
		Set<String> key = rubrica.keySet();
		for (String nome : key) {
			System.out.println("Nome: " + nome + "  - numero: " + rubrica.get(nome));
		}
		
	}
}


