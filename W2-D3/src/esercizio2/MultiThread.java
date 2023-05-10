package esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiThread extends Thread{

	static Logger log = LoggerFactory.getLogger(MultiThread.class);

	int sommaParziale;
	int[] array;
	

	public MultiThread (int[] arr) {
		this.array = arr;
		this.sommaParziale=0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	for (int i=0; i<array.length; i++) {
	this.sommaParziale+=array[i];
	}
	log.info("Parziale: "+sommaParziale);
	
	
	}
	
}
