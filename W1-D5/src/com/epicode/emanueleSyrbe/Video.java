package com.epicode.emanueleSyrbe;

public class Video   extends ElementoMultimediale implements  Volume, Luminosita {
	
	 private int durata;
	 private static int volume = 2;
	 private static int luminosità = 2;
	 
		public Video(String titolo, int durata) {
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
			
			String asterischi="";
			for (int i = 0; i<luminosità; i++) {
				asterischi+="*";
			}
			for (int i=0; i<this.durata; i++) {
				System.out.println(this.getTitolo() + " - volume: " + puntiEsclamativi + " - luminosità: " + asterischi);
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
			return this.getTitolo() +" - " + this.durata + " min." + " (video)";
		}
	}
		
		
