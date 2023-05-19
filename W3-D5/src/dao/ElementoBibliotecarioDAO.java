package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ElementoBibliotecario;
import utils.JpaUtil;

public class ElementoBibliotecarioDAO implements InterfaceElementoBibliotecarioDAO{

	@Override
	public void aggiungi(ElementoBibliotecario el) {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		System.out.println();
		System.out.println(el.toString());
		System.out.println();
		try {
			em.getTransaction().begin();
			em.persist(el);
			em.getTransaction().commit();
			System.out.println("Elemento Bibliotecario (ISBN: " + el.getIsbn() + ") salvato nel database");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore durante il salvataggio (ISBN: " + el.getIsbn() + ")...");
		} finally {
			em.close();
		}
	}

	@Override
	public ElementoBibliotecario cercaIsbn(Integer isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			ElementoBibliotecario elem =  em.find(ElementoBibliotecario.class, isbn);
			em.getTransaction().commit();
			return elem;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Errore durante il recupero dell'elemento...");
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public ElementoBibliotecario cercaAnnoPubblicazione(int anno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElementoBibliotecario cercaAutore(String autore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElementoBibliotecario cercaTitolo(String titolo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ElementoBibliotecario> cercaPrenotazioniDaNumeroTessera(String numeroTessera) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ElementoBibliotecario> cercaPrenotazioniScadute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ElementoBibliotecario> tuttiGliElementiBibliotecari() {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createQuery("SELECT elemento FROM ElementoBibliotecario elemento");
			return q.getResultList();
		} finally {
			em.close();
		}
	
	}

	
}
