package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.ElementoBibliotecarioDAO;
import model.ElementoBibliotecario;
import model.Libro;
import model.Rivista;
import utils.Periodicità;

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3-D5");
		EntityManager em = emf.createEntityManager();
		
		ElementoBibliotecario l1= new Libro("Libro1", 2021, 200, "Emanuele","commedia");
		ElementoBibliotecario r1= new Rivista("Rivista1", 2021, 200, Periodicità.MENSILE);
		ElementoBibliotecarioDAO dao = new ElementoBibliotecarioDAO();
		ElementoBibliotecario l2= new Libro("Libro2", 2023, 100, "Giagomo","romanzo");
		//dao.aggiungi(l2);
		
		dao.tuttiGliElementiBibliotecari().forEach(el -> System.out.println(el));;
	

		
	}

}
