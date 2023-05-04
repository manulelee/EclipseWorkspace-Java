package esercizio3;

import java.time.LocalDate;

public class Cliente {
	public String codiceCliente;
	public String nome;
	public String cognome;
	public String email;
	public LocalDate dataIscrizione;
	public Carrello carrello;

	
	public Cliente (String cod, String nome,String cognome, String email, String dataIscrizione, Carrello cart) {
		this.codiceCliente=cod;
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
		this.dataIscrizione= LocalDate.now();
		this.carrello=cart;
	}
	
	
	
	public void stampaCliente () {
		System.out.println("ID: "+ this.codiceCliente + " - Nome: "+ this.nome + " - Cognome: "+ this.cognome);
	}
	
}
