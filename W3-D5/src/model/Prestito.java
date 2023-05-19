package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="prestiti")
public class Prestito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Utente utente;
	@OneToOne
	private ElementoBibliotecario elementoPrestato;
	@Column(name= "inizio_prestito")
	private LocalDate dataInizioPrestito = LocalDate.now();
	@Column(name= "restituzione_prevista")
	private LocalDate dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
	@Column(name= "restituzione_effettiva")
	private LocalDate dataRestituzioneEffettiva;
	
	public Prestito(Utente utente, ElementoBibliotecario elementoPrestato) {
		super();
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
	}
	
	public Prestito() {
		super();
	}
	
	
	

}
