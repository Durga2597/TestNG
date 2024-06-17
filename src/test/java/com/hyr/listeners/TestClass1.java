package com.hyr.listeners;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ITestListenerClass.class)
public class TestClass1 {
	
	@Test                                           //passed test case
	public void testMethod1(){
		System.out.println("I'm inside testmethod1");
	}
	
	@Test                                           //failed test case
	public void testMethod2(){
		System.out.println("I'm inside testmethod2");
		AssertJUnit.assertTrue(false);
	}
	@Test(timeOut=1000)                             //failed with timeout
	public void testMethod3() throws Exception{
		Thread.sleep(2000);
		System.out.println("I'm inside testmethod3");
	}
	@Test(dependsOnMethods="testMethod3")           //skipped test case
	public void testMethod4(){
		System.out.println("I'm inside testmethod4");
	}

}
