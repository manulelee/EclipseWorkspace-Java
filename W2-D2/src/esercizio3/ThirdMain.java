package esercizio3;


import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import esercizio1.FirstMain;

public class ThirdMain {
	
	static Logger log = LoggerFactory.getLogger(FirstMain.class);
	public static Scanner sc= new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map <String, String> rubrica = new HashMap <String, String>();
		inserisciVoce(rubrica);
		inserisciVoce(rubrica);
	}

	
	public static void inserisciVoce (Map<String,String> r) {
		String nome;
		String num;
		log.info("Inserisci il nome");
		nome = sc.nextLine();
		log.info("Inserisci il numero");
		num = sc.nextLine();
		r.put(nome, num);
	}
	
	public static void cercaNumero(Map<String,String> r) {
		log.info("Inserisci il nome");
		String nome = sc.nextLine();
		String num = r.get(nome);
		log.info("Nome: " + nome + " - numero: "+ num);
	}
	public static void cercaNome(Map<String,String> r) {
		log.info("Inserisci il nome");
		String num = sc.nextLine();
		String nome = r.get(num);
		log.info("Nome: " + nome + " - numero: "+ num);
	}
}
