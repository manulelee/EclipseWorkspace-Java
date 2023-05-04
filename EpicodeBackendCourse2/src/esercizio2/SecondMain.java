package esercizio2;

public class SecondMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Chiamata chiamata1 = new Chiamata("xxxxxxx090", "xxxxxxx43", 121, 0.3);
		 Chiamata chiamata2 = new Chiamata("xxxxxxx090", "xxxxxxx89", 142, 0.6);
		 Chiamata chiamata3 = new Chiamata("xxxxxxx090", "xxxxxxx23", 0.6, 0.8);
		 Chiamata chiamata4 = new Chiamata("xxxxxxx090", "xxxxxxx81", 13, 0.1);
		 Chiamata chiamata5 = new Chiamata("xxxxxxx090", "xxxxxxx12", 21, 0.1);
		 Chiamata chiamata6 = new Chiamata("xxxxxxx090", "xxxxxxx25", 41, 0.4);
		 Chiamata chiamata7 = new Chiamata("xxxxxxx090", "xxxxxxx77", 51, 0.5);
		 
		 Chiamata[] calls = {chiamata1, chiamata2, chiamata3, chiamata4, chiamata5, chiamata6, chiamata7};
		 
		 Sim	sim1 = new Sim ("xxxxxxx090", 0,calls) ;
		 sim1.infoSim();
	}

}
