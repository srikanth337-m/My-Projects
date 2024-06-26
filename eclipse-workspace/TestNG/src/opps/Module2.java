package opps;

import org.testng.annotations.Test;

public class Module2 extends utilities {

	int a;// class variable or global variable.
	int b;
/*	@Test
	public void payments()
	{
		System.out.println(" payment throught credit card");
	}
	@Test
	public void netBanking() 
	{
		System.out.println("payment through net banking");
	}
	@Test
	public void debitCard() 
	{
		System.out.println("debit card payment gatway ");
	}
	@Test
	public void UPI() 
	{
		System.out.println("UPI payment");
	}
	@Test
	public void ThirdPartyApps() 
	{
		System.out.println("Thirt party apps payment sources");
	}*/
	
	// constructor 
	
	public Module2 (int a, int b, int c) { // the orgumets here are called as instance variable 
		super(c); // parent class consructor is invoked.
		this.a=a; // usig this key word we a assignening instance variable to class variable 
		this.b=b;
	}
	public int increment()
	{
		a = a+1;
		return a;
	}
	
	public int decrement()
	{
		b = b-1;
		return b;
	}
	
}
