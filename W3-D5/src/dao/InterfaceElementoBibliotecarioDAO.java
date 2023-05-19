package dao;

import java.util.List;

import model.ElementoBibliotecario;

public interface InterfaceElementoBibliotecarioDAO {

	public void aggiungi (ElementoBibliotecario e);
	public ElementoBibliotecario cercaIsbn (Integer isbn);
	public ElementoBibliotecario cercaAnnoPubblicazione (int anno);
	public ElementoBibliotecario cercaAutore (String autore);
	public ElementoBibliotecario cercaTitolo (String titolo);
	
	public List<ElementoBibliotecario> cercaPrenotazioniDaNumeroTessera(String numeroTessera);
	public List<ElementoBibliotecario> cercaPrenotazioniScadute();
	public List<ElementoBibliotecario> tuttiGliElementiBibliotecari();
}
