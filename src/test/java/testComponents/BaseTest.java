package testComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Amazon.Shopping.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;// it's global variable.
	public WebDriver initilizeDriver() throws IOException 
	{
		// properties class 
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//GlobalData.properties");
		prop.load(file);
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("chrome")) 
		{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("fireFox")) 
		{
			System.setProperty("WebDriver.edge.driver", "path.exe");
			WebDriver driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) 
		{
			// write a code related to safari browser.
		}
		// below 2 steps are common for all browers so we can wrote it here 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// implicite wait at global level.
		driver.manage().window().maximize();
		return driver;
	}
	
	public LandingPage launchApplication() throws IOException {
		
		driver = initilizeDriver();
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();
		return launchApplication();
	}
}
