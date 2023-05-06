package com.epicode.emanueleSyrbe;
import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		String title;
		int time;
		
		ElementoMultimediale[] myElements = new ElementoMultimediale[2];
		System.out.println("Inserisci " + myElements.length + " elementi multimediali per iniziare...");
		
		for(int i=0; i<myElements.length; i++) {
			
			int type;
			
			do {
			System.out.println();
			System.out.println("Seleziona il tipo di elemento multimediale da inserire:");
			System.out.println("Premere 1 per inserire un immagine;");
			System.out.println("Premere 2 per inserire una registrazione audio;");
			System.out.println("Premere 3 per inserire un video;");
			
			type = sc.nextInt();
			
			if (type <=0 || type>3) {
				System.out.println("Errore, seleziona una tipologia di elemento multimediale valida");
			}
			
			System.out.println();
			}
			while (type <=0 || type >3);
			
			switch(type) {
			
			case 1: 
				System.out.println("---------------Nuova Immagine---------------");
				System.out.println("Inserisci il titolo:");
				title = sc.next();
				myElements[i]= new Immagine(title);
				break;
				
			case 2: 	
				System.out.println("----------------Nuovo Audio-----------------");
				System.out.println("Inserisci il titolo:");
				title = sc.next();
				System.out.println("Inserisci la durata:");
				time = sc.nextInt();
				myElements[i]= new Audio(title, time);
				break;
				
			case 3: 	
				System.out.println("----------------Nuovo Video-----------------");
				System.out.println("Inserisci il titolo:");
				title = sc.next();
				System.out.println("Inserisci la durata:");
				time = sc.nextInt();
				myElements[i]= new Video(title, time);
				break;
				
				default: System.out.println("Errore, scelta non valida");
			break;
			}
			
		}
		
		System.out.println();
		System.out.println("Hai inserito " + myElements.length +" elementi!");
		
		System.out.println();
		System.out.println("I miei elementi:");
		
		while (true) {
			System.out.println();
			System.out.println("Scegli dalla lista un Elemento Multimediale da eseguire: (0 per terminare)");
			System.out.println();
				for(int i=0; i<myElements.length; i++) {
					System.out.println( (i+1) + " - " + myElements[i]);
				}
			int selected = sc.nextInt();
			if (selected!=0) {
				if (selected>0 && selected<=myElements.length) {
					if (myElements[selected -1] instanceof Immagine) {
						Immagine i = (Immagine) myElements[selected-1];
						int m;
						do {
							System.out.println("Possibili metodi per " + i.titolo);
							System.out.println("1 - Riproduci.");
							System.out.println("2 - Aumenta luminosità.");
							System.out.println("3 - Diminuisci luminosità.");
							
							System.out.println("Seleziona un metodo:");
							m = sc.nextInt();
							if (m<0 || m>3) {
								System.out.println("Errore! Seleziona un metodo valido...");
							}
						}
						while (m<0 || m>3);
						
						switch (m) {
							case 1: i.show();break;
							case 2: i.aumentaLuminosita();break;
							case 3: i.riduciLuminosita();;break;
							default: System.out.println("Il metodo selezionato non esiste"); break;
						
					}
					}
					else if (myElements[selected -1] instanceof Audio) {
						Audio a = (Audio) myElements[selected-1];
						int m;
						do {
							System.out.println("Possibili metodi per " + a.titolo);
							System.out.println("1 - Riproduci.");
							System.out.println("2 - Alza volume.");
							System.out.println("3 - Abbassa volume.");
							
							System.out.println("Seleziona un metodo:");
							m = sc.nextInt();
							if (m<0 || m>3) {
								System.out.println("Errore! Seleziona un metodo valido...");
							}
						}
						while (m<0 || m>3);
						
						switch (m) {
							case 1: 
								if (a.durata > 0) {
									a.play();
								}
								else {
									System.out.println(a.titolo + " non riproducibile; la durata deve essere maggiore di 0");
								}
								break;
							case 2: a.alzaVolume();break;
							case 3: a.abbassaVolume();break;
							default: System.out.println("Il metodo selezionato non esiste"); break;
						
					}
						
					}
					else if (myElements[selected -1] instanceof Video) {
						Video v = (Video) myElements[selected-1];
						int m;
						do {
							System.out.println("Possibili metodi per " + v.titolo);
							System.out.println("1 - Riproduci.");
							System.out.println("2 - Alza volume.");
							System.out.println("3 - Abbassa volume.");
							System.out.println("4 - Aumenta luminosità.");
							System.out.println("5 - Diminuisci luminosità.");
							
							
							System.out.println("Seleziona un metodo:");
							m = sc.nextInt();
							if (m<0 || m>5) {
								System.out.println("Errore! Seleziona un metodo valido...");
							}
						}
						while (m<0 || m>5);
						
						switch (m) {
							case 1: 
								if (v.durata > 0) {
									v.play();
								}
								else {
									System.out.println(v.titolo + " non riproducibile; la durata deve essere maggiore di 0");
								}
								break;
							case 2: v.alzaVolume();break;
							case 3: v.abbassaVolume();break;
							case 4: v.aumentaLuminosita();break;
							case 5: v.riduciLuminosita();break;
							default: System.out.println("Il metodo selezionato non esiste"); break;
						
					}
					}
				
				}
				else {
					System.out.println("Scelta non valida");
				}
			}
			else {
				System.out.println("Vuoi chiudere il player?... true/false");
				boolean c = sc.nextBoolean();
				if (c) {
					System.out.println("....Player teminato....");
				break;
				}
				}
			}
		}
		

	}


