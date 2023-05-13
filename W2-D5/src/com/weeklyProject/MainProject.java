package com.weeklyProject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	
	public static Logger log = LoggerFactory.getLogger(MainProject.class);
	public static Scanner sc = new Scanner(System.in);
	public static List<ElementoBibliotecario> biblioteca = new ArrayList<ElementoBibliotecario>();
	public static String path = "dati/Elementi.txt";
	public static File file = new File(path);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		biblioteca.add(new Libro(1001, "Il signore degli anelli - La compagnia dell'anello", LocalDate.of(1954, 12, 10), 700, "R. R. Tolkien", "Fantasy"));
		biblioteca.add(new Libro(1002, "Il signore degli anelli - Le due torri", LocalDate.of(1957, 02, 21), 650, "R. R. Tolkien", "Fantasy"));
		biblioteca.add(new Libro(1003, "Il signore degli anelli - Il ritorno del Re", LocalDate.of(1957, 03, 1), 680, "R. R. Tolkien", "Fantasy"));
		
		biblioteca.add(new Rivista(2001, "Stab Magazine", LocalDate.of(2023, 01, 10), 42, Periodicità.MENSILE));
		biblioteca.add(new Rivista(2002, "Stab Magazine", LocalDate.of(2023, 02, 10), 46, Periodicità.MENSILE));
		
		int s;
		try {
		System.out.println("Benvenut* nella biblioteca virtuale in Java");
		do {
		System.out.println();
		System.out.println("Scegli un metodo da eseguire:");
		System.out.println("*** 0 - Termina esecuzione ***");
		System.out.println("*** 1 - Elenco dei titoli ***");
		System.out.println("*** 2 - Aggiunta di un elemento ***");
		System.out.println("*** 3 - Rimozione di un elemento ***");
		System.out.println("*** 4 - Ricerca per ISBN ***");
		System.out.println("*** 5 - Ricerca per anno ***");
		System.out.println("*** 6 - Ricerca per autore ***");
		System.out.println("*** 7 - Scrittura backup su file ***");
		System.out.println("*** 8 - Lettura backup da file ***");
		s = sc.nextInt();
		switch (s) {
		case 0: break;
		case 1:  biblioteca.forEach(e-> System.out.println(e));break;
		case 2:  biblioteca.add(aggiungiElemento());break;
		case 3:  eliminaElemento();break;
		case 4: filtraIsbn();break;
		case 5: filtraAnno();break;
		case 6: filtraAutore();break;
		case 7: scriviElementi(); break;
		case 8: System.out.println("In lavorazione (Work in progress!)");
		leggiElementiDaFile();break;
		default: System.out.println("Scelta invalida - inserire un numero da 0 a 8");break;
		}
		}	
		while (s!=0);
		}
		//catch (InputMismatchException e){
			//log.error(e.getMessage());
		//}
		catch (IOException e) {
			e.printStackTrace(); }
		catch (InputMismatchException e){
			log.error("Errore: tipo di dato non corretto! "+ e);
		}
	}
	
	public static ElementoBibliotecario aggiungiElemento () {
		ElementoBibliotecario result;
		List<ElementoBibliotecario> i;
		int type;
		long isbn;
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
		do {
			long query = sc.nextLong();
			isbn = query;
			i = biblioteca.stream().filter(e->e.getIsbn()==query)
					.collect(Collectors.toList());
			if (i.size()>0) {
				System.out.println("Questo ISBN risulta già associato ad un prodotto presente nella libreria");
				System.out.println("Inserisci un nuovo ISBN");
			}
		}
		while(i.size()>0);
		
		
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
			int s;
			do {
			System.out.println("Inserisci la periodicità");
			System.out.println("1 - Settimanale");
			System.out.println("2 - Mensile");
			System.out.println("3 - Semestrale");
			s = sc.nextInt();
			}
			while (s<1 | s>3);
			Periodicità p;
			switch (s) {
				case 1: p = Periodicità.SETTIMANALE; break;
				case 2: p = Periodicità.MENSILE; break;
				case 3: p = Periodicità.SEMESTRALE; break;
				default : p = Periodicità.SETTIMANALE; break;
			}
			result = new Rivista(isbn, nome, LocalDate.of(anno, mese, giorno), pagine, p);
		}
		System.out.println("Elemento salvato: " + result.toString());
		return result;
	}
	
	public static void eliminaElemento() {
		System.out.println("Inserisci ISBN");
		long isbn = sc.nextLong();
		ElementoBibliotecario[] res = (ElementoBibliotecario[]) biblioteca.stream().filter(e -> e.getIsbn() == isbn).toArray(ElementoBibliotecario[]::new);
		if (res.length>0) {
			System.out.println("Libro eliminato: "+res[0]);
			biblioteca.remove(res[0]);
		}
		else {
			System.out.println("Neasun risultato...");
		}
		

	}
	
	public static ElementoBibliotecario filtraIsbn() {	
		System.out.println("Inserisci ISBN");
		long isbn = sc.nextLong();
		
		ElementoBibliotecario[] f = biblioteca.stream()
					.filter(e -> e.getIsbn()==isbn)
					.toArray(ElementoBibliotecario[]::new);
		if (f.length>0) {
			System.out.println(f[0]);
			return f[0];
		}
		else {
			System.out.println("Nessun risultato...");
			return null;
		}
	}
	
	public static List<ElementoBibliotecario> filtraAnno(){
		System.out.println("Inserisci anno");
		int anno = sc.nextInt();
		 List<ElementoBibliotecario> list = biblioteca.stream().filter(e->e.getAnnoPubblicazione().getYear() == anno)
				 												.collect(Collectors.toList());
		 
		 list.forEach(e -> System.out.println(e));
		 if (list.size()==0) {
				System.out.println("Neasun risultato...");
			}
		return list;
	}
	
	public static List<ElementoBibliotecario> filtraAutore(){
		
		System.out.println("Inserisci l'autore");
		String autore = sc.next();
		List<ElementoBibliotecario> list = biblioteca.stream().filter(e -> e instanceof Libro)
																.filter(e -> ((Libro) e).getAutore().toLowerCase().contains(autore.toLowerCase()))
                                                                .collect(Collectors.toList());
		list.forEach(e -> System.out.println(e));
		if (list.size()==0) {
			System.out.println("Neasun risultato...");
		}
		
       return list;
   }
	
	public static void scriviElementi() throws IOException {
		
		String elemento = "";
		for (ElementoBibliotecario e : biblioteca) {
			if(elemento.length() != 0) {
				elemento += "/";
			}
			elemento += e;
		}
		
		FileUtils.writeStringToFile(file, elemento, "UTF-8");
		log.info("File di backup aggiornato correttamete!");
	}
	
	public static void leggiElementiDaFile() throws IOException {
		String elementi = FileUtils.readFileToString(file, "UTF-8");
		String[] arrEl = elementi.split("/"); //Singoli elementi bibliotecari
		
		long isbn;
		String titolo;
		LocalDate annoPubblicazione;
		int numeroPagine;

		for (int i=0; i<arrEl.length; i++) {
			System.out.println("Elementi: " + arrEl[i]);//Singoli elementi bibliotecari
			String[] fields = arrEl[i].split(",");// Campo + valore
			
			for (int j=0; j<fields.length; j++) {
				System.out.println("Campi: " + fields[j].toString());// Campo + valore
				String values = fields[j].split(":")[1];
				System.out.println("Valore: " + values);
				
				 
				 if (fields.length>5) {
					 String autore;
					 String genere;
				 }
				 
				 else {
				Periodicità periodicita;
				
				 }
				 isbn= arrEl[i].fields[0].values;
				
				
				}
			
			
			
		}
	}

}
