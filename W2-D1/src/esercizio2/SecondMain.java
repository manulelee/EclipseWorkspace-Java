package esercizio2;
import java.util.Scanner; 

public class SecondMain {

static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Inserire i Km percorsi: ");
		int kmPercorsi = Integer.parseInt(sc.nextLine());
		System.out.print("Inserire i litri di carburante consumati: ");
		int carburanteConsumato =  Integer.parseInt(sc.nextLine());
		
		try {
			int distanza = kmPercorsi/carburanteConsumato;
			System.out.println("La tua auto percorre " + distanza + " Km/litro");
		} catch (ArithmeticException e) {
			System.out.println("Il consumo non può essere mimnore di 1!");
		} catch (Exception e) {
			System.out.println("ERRORE");
		}

	}

}

