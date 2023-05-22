package controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.ElementoBibliotecarioDAO;
import dao.PrestitoDAO;
import dao.UtenteDAO;
import model.ElementoBibliotecario;
import model.Libro;
import model.Prestito;
import model.Rivista;
import model.Utente;
import utils.JpaUtil;
import utils.Periodicità;

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		ElementoBibliotecario l1= new Libro("Libro1", 2021, 200, "Fantasy","Rowling");
		ElementoBibliotecario r1= new Rivista("Rivista1", 2021, 200, Periodicità.MENSILE);
		ElementoBibliotecario l2= new Libro("Libro2", 2023, 100, "Fantasy","Talkien");
		
		
		ElementoBibliotecarioDAO El_Dao = new ElementoBibliotecarioDAO();
		//dao.aggiungi(l2);
		//El_Dao.tuttiGliElementiBibliotecari().forEach(el -> System.out.println(el));;
	
		//dao.cercaAnnoPubblicazione(2023).forEach(el -> System.out.println(el));;
		//El_Dao.cercaAutore("commedia").forEach(el -> System.out.println(el));;
		
		UtenteDAO U_Dao = new UtenteDAO();
		Utente u1 = new Utente("Emanuele", "Syrbe", LocalDate.of(1997, 01, 27));
		
		//U_Dao.aggiungi(u1);
		
		PrestitoDAO P_Dao = new PrestitoDAO();
		
		
//		Prestito p1 = new Prestito(u1, l2);
//		P_Dao.aggiungi(p1);
	}

}
