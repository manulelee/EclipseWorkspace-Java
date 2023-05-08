package esercizio2;
import java.util.Scanner; 

public class SecondMain {

static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Inserire i Km percorsi: ");
		int kmPercorsi = sc.nextInt();
		System.out.print("Inserire i litri di carburante consumati: ");
		int carburanteConsumato =  sc.nextInt();
		
		try {
			int distanza = kmPercorsi/carburanteConsumato;
			System.out.println("La tua auto percorre " + distanza + " Km/litro");
		} catch (ArithmeticException e) {
			System.out.println("Il consumo deve essere maggiore di 0!");
		} catch (Exception e) {
			System.out.println("ERRORE");
		}

	}

}

