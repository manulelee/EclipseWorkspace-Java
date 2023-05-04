package esercizio3;

public class Articolo {
	public String codice;
	public String descrizione;
	public double prezzo;
	public int disponibilità;
	
	public Articolo (String c, String desc, double p, int disp) {
		this.codice=c;
		this.descrizione=desc;
		this.prezzo=p;
		this.disponibilità=disp;
	}
	
	public void stampaDescrizione () {
		System.out.println("Codice articolo: "+ this.codice + " descrizione articolo: "+ this.descrizione + " prezzo articolo: "+ this.prezzo + "€ disponibilità: "+ this.disponibilità);
	}
}
