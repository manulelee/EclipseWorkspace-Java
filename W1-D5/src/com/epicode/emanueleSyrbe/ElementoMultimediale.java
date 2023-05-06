package com.epicode.emanueleSyrbe;

public abstract class ElementoMultimediale {
	
 public String titolo;
 
	public ElementoMultimediale (String titolo) {
	 this.titolo=titolo;
	}
	
	@Override
	public String toString() {
		return  this.titolo;
	}

}
 