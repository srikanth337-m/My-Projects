package Amazon.Shopping;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	
	
	public void SubmitOrder () throws IOException {
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";
		// below 4 lines of code is used for all the test case. It is common for all tests.
		// For that we can put that in base class. 
	/*	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// implicite wait at global level.
		driver.manage().window().maximize(); */
		// driver.get("https://rahulshettyacademy.com/client/");
		
	/*	driver.findElement(By.id("userEmail")).sendKeys("srikanth.mattigunta512@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Srikanth@12345&");
		driver.findElement(By.id("login")).click(); */
		
		// for above three lines we replaced with below code using pagefactory.
		
//		LandingPage landingpage = new LandingPage(driver);
//		landingpage.goTo();
		LandingPage landingPage = launchApplication();
		ProductCatalogue productcatalogue = landingPage.loginApplication("srikanth.mattigunta512@gmail.com", "Srikanth@12345&");
		
		/*
		 * in above step what we did like for accessing the product catalogue class method we create on object
		 * to access methods in it. To avoid such code enhancements we simple create an object on landing page
		 * directly and user here.
		 * Object was created in landing page and broing that to here and added in line number 39. so don't
		 * need object for here to access methods in product catalogue class
		 *  */
		
	/*	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3")); */
		
		// for above three lines we replaced with below code using pagefactory.
		
		List<WebElement> products =productcatalogue.getProductList();
		
	 /* WebElement prod =	products.stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".mb-3 button:last-of-type")).click(); */
		
		// for above three lines we create action methods in productcatalogue class and called here.
		productcatalogue.addProductToCart(productName);
		
		// in below steps add to card message is capturing and loader is also capturing.
	/*	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));*/
		
		// for invisibility of elements we wrote a reusable method in obstract components class 
	/*	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))); */
		
		
	/*	driver.findElement(By.cssSelector("[routerlink*='cart']")).click(); */
		//cartSection h3
		
		// for line 64 we use beloce step. to click on cart.
		CartPage cartpage = productcatalogue.clickOnCart();
		
		
	/*	List<WebElement> cardProducts = driver.findElements(By.cssSelector(".cardSection h3"));
		Boolean match = cardProducts.stream().anyMatch(cardProduct->
		cardProduct.getText().equalsIgnoreCase(productName)); */
		
		// for above 3 line of code we simply in below 
		//CartPage cartpage = new CartPage(driver); // created a new class for cart section.
		Boolean match = cartpage.verifyProductDisplay(productName);
		Assert.assertTrue(match); // validations cannot go inside the pageobject calsses. they will wrote in test class only
		
	/*	driver.findElement(By.cssSelector(".totalRow button")).click(); */
		// for Line 75 we used below code for click on checkout button 
		CheckOutPages checkoutpage = cartpage.CheckOutPage();
		checkoutpage.selectCountry("india");
		confirmationPage confirmationpage = checkoutpage.submitOrder();
		String validation = confirmationpage.validateSuccessMessage();
		Assert.assertTrue(validation.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
		
	/*	Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "target").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")); */
		
		
		
		// String validation = driver.findElement(By.xpath("//h1[contains(text(),\" Thankyou for the order. \")]")).getText();
		
		driver.close();
		
	}

}
