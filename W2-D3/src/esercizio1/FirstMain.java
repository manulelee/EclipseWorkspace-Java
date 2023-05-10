package esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMain {
	
	static Logger log = LoggerFactory.getLogger(FirstMain.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new MyThread("*");
		Thread t2= new MyThread("#");
		
	
		log.info("----- Primo Esercizio ------");
		
		t1.start();
		t2.start();
	}

}
