package obstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Amazon.Shopping.CartPage;

public class ObstractComponents {
	
	WebDriver driver;
	public ObstractComponents(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);// with out this step find by annotation will not work 
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cardHeader;

	// explicit wait method visibility of element located
	public void waitForelementToAppear(By findBy) 
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	// explicit wait method for invisibility of element located
	public void waitForelementToDissapear(WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public CartPage clickOnCart() 
	{
		cardHeader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}

}
