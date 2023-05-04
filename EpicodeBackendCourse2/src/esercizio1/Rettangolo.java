package esercizio1;

import java.util.Scanner;

public class Rettangolo {
	public static int i=1;
	public int count;
public double l1;
public double l2;
public double a;
public double p;

public Rettangolo(){
	System.out.println("Rettangolo " +i);
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	System.out.println("Inserisci la base");
	double lato1 =  sc.nextDouble();
	System.out.println("Inserisci l'altezza");
	double lato2 = sc.nextDouble();
	this.l1=lato1;
	this.l2=lato2;
	this.count=i;
	i++;
}
public void stampaRettangolo() {
	this.p= ((this.l1+this.l2)*2);
	this.a= (this.l1 * this.l2);
	System.out.println("Area: " + this.a + " perimetro: " +this.p);
}

public static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
	System.out.println("Rettangolo "+r1.count);
	r1.stampaRettangolo();
	
	System.out.println("Rettangolo "+r2.count);
	r2.stampaRettangolo();
	double sa = r1.a+r2.a;
	double sp = r1.p+r2.p;
	System.out.println("Somma area: " + sa + " - Somma perimetri: "+ sp);
}
}

