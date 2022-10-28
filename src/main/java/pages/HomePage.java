package pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonActions;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//WebDriver driver;
	
	@FindBy(id = "ssp-service-zip")
	WebElement zipCodElement;
	
	@FindBy(xpath = "//div[@class='product-cards']/div[@class='card' and contains(.,'Auto')]")
	WebElement autoProductElement;
	
	@FindBy(id = "bundleModalBtn")
	WebElement startMyQuotElement;
	
	@FindBy(xpath = "(//input[@value='Continue'])[1]")
	WebElement continuElement;

	//WebElement zipElement1= driver.findElement(By.id("ssp-service-zip"));

	public void autoSteps() {
		CommonActions.input(zipCodElement,"11203");
		CommonActions.click(autoProductElement);
		CommonActions.click(startMyQuotElement);
		CommonActions.click(continuElement);
	}


}
