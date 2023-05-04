package esercizio2;

import java.util.Scanner;

public class SecondMain {

	public static boolean r;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		do{
		System.out.println("----------StampaInLettere----------");
		stampaInLettere();
		System.out.println("Vuoi inserire un altro numero? true/false");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		r=sc.nextBoolean();
		}
		while (r);

	}
	
	public static void stampaInLettere (){
		System.out.println("Inserisci un numero intero");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		switch (n) {
		case 0: System.out.println("zero"); break;
		case 1: System.out.println("uno"); break;
		case 2: System.out.println("due"); break;
		case 3: System.out.println("tre"); break;
		default :  System.out.println("il valore inserito non rientra nel range!"); break;
		}
		
	}
}
