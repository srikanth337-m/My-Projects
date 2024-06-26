package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PersonaLoan {

	@Test(dependsOnMethods={"PLAPILogin"})
	public void PLWebApplicatinLogin() {
		System.out.println("login into Peronal loan web Application successfully");
	}
	
	@Test(groups={"smoke"})
	public void PLMobileApplicatinLogin() {
		System.out.println("login into Peronal loan Mobile Application successfully");
	}
	@Parameters({"URL", "username", "password"})
	@Test
	public void PLAPILogin(@Optional("default_url") String urlname, String username, String password) {
		System.out.println("login into Peronal loan API successfully");
		System.out.println(urlname);
		System.out.println(username);
		System.out.println(password);
		// by provideing orguments that parameter will falls in url and than stored in urlname variable
		// why we used @optional annotation here ? A) to run this class individually we need this annoation. 
		// if you run this tests using xml file we don't need this annotation at that time. 
	}
	
	@DataProvider
	public Object[][] getData() {
		// 1st combination is valide user name and password
		// 2nd conbimnation is no credit history.
		// 3rd combination is fraulant credit history.
		Object[][] data = new Object[3][2];
		// 1st set of data
		data[0][0]="srikanth.mattigunta337@gmail.com";
		data[0][1]="Srikanth@123&";
		// 2nd set of data
		data[1][0]="matiguntasrikanth219@gmail.com";
		data[1][1]="kjhcigdwe";
		// 3rd set of data
		data[2][0]="farudulant.history@gmail.com";
		data[2][1]="fradulant";
		return data;
		
	}
	
	// not execting now 
/*	@Test(dataProvider="gatData")
	public void dataProvider(@Optional("default_url") String user, String pass) {
		System.out.println(" data privider methods");
		System.out.println(user);
		System.out.println(pass);
	}*/
}
