package alpha;
import org.apache.logging.log4j.*;
public class Demo {
	
	private static Logger log = LogManager.getLogger(Demo.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		log.error("Unable to click on button");
		log.fatal("Fatal error displayed");
		log.info("successfully entered username and password");
		log.debug("debug information displayed");
	}

}
