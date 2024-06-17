package com.hyr.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestAttributes {
	
	@Test(invocationCount=4, threadPoolSize=2)
	public void testmethod1() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://randomuser.me/");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//li[@data-label='name']")).click();
		System.out.println("User name : " + driver.findElement(By.id("user_value")).getText());
		
		driver.findElement(By.xpath("//li[@data-label='email']")).click();
		System.out.println("Email : " + driver.findElement(By.id("user_value")).getText());
		
		
		
		
	}

}
