package beta;

import org.apache.logging.log4j.*;

public class Demo1 {

private static Logger log = LogManager.getLogger(Demo1.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		log.error("Demo1 Unable to click on button");
		log.fatal("Demo1 Fatal error displayed");
		log.info("Demo1 successfully entered username and password");
		log.debug("Demo1 debug information displayed");
	}
}
