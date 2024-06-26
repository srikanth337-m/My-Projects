package opps;

import org.testng.annotations.Test;

public class users extends Urls{

/*	@Test
	public void Manager() 
	{
		System.out.println("manager access credentials");
	}
	@Test
	public void VP() 
	{
		System.out.println("VP access credentials");
	}
	@Test
	public void client() 
	{
		System.out.println("client access credentials");
	}
	@Test
	public void endUser() 
	{
		System.out.println("endUser access credentials");
	}*/
	@Test
	public void runTest() 
	{
		//int a=10;
		//int b=11;
		Module2 mod = new Module2(10, 11, 8); // object created for modules2 class // this is a parametarised constructor 
		System.out.println(mod.increment()); // calling the methods in modiles2 using object 
		System.out.println(mod.decrement());
		
		// utilities ut = new utilities(8); // no need to create an object to access utility class methods.
		System.out.println(mod.multiplyfour());
		System.out.println(mod.multiplyThree());
	}
	
	
}
