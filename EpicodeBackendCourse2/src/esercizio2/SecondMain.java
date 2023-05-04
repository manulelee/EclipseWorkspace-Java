package esercizio2;

public class SecondMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 
		 Sim	sim1 = new Sim ("xxxxxxx090", 0,new Chiamata[5]) ;
		 sim1.infoSim();
		 System.out.println("");
		 sim1.ricarica(10);
		 System.out.println("");
		 sim1.chiamate[0] = new Chiamata(sim1.numero, "xxxxxxx43", 121, 0.3);
		 sim1.chiamate[1]  = new Chiamata(sim1.numero, "xxxxxxx89", 142, 0.6);
		 sim1.chiamate[2]  = new Chiamata(sim1.numero, "xxxxxxx23", 0.6, 0.8);
		 sim1.chiamate[3]  = new Chiamata(sim1.numero, "xxxxxxx81", 13, 0.1);
		 sim1.chiamate[4]  = new Chiamata(sim1.numero, "xxxxxxx12", 21, 0.1);
		
		 sim1.infoSim();
	}

}
