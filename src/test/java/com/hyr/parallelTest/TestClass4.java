package com.hyr.parallelTest;

import org.testng.annotations.Test;

public class TestClass4 {
	@Test
	public void testMethod8(){
		System.out.println("TestClass4 >> testMethod8 >> "+ Thread.currentThread().getId());
	}
	@Test
	public void testMethod9(){
		System.out.println("TestClass4 >> testMethod9 >> "+ Thread.currentThread().getId());
	}
	@Test
	public void testMethod10(){
		System.out.println("TestClass4 >> testMethod10 >> "+ Thread.currentThread().getId());
	}
	@Test
	public void testMethod11(){
		System.out.println("TestClass4 >> testMethod11 >> "+ Thread.currentThread().getId());
	}
	

}




