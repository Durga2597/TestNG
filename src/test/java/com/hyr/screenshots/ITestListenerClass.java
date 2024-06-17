package com.hyr.screenshots;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends BaseTest implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getTestContext().getName() + "_" + result.getMethod().getMethodName());
		captureScreenshot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName()+".jpg");
		
}
}
