import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {

	public static void main(String[] args) {
	
		Logger log = LoggerFactory.getLogger(MainProject.class);
				
				log.info("Test Logger!!!");
				log.error("Test Error!");
				log.warn("Test Warning!");
				log.debug("Test Debug");


	}

}
