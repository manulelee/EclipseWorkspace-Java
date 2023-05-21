package dao;

import javax.persistence.EntityManager;

import model.Utente;
import utils.JpaUtil;

public class UtenteDAO implements InterfaceUtenteDAO{

	@Override
	public void aggiungi(Utente u) {
		// TODO Auto-generated method stub
		  EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	        try {
	            em.getTransaction().begin();
	            em.persist(u);
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            System.out.println("Utente " + u.getNome() +" "+  u.getCognome()+" salvato nel database");
	            em.getTransaction().rollback();
	            System.out.println("Errore durante il salvataggio di " + u.getNome() +" "+  u.getCognome() + ")...");
	        } finally {
	            em.close();
	        }
	}

}
