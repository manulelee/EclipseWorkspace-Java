package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.EntityManager;

import dao.GaraDiAtleticaDAO;
import dao.PartitaDiCalcioDAO;
import model.GaraDiAtletica;
import model.Location;
import model.Partecipazione;
import model.PartitaDiCalcio;
import model.Persona;
import utils.JpaUtil;
import utils.TipoEvento;

public class MainProject {

	static EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
        Location l1 = new Location("Stadio","Cagliari");
        Location l2 = new Location ("Stadio", "nonSoDove");
      
        Set<Partecipazione> s1 = Set.of(new Partecipazione());
        Set<Partecipazione> s2 = Set.of(new Partecipazione(), new Partecipazione());
        
        Set<Persona> atleti = Set.of(new Persona(), new Persona(), new Persona());
     
       PartitaDiCalcio partita1 = new PartitaDiCalcio("Partita cagliari - Roma", LocalDate.of(2023, 5, 20), null, TipoEvento.PUBBLICO, 2500, s1, l1, "Cagliari", "Roma", "Roma", 1,2);
       
      //new PartitaDiCalcioDAO().save(partita1);
      
      //GaraDiAtletica gara1 = new GaraDiAtletica("Corsa 4km", LocalDate.of(2023, 8, 12), "Pazzi quelli che corrono", TipoEvento.PUBBLICO, 300, s2, l2, atleti, new Persona());
      GaraDiAtletica gara1 = new GaraDiAtletica();
      new GaraDiAtleticaDAO().save(gara1);
        	
	}

}
