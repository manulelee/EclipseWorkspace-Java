package esercizio2;

import java.util.Arrays;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SecondMain {

	public static Logger log = LoggerFactory.getLogger(SecondMain.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[3000];
		for (int i=0; i<array.length; i++) {
			array[i]= randomNumberGenerator();
			System.out.println("Indice: " + i + " - valore: " + array[i]);
		}
		
		int[] array1 = Arrays.copyOfRange(array, 0, 1000);
		int[] array2 = Arrays.copyOfRange(array, 1000, 2000);
		int[] array3 = Arrays.copyOfRange(array, 2000, 3000);
		
		
		MultiThread t1 = new MultiThread(array1);
		MultiThread t2 = new MultiThread(array2);
		MultiThread t3 = new MultiThread(array3);
		
		try {
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.error("Errore: " + e.getMessage());
			e.printStackTrace();
		}
		
	
		
		
		log.info("Somma dei parziali: " + (t1.sommaParziale + t2.sommaParziale + t3.sommaParziale));
		
	}
	
	public static int randomNumberGenerator() {
		  Random r = new Random();
		   int n = r.nextInt(101);
			return n;
		}

}
