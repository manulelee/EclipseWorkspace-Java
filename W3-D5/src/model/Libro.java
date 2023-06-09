package model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="libri")
public class Libro extends ElementoBibliotecario{
	
	@Column(nullable = false)
	private String autore;
	
	@Column(nullable = false)
	private String genere;
	
	public Libro() {
		super();
	}

	public Libro(String titolo, int annoPubblicazione, int numeroPagine, String autore,
			String genere) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro ISBN:" + super.getIsbn() + ", titolo: " + super.getTitolo() + ", anno di pubblicazione: " + super.getAnnoPubblicazione()
				+ ", numero di pagine: " + super.getNumeroPagine() + ", autore: " + autore + ", genere: " + genere;
	} 

	
	

}
