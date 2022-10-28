package reporting;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.Reporter;



public class Logs {
	public static Logger logger = Logger.getLogger(Logs.class.getName());
	public static void log(String msg) {
		logger.log(Level.INFO,msg);
		Reporter.log(msg + "<br>");
		
	}
	
}
