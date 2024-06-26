package test;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners implements ITestListener {
	
	@Override
	public void onTestSuccess(ITestResult results ) {
		
		System.out.println(" test runs are passsed");
		
	}
	@Override
	public void onTestFailure(ITestResult results) {
		System.out.println(" this test is failed "+results.getName());
	}

}
