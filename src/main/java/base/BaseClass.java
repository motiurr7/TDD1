package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import utils.Configuration;
import static utils.IConstant.*;

import java.time.Duration;


public class BaseClass { 
	Configuration config =new Configuration();
	protected WebDriver driver;
	protected HomePage homePage;
	@BeforeMethod
	public void setUpDriver() {
		initDriver();
			//WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			//driver.manage().window().fullscreen();
			//driver.manage().deleteAllCookies();
			//driver.get("https://www.geico.com/");		
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
			driver.manage().window().maximize();
			//driver.get(config.getProperties().getProperty("url"));
			driver.get(config.getProperty(URL));
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(config.getProperties().getProperty(IMPLICIT_WAIT.name())));
			long pageLoadTime = Long.parseLong(config.getProperty(PAGELOAD_WAIT));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
		
			long implicitWait = Long.parseLong(config.getProperty(IMPLICIT_WAIT));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
			initClasses();
		 
			
	}
	
	private void initDriver() {
		String browserName = config.getProperty(BROWSER);
		switch (browserName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
			break;
			
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new ChromeDriver();
			break;
			
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		
	}
	
	
	private void initClasses() {
		
		homePage = new HomePage(driver);
		
		
		
		
	}
	
	
	
	
	
	
	public WebDriver getDriver() { 
		return driver;
	}
	
	@AfterMethod
	public void closingDriverSession() {
		getDriver().quit();
	}
	
}
