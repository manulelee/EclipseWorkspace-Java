package esercizio2;

public class Sim {
	public String numero;
	public double credito;
	public Chiamata chiamate[];
	
	public Sim (String n, double c, Chiamata arr[]) {
		this.numero=n;
		this.credito=c;
		this.chiamate = arr;
	}
	
	public void infoSim () {
		System.out.println("Numero: "+ this.numero);
		System.out.println("Lista chiamate:");
		for (int i=chiamate.length-1; i>chiamate.length-6; i--) {
			if (chiamate[i]!=null) {
			System.out.println("Numero chiamato: " + chiamate[i].to + " - durata: " + chiamate[i].time + " - credito utilizzato: " + chiamate[i].creditUsed);
			this.credito-= chiamate[i].creditUsed;
		}}
		System.out.println("Credito residuo: "+ this.credito);
	}
	public void ricarica (int c)
	{
		this.credito+= c;
		 System.out.println("CREDITO RICARICATO: " + c + "€");
		System.out.println("CREDITO ATTUALE: "+ this.credito + "€");
	}
}
