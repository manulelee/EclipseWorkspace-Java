package esercizo1;
import java.util.Scanner;
import java.util.Random;

public class FirstMain {

	public static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
		int[]  myArray = new int[5];
		for (int i=0; i < myArray.length; i++) {
			myArray[i] = randomNumberGenerator();
		}
		printArray(myArray);
		changeValue(myArray);
	}
	
	public static int randomNumberGenerator() {
	  Random r = new Random();
	   int n = r.nextInt(10)+1;
		return n;
	}
	
	public static void printArray (int[] arr){
		for (int k=0; k<arr.length; k++) {
			System.out.println("Indice " + k + " - Numero: " + arr[k]);
		}
	}
	
	public static void changeValue(int[] arr) {
		int num, pos;
		boolean condition= true;
		do {
			System.out.println("Inserisci il nuovo valore: (0 per terminare)");
			num = sc.nextInt();
			if (num!=0) {
				System.out.println("Inserisci la posizione in cui inserire il nuovo valore");
				pos = sc.nextInt();
				try {
				arr[pos]=num;}
				catch(ArrayIndexOutOfBoundsException e ){
					System.out.println("Posizione " + pos + " fuori dall'intervallo");
				}
				catch (Exception e ) {
					System.out.println("Errore");
				}
				printArray(arr);
			}
			else {
				condition=false;
			}
		}
		while (condition);
	}
}
