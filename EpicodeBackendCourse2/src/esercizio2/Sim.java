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
		System.out.println("Credito residuo: "+ this.credito);
		System.out.println("Lista chiamate:");
		for (int i=chiamate.length-1; i>chiamate.length-6; i--) {
			System.out.println("da: " + chiamate[i].from + " a: " + chiamate[i].to + " durata: " + chiamate[i].time);
		}
	}

}
