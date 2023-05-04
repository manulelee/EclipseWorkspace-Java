package esercizio3;

public class Carrello {
	
	public Articolo[] prodotti;
	public String codiceCliente;
	public double prezzoTotale;

	
	public Carrello (Articolo[] arr, String cod) {
		this.prodotti=arr;
		this.codiceCliente=cod;
	}
	
	public void stampaCarrello() {
		System.out.println("ID: "+ this.codiceCliente);
		for (int i=0; i<prodotti.length; i++) {
			System.out.println("codice prodotto: "+ prodotti[i].codice +" - " + prodotti[i].descrizione + " - " +prodotti[i].prezzo + "€");
			prezzoTotale+=prodotti[i].prezzo;
		}
		System.out.println("Totale: "+ prezzoTotale);
	}
}
