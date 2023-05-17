package com.jdbcProject;

import java.sql.SQLException;
import java.time.LocalDate;

public class jdbcMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			Studente me = new Studente("Emanuele", "Syrbe", "m", LocalDate.of(1997, 01, 27), 8.0, 7, 9);
			
			DbConnection dbStudenti = new DbConnection();
			dbStudenti.inserisciStudente(me);
			
			me = dbStudenti.ricercaId(1);
			
			me.setNome("Carlo Emanuele");
			
			dbStudenti.aggiornaStudente(me);
			
			dbStudenti.cancellaId(2);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
