package com.epicode.emanueleSyrbe;

public abstract class ElementoMultimediale {
	
 private String titolo;
 
	public ElementoMultimediale (String titolo) {
	 this.titolo=titolo;
	}
	protected String getTitolo () {
		return this.titolo;
	}
	
	@Override
	public String toString() {
		return  this.titolo;
	}

}
 