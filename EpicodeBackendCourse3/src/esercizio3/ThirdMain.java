package esercizio3;

import java.util.Scanner;

public class ThirdMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----------DividiStringa----------");
		dividiStringa();
		
	}
	
	public static void dividiStringa () {
	
	   String str;
	   int counter=1;
	
	do {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(counter + " ciclo:");
		System.out.println("Inserisci una stringa");
		str = sc.nextLine();
		//System.out.println(str);
		if (str.equals(":q")) {
			break;
		}
		for (int i=0; i<str.length(); i++) {
			System.out.print(str.charAt(i)+",");
		}
		System.out.println();
		counter++;
		
}
	while (!str.equals(":q"));

}}
