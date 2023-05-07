package com.epicode.emanueleSyrbe;

public class Audio extends ElementoMultimediale implements Volume{
	
 private int durata;
 private static int volume = 1;
 
	public Audio(String titolo, int durata) {
		super(titolo);
		this.durata=durata;
		
	}
	public int getDurata() {
		return this.durata;
	}

	public void play() {
			String puntiEsclamativi="";
			for (int i = 0; i<volume; i++) {
				puntiEsclamativi+="!";
			}
			
			for (int i=0; i<this.durata; i++) {
				System.out.println(this.getTitolo() + " - volume: " + puntiEsclamativi);
			}
	}

	
	public void alzaVolume() {
		if (volume >=10) {
			System.out.println("Volume massimo 10"); 
		}
		else {			
			volume ++;
		}
		System.out.println("Volume attuale: " + volume); 
		
	}

	public void abbassaVolume() {
		if (volume <=0) {
			System.out.println("Volume minimo 0"); 
		}
		else {			
			volume --;
		}
		System.out.println("Volume attuale: " + volume); 
	}

	
	@Override
	public String toString() {
		return this.getTitolo() +" - " + this.durata + " min." + " (audio)";
	}
}
