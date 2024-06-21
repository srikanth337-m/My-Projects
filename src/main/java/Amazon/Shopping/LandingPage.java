package Amazon.Shopping;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import obstractComponent.ObstractComponents;

public class LandingPage extends ObstractComponents {
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization 
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement EmailId = driver.findElement(By.id("userEmail"));

	//pageFactory  // here we just decleared webElements only
	@FindBy(id="userEmail")// these 2 line pointing to 17th line 
	WebElement emailid;
	// like wise we are seclearing the elements using pageFactory only.
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	// here we are creating one action method to perform the all action are associated to the test.
	public ProductCatalogue loginApplication(String eMailId, String PassWord) 
	{
		emailid.sendKeys(eMailId);
		password.sendKeys(PassWord);
		login.click();
		// these are actionmethods for above pafe factory. 
		// we do not send data from page factory, we send data from your test only.
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
		
	}
	
	public void goTo() 
	{
		
		driver.get("https://rahulshettyacademy.com/client/");
		
	}
}
