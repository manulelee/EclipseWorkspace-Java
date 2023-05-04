package esercizio4;

import java.util.Scanner;

public class FourthMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countdown();
	}
	public static void countdown () {
		int n;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci un numero intero:");
		n = sc.nextInt();
		for (int i=n; i>=0; i--) {
			System.out.println(i);
		}
	}

}
