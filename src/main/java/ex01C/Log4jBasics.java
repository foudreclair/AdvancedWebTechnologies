package ex01C;

import org.apache.log4j.*;
public class Log4jBasics {
	protected static Logger log = Logger.getLogger(Log4jBasics.class);
    public static final String path = "src/resources/log4j.properties";
	public static void main(String[] args) {
		PropertyConfigurator.configure(path);
		log.info("INFO: Cool !");
		log.debug("DEBUG: Cool !");
		
	}
}	