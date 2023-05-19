package model;

import utils.Genere;

public class Concerto extends Evento{
	private Genere genere;
	private Boolean inStreaming;
	
	public Genere getGenere() {
		return genere;
	}
	public void setGenere(Genere genere) {
		this.genere = genere;
	}
	public Boolean getInStreaming() {
		return inStreaming;
	}
	public void setInStreaming(Boolean inStreaming) {
		this.inStreaming = inStreaming;
	}
	
	
}
