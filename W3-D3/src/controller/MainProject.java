package controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Evento;
import model.TipoEvento;


public class MainProject {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3-D3");
    static EntityManager em = emf.createEntityManager();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Evento e1 = new Evento("Aperitivo con Emanuele Umberto",LocalDate.of(2023, 5, 20), "Aperitivo a Parioli", TipoEvento.PRIVATO, 10);
//		save(e1);		
//		
//		Evento e1=getById(1);
//		System.out.println(e1);
//		
//		Evento e2 = new Evento("Aperitivo con Stefano Casasola",LocalDate.of(2023, 6, 2), "Aperitivo a Milano", TipoEvento.PUBBLICO, 200);
//		save(e2);	
//		
//		Evento e2=getById(2);
//		System.out.println(e2);
//		e2.setDataEvento(LocalDate.of(2023, 05, 17));
//		System.out.println(e2);
//		refresh(e2);
//		System.out.println(e2);
//		
//		Evento e2=getById(2);
//		delete(e2);		
		
		
	}

	
	public static void save(Evento e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("Evento " + e.getTitolo() + "("+ e.getDataEvento()+") "+ " aggiunto nel sistema...");
	}
	
	public static Evento getById(Integer id) {
		em.getTransaction().begin();
		Evento e = em.find(Evento.class, id);
		em.getTransaction().commit();
		return e;
	}
	
	public static void delete(Evento e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Evento " + e.getTitolo() + "("+ e.getDataEvento()+") "+ " eliminato dal sistema...");
	}
	
	public static Evento refresh(Evento e) {
		em.refresh(e);
		return e;
	}
}
