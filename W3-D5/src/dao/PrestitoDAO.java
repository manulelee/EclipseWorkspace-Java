package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Prestito;
import utils.JpaUtil;

public class PrestitoDAO implements InterfacePrestitioDAO{

	@Override
	public void aggiungi(Prestito p) {
		// TODO Auto-generated method stub
		  EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	        try {
	            em.getTransaction().begin();
	            em.persist(p);
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            System.out.println("Prestito " + p.getId() + " salvato nel database");
	            em.getTransaction().rollback();
	            System.out.println("Errore durante il salvataggio (ISBN: " +p.getId() + ")...");
	        } finally {
	            em.close();
	        }
	}

	@Override
	public List<Prestito> prestitiDaTessera(String tessera) {
		  EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		  List<Prestito> res= null;
	        try {
	            em.getTransaction().begin();
	            Query q = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :tessera");
	            q.setParameter(":tessera", tessera);
	            res = q.getResultList();
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            System.out.println("Errore nel recupero dei prestiti");
	        } finally {
	            em.close();
	        }
	        return res;
	}

	@Override
	public List<Prestito> prestitiNonRestituiti(String tessera) {
		// TODO Auto-generated method stub
		 EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	        List<Prestito> res = null;
	        try {
	            em.getTransaction().begin();
	            Query q = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND p.dataRestituzionePrevista < CURRENT_DATE");
	            res = q.getResultList();
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	            System.out.println("Errore nel recupero dei prestiti");
	        } finally {
	            em.close();
	        }
	        return res;
	}

}
