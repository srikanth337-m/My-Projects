package Amazon.Shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import obstractComponent.ObstractComponents;


public class confirmationPage extends ObstractComponents{

	WebDriver driver;
	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath="//h1[contains(text(),\\\" Thankyou for the order. \\\")]")
	WebElement Message;
	
	public String validateSuccessMessage() 
	{
		System.out.println("validation successfully completed and reverting the merged changes");
		System.out.println("validation successfully completed and reverting the merged changes");
		System.out.println("validation successfully completed and reverting the merged changes");
		return Message.getText();
	}
	// String validation = driver.findElement(By.xpath("//h1[contains(text(),\" Thankyou for the order. \")]")).getText();
	//Assert.assertTrue(validation.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
}
