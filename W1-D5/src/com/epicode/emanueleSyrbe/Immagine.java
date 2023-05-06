package com.epicode.emanueleSyrbe;

public class Immagine extends ElementoMultimediale implements Luminosita {
	
	 public static int luminosità = 2;
	public Immagine(String titolo) {
		super(titolo);
		
		
		
	}
	public void show() {
			
			String asterischi="";
			for (int i = 0; i<luminosità; i++) {
				asterischi+="*";
			}
			
			System.out.println(this.titolo + " - luminosità: " + asterischi);
		}

	public void aumentaLuminosita() {
		if (luminosità >=10) {
			System.out.println("Luminosità massima 10"); 
		}
		else {			
			luminosità ++;
		}
		System.out.println("Luminosità attuale: " + luminosità); 
		
	}

	public void riduciLuminosita() {
		if (luminosità <=0) {
			System.out.println("Luminosità minima 0"); 
		}
		else {			
			luminosità --;
		}
		System.out.println("Luminosità attuale: " + luminosità); 
	}
	
	@Override
	public String toString() {
		return this.titolo + " (immagine)";
	}
}
	

