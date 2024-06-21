package Amazon.Shopping;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import obstractComponent.ObstractComponents;

public class CartPage  extends ObstractComponents{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cardSection h3")
	List<WebElement> productTitle;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutElement;

	public Boolean verifyProductDisplay(String productName) 
	{
		Boolean match = productTitle.stream().anyMatch(cardProduct->
		cardProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPages CheckOutPage() 
	{
		checkoutElement.click();
		CheckOutPages checkoutpage = new CheckOutPages(driver);
		return checkoutpage;
	}
}
