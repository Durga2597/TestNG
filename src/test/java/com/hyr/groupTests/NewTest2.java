package com.hyr.groupTests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class NewTest2 {
	@Test(groups= {"smoke"})
	public void test4() {
		System.out.println("test4");
	}
	@Test(groups= {"smoke","functional","sanity","ios.smoke"})
	public void test5() {
		System.out.println("test5"); 
	}
	@Test(groups= {"functional","regression","windows.functional","ios.functional"})
	public void test6() {
		System.out.println("test6"); 
	}
}
