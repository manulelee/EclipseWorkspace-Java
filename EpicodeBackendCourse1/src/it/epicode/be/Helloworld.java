package it.epicode.be;

import java.util.Scanner;

public class Helloworld {

public static void main (String[] args)
		{
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		System.out.println("");

		System.out.println("Metodo moltiplica:");
		System.out.println(moltiplica(7,2));
		System.out.println("");

		System.out.println("Metodo concatena:");
		System.out.println(concatena(2,"numero: "));
		System.out.println("");

		System.out.println("Metodo inserisciInArray:");
		
		String array[]= {"ciao", "a", "tutti", "sono", "Emanuele"};
		System.out.println("");
		System.out.println("Array originale:");
		for (int i=0; i<5; i++) {
			System.out.println(array[i]);
		}
		System.out.println("");

		System.out.println("Array modificato:");
		for (int i=0; i<6; i++) {
			System.out.println(inserisciInArray(array, "VOI")[i]);
		}
		System.out.println("");
		arrayInvertito();
		
		System.out.println("");
		System.out.println(perimetroRettangolo());
		System.out.println("");
		System.out.println(pariDispari());
		System.out.println("");
		perimetroTriangolo();
		}

public static int moltiplica(int num1, int num2) {
	return num1 * num2;
}

public static String concatena(int num, String stringa) {
	return stringa + num;
}

public static String[] inserisciInArray (String arr[], String stringa ){
	String array[] = new String[6];
	array[0]=arr[0];
	array[1]=arr[1];
	array[2]=stringa;
	array[4]=arr[3];
	array[5]=arr[4];
	return array;
}

public static void arrayInvertito () {
	
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	String array[] = new String[3];
	
	System.out.println("Inserisci la prima stringa");
	array[0] = sc.nextLine();
	
	System.out.println("Inserisci la seconda stringa");
	array[1] = sc.nextLine();

	System.out.println("Inserisci la terza stringa");
	array[2] = sc.nextLine();
	
	System.out.println("Array originale:");
	for(int i=0; i<array.length; i++) {
		System.out.print(array[i]);
	}
	System.out.println("");
	System.out.println("Array in ordine inverso:");
	for(int i=2; i>=0; i--) {
		System.out.print(array[i]);
	}
	System.out.println("");
}

public static double perimetroRettangolo () {
	System.out.println("Calcola Perimetro:");
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	System.out.println("Inserisci la base");
	double l1 =  sc.nextDouble();
	System.out.println("Inserisci l'altezza");
	double l2 = sc.nextDouble();
	return (l1*2)+(l2*2);
}

public static int pariDispari() {
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	System.out.println("Inserisci un numero intero");
	int n =  sc.nextInt();
	int result;
	if (n%2==0) {
		result=0;
	}
	else {
	 result=1;
	}
	return result;
	}
public static double perimetroTriangolo() {
	System.out.println("Calcola Perimetro:");
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	System.out.println("Inserisci il primo lato");
	double a =  sc.nextDouble();
	System.out.println("Inserisci il secondo lato");
	double b = sc.nextDouble();
	System.out.println("Inserisci il terzo lato");
	double c = sc.nextDouble();
	double p = (a+b+c)/2;
	System.out.println("Perimetro: "+p);
	double area = (Math.sqrt(p*(p-a)*(p-b)*(p-c)));
	System.out.println("L'area del triangolo è: "+area);
return area;
}
}








