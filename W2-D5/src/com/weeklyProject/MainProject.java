package com.weeklyProject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	
	public static Logger log = LoggerFactory.getLogger(MainProject.class);
	public static Scanner sc = new Scanner(System.in);
public static List<ElementoBibliotecario> biblioteca = new ArrayList<ElementoBibliotecario>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		biblioteca.add(new Libro(9898942, "Il signore degli anelli - La compagnia dell'anello", LocalDate.of(1954, 12, 10), 700, "R. R. Tolkien", "Fantasy"));
		biblioteca.add(new Libro(9898942, "Il signore degli anelli - Le due torri", LocalDate.of(1956, 02, 21), 650, "R. R. Tolkien", "Fantasy"));
		biblioteca.add(new Libro(9898942, "Il signore degli anelli - Il ritorno del Re", LocalDate.of(1957, 03, 1), 680, "R. R. Tolkien", "Fantasy"));
		
		biblioteca.add(new Rivista(9898942, "Stab Magazine", LocalDate.of(2023, 01, 10), 42, Periodicità.MENSILE));
		biblioteca.add(new Rivista(9898942, "Stab Magazine", LocalDate.of(2023, 02, 10), 46, Periodicità.MENSILE));
		
		ElementoBibliotecario a= aggiungiElemento();
		a.toString();
	}
	
	public static ElementoBibliotecario aggiungiElemento () {
		ElementoBibliotecario result;
		int type;
		do {
			System.out.println("Che tipo di elemento vuoi inserire?");
			System.out.println("1 - Libro");
			System.out.println("2 - Rivista");
			type = sc.nextInt();
			if (type <1 || type>2)
				{
					System.out.println("Scelta invalida");
				}
		}
		while (type <1 || type>2);
		System.out.println("Inserisci l'ISBN");
		long isbn = sc.nextLong();
		System.out.println("Inserisci il nome");
		String nome = sc.next();
		System.out.println("Inserisci l'anno di publicazione");
		int anno = sc.nextInt();
		System.out.println("Inserisci il mese di publicazione");
		int mese = sc.nextInt();
		System.out.println("Inserisci il giorno di publicazione");
		int giorno = sc.nextInt();
		System.out.println("Inserisci il numero di pagine");
		int pagine = sc.nextInt();
		if (type==1) {
			System.out.println("Inserisci l'autore");
			String autore = sc.next();
			System.out.println("Inserisci il genere");
			String genere = sc.next();
			
			result = new Libro(isbn, nome, LocalDate.of(anno, mese, giorno), pagine, autore, genere);
		}
		else {
			System.out.println("Inserisci la periodicità");
			System.out.println("1 - Settimanale");
			System.out.println("2 - Mensile");
			System.out.println("3 - Semestrale");
			int s = sc.nextInt();
			Periodicità p;
			switch (s) {
				case 1: p = Periodicità.SETTIMANALE; break;
				case 2: p = Periodicità.MENSILE; break;
				case 3: p = Periodicità.SEMESTRALE; break;
				default : p = Periodicità.SETTIMANALE; break;
			}
			result = new Rivista(isbn, nome, LocalDate.of(anno, mese, giorno), pagine, p);
			
		}
		result.toString();
		return result;
	}

}
