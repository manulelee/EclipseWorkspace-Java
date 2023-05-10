package esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread extends Thread {
	
	static Logger log = LoggerFactory.getLogger(MyThread.class);

	String simbolo;

	public MyThread(String simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	for (int i=0; i<10; i++) {
		try {
			Thread.sleep(1000);
			log.info("Index: "+i+" - Symbol: "+ simbolo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}
	
	
	
}
