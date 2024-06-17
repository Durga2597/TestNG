package com.hyr.groupTests;


import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Test(groups= {"all"})
public class NewTest {
	
	@Test(groups= {"smoke","sanity","windows.smoke"})
	
	public void test1() {
		System.out.println("test1");
	}
	
	@Test(groups= {"regression","sanity","windows.sanity"})
	public void test2() {
		System.out.println("test2"); 
	}
	
	@Test
	public void test3() {
		System.out.println("test3"); 
	}

}
