 package Amazon.Shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import obstractComponent.ObstractComponents;

public class CheckOutPages extends ObstractComponents {

	WebDriver driver;
	public CheckOutPages(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement  Country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')])[2]")
	WebElement  selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement  SubmitBUtton;
	
	By results = By.cssSelector(".ta-results");
	public void selectCountry(String countryName) 
	{
		Actions a = new Actions(driver);
		a.sendKeys((Country), countryName).build().perform();
		waitForelementToAppear(results);
		selectCountry.click();
	}
	
	public confirmationPage submitOrder() 
	{
		SubmitBUtton.click();
		confirmationPage confirmationpage = new confirmationPage(driver);
		return confirmationpage;
	}
	
/*	Actions a = new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "target").build().perform();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	driver.findElement(By.cssSelector(".action__submit")); */
	
}
