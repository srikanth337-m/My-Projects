package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CarLoan {

	@Test(groups={"smoke"})
	public void CarWebApplicatinLogin() {
		System.out.println("login into Car loan web Application successfully");
	}
	
	@Test
	public void CarMobileApplicatinLogin() {
		System.out.println("login into Car loan Mobile Application successfully");
	}
	
	@Test(groups={"smoke"})
	public void CarAPILogin() {
		System.out.println("login into Car loan API successfully");
		Assert.assertTrue(false);
	}
	
	@BeforeTest
	public void firtsMethod()
	{
		System.out.println("i will execute firrst");
	}
	
	@BeforeTest
	public void secondFirtsMethod()
	{
		System.out.println("i will execute Second First");
	}
	@AfterTest
	public void secondLastMethod()
	{
		System.out.println("i will execute Second last");
	}
	@AfterSuite
	public void lastMethod()
	{
		System.out.println("i will execute last");
	}
}
