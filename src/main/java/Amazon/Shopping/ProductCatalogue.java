package Amazon.Shopping;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import obstractComponent.ObstractComponents;

public class ProductCatalogue extends ObstractComponents {
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver); // in every chield class this super class is needed fo satisfy parent class.
		//initialization 
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	// Here why we use by insted of @findBy annotation
	// FindBy annoation will work for driver methods only. here we are taking webelemenst as list so that's why 
	// we used By as 
	By ProductsBy = By.cssSelector(".mb-3"); // this is action method it will get the product list 
	By AddToCartBy = By.cssSelector(".mb-3 button:last-of-type");
	By ToastContainer = By.cssSelector("#toast-container");
	public List<WebElement> getProductList() {
		waitForelementToAppear(ProductsBy);
		return products;
	}
	
	public WebElement getproductByname(String productName) 
	{
		WebElement prod =	getProductList().stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart( String productName) 
	{
		WebElement prod = getproductByname(productName);
		prod.findElement(AddToCartBy).click();
		waitForelementToAppear(ToastContainer); // this will capture the item successfully added to cart message.
		waitForelementToDissapear(spinner);
	}

}
