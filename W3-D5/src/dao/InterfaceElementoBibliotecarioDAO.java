package dao;

import java.util.List;

import model.ElementoBibliotecario;

public interface InterfaceElementoBibliotecarioDAO {

	public void aggiungi (ElementoBibliotecario e);
	public ElementoBibliotecario cercaIsbn (Integer isbn);
	public List<ElementoBibliotecario>  cercaAnnoPubblicazione (int anno);
	public List<ElementoBibliotecario>  cercaAutore (String aut);
	public List<ElementoBibliotecario>  cercaTitolo (String titolo);
	public List<ElementoBibliotecario> tuttiGliElementiBibliotecari();
}
