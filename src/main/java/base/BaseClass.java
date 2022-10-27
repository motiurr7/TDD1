package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Configuration;
import static utils.Constant.*;

import java.time.Duration;


public class BaseClass { 
	Configuration config =new Configuration();
	protected WebDriver driver;
	@BeforeMethod
	public void setUpDriver() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver.manage().window().fullscreen();
			//driver.manage().deleteAllCookies();
			//driver.get("https://www.geico.com/");		
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
			driver.manage().window().maximize();
			//driver.get(config.getProperties().getProperty("url"));
			driver.get(config.getProperty(URL.name()));
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(config.getProperties().getProperty(IMPLICIT_WAIT.name())));
			long pageLoadTime = Long.parseLong(config.getProperty(PAGELOAD_WAIT.name()));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
		
			long implicitWait = Long.parseLong(config.getProperty(IMPLICIT_WAIT.name()));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		
			
	}
	
	public WebDriver getDriver() { 
		return driver;
	}
	
	@AfterMethod
	public void closingDriverSession() {
		getDriver().quit();
	}
	
}
