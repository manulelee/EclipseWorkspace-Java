package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="persone")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column (nullable = false)
	private String nome;
	@Column (nullable = false)
	private String cognome;
	@Column (nullable = false)
	private String email;
	@Column (name="data_nascita", nullable = false)
	private LocalDate dataNascita;
	@Column (nullable = false)
	@Enumerated (EnumType.STRING)
	private Sesso sesso;
	private List<Partecipazione> listaPartecipazione;
	
	
	public Persona() {
	}

	public Persona(String nome, String cognome, String email, LocalDate dataNascita, Sesso sesso,
			List<Partecipazione> listaPartecipazione) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
		this.listaPartecipazione = listaPartecipazione;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	public List<Partecipazione> getListaPartecipazione() {
		return listaPartecipazione;
	}

	public void setListaPartecipazione(List<Partecipazione> listaPartecipazione) {
		this.listaPartecipazione = listaPartecipazione;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", dataNascita="
				+ dataNascita + ", sesso=" + sesso + ", listaPartecipazione=" + listaPartecipazione + "]";
	}
	
	
}
