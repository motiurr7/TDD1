package common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import reporting.Logs;

public class CommonActions {
	public static void input (WebElement element, String value) {
		try {
			element.sendKeys(value);
			Logs.log(value+ "has been passed to ---> " +element );
		} catch (NullPointerException | NoSuchElementException e) {
			// TODO: handle exception
			e.printStackTrace();
			Logs.log("Elements Not FOund ---> "+element);
			Assert.fail();
		}
	}
	
	public static void click (WebElement element) {
		try {
			element.click();
			Logs.log(element+ " ---- has been clicked.  " );
		} catch (NullPointerException | NoSuchElementException e) {
			// TODO: handle exception
			e.printStackTrace();
			Logs.log("Elements Not FOund ---> "+element);
			Assert.fail();
		}
	}
	
}
